package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.lang.reflect.Type
import java.util.LinkedHashMap
import java.util.Map
import java.lang.reflect.ParameterizedType
import java.lang.reflect.TypeVariable
import java.lang.reflect.WildcardType
import java.lang.reflect.GenericArrayType
import java.util.HashMap
import java.util.List
import java.util.Set
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Optional
import java.util.ArrayList
import com.google.common.base.Joiner
import blang.inits.strategies.Combined

class Instantiator {
  
  @Accessors(PUBLIC_GETTER)
  val Map<String, Object> globals = new HashMap
  
  val InstantiationStrategy defaultInitializationStrategy = new Combined
  
  @Accessors(PUBLIC_GETTER)
  val Map<Class<?>,InstantiationStrategy> strategies = new HashMap
  
  @Accessors(PUBLIC_SETTER)
  var boolean debug = false
  
  
  def <T> Optional<T> init(Type type, Arguments arguments) {
    _type = type
    _arguments = arguments
    lastInitTree = _init(type, arguments) as InitTree
    return lastInitTree.initResult.result as Optional
  }
  
  // info from last call of init
  var InitTree lastInitTree = null
  var Type _type = null
  var Arguments _arguments = null
  
  def public String lastInitReport() {
    val List<String> result = new ArrayList
    val ArgumentSpecification rootSpec = new ArgumentSpecification(_type, Optional.empty, "")
    lastInitReport(result, rootSpec, _arguments, lastInitTree)
    return Joiner.on("\n").join(result) + "\n"
  }
  
  def private void lastInitReport(
    List<String> result, 
    ArgumentSpecification specifications, 
    Arguments currentArguments,
    InitTree initTree
  ) {
    val StringBuilder builder = new StringBuilder
    val currentType = specifications.type
    val InstantiationContext context = new InstantiationContext(this, currentType, currentArguments)
    val InstantiationStrategy strategy = getInstantiationStrategy(currentType)
    if (!currentArguments.getQName().isRoot() || strategy.acceptsInput(context)) {
      if (strategy.acceptsInput(context)) {
        builder.append(qualifiedNameToString(currentArguments) + " <" + currentType.typeName + " : " + strategy.formatDescription(context) + ">\n")
      } else {
        builder.append("group " + currentArguments.getQName() + "\n")
      }
      builder.append("  description: " + specifications.description + "\n")
      if (specifications.defaultArguments.present) {
        builder.append("  not mandatory, default is: " + specifications.defaultArguments.get + "\n")
      } else {
        builder.append("  mandatory\n")
      }
      if (initTree !== null && initTree.initResult.errorMessage.present) {
        builder.append("  error message: " + initTree.initResult.errorMessage.get + "\n")
      }
      result.add(builder.toString)
    }
    // recurse  
    try {  
      val LinkedHashMap<String, ArgumentSpecification> childrenSpecifications = 
        strategy.childrenSpecifications(context, currentArguments.childrenKeys)
      for (String childName : childrenSpecifications.keySet) {
        val InitTree subTree = 
          if (initTree === null) {
            null
          } else {
            initTree.children.children.get(childName)
          }
        lastInitReport(result, childrenSpecifications.get(childName), currentArguments.child(childName), subTree)
      }
    } catch (Exception e) {}
  }

  def private String qualifiedNameToString(Arguments arg) {
    if (arg.getQName.isRoot()) {
      return "<root>"
    } else {
      return "--" + arg.getQName
    }
  }
  
  static class InitChildren {
    // null when it was missing
    val Map<String, InitTree> children = new HashMap
    val Set<String> missings = new HashSet
    
    def private addChild(String childName, InitTree child) {
      children.put(childName, child)
    }
    def private addMissing(String childName) {
      missings.add(childName)
    }
    def boolean childComplete() {
      var brokenChildDetected = false
      for (InitTree childTree : children.values) {
        if (childTree.initResult.success === false) {
          brokenChildDetected = true
        }
      }
      return !brokenChildDetected && missings.isEmpty
    }
    def Map<String,Object> instantiatedChildren() {
      val Map<String,Object> result = new HashMap
      for (String key : children.keySet) {
        result.put(key, children.get(key).initResult.result.get())
      }
      return result
    }
  }
  
  @Data
  static class InitTree {
    val InitResult initResult
    val InitChildren children
  }
  
  def private InitTree _init(
    Type currentType, 
    Arguments currentArguments
  ) {
    val InstantiationContext context = new InstantiationContext(this, currentType, currentArguments)
    val InitChildren children = new InitChildren
    val InstantiationStrategy strategy = getInstantiationStrategy(currentType)
    val LinkedHashMap<String, ArgumentSpecification> childrenSpecifications = 
      try {
        strategy.childrenSpecifications(context, currentArguments.childrenKeys) 
      } catch (Exception e) {
        return new InitTree(InitResult.failure(e.toString), new InitChildren)
      }
    for (String childName : childrenSpecifications.keySet) {
      val ArgumentSpecification childSpec = childrenSpecifications.get(childName)
      // check if subtree of Argument has anything at all (contents or further children)
      if (currentArguments.childrenKeys.contains(childName)) {
        // if so, recurse
        children.addChild(childName, _init(childSpec.type, currentArguments.child(childName)))
      } else if (globals.containsKey(childName)) {
        children.addChild(childName, new InitTree(InitResult.success(globals.get(childName)), new InitChildren))
      } else {
        // if not, check if default is provided
        if (childSpec.defaultArguments.isPresent()) {
           val InitTree fromDefault = _init(childSpec.type, childSpec.defaultArguments.get())
           if (fromDefault.initResult.isSuccess) {
             // use the default value
             children.addChild(childName, fromDefault)
           } else {
             // throw an exception if a default value is faulty
             throw new RuntimeException("Faulty initialization: " + fromDefault.initResult.errorMessage) // TODO: implement and use InitResult.toString
           }
        } else {
           // missing arguments
           children.addMissing(childName)
        }
      }
    } // end for
    
    // check all parsed child names are in the specs
    val boolean allChildNamesRecognized = childrenSpecifications.keySet.containsAll(currentArguments.childrenKeys)
    
    val InitResult initResult = 
      if (!allChildNamesRecognized) {
        InitResult.failure(UNKNOWN_ARGUMENTS)  // TODO: print the culpits 
      }
      else if (children.childComplete) {
        try {
          val InitResult initResult = strategy.instantiate(context, children.instantiatedChildren)
          val boolean hasArgValue = currentArguments.argumentValue.present
          val boolean acceptsInput = strategy.acceptsInput(context)
          if (hasArgValue && !acceptsInput) {
            InitResult.failure(UN_NECESSARY_VALUE)
          } else {
            initResult
          }
        } catch (Exception e) {
          if (debug) {
            e.printStackTrace
          }
          InitResult.failure(e.toString)
        }
      } else {
        InitResult.failure(MISSING_CHILD)
      }
    
    return new InitTree(initResult, children)
  }
  
  val public static String MISSING_CHILD = "Failed to initialize child object(s)"
  val public static String UNKNOWN_ARGUMENTS = "Unknown argument(s)"
  val public static String UN_NECESSARY_VALUE = "The strategy expected no argument but one was provided. Check syntax and make sure an instantiation strategy was provided."
  
  def static Class<?> getRawClass(Type type) {
    switch type {
      Class<?> :            return type
      ParameterizedType :   return type.rawType as Class<?>
      TypeVariable<?> :     throw new RuntimeException
      WildcardType :        throw new RuntimeException
      GenericArrayType :    throw new RuntimeException
      default : throw new RuntimeException
    }
  }
  
  def private InstantiationStrategy getInstantiationStrategy(Type type) {
    val typeToInitialize = getRawClass(type)
    // 1 - check in DB
    val InstantiationStrategy strategyInDB = strategies.get(typeToInitialize)
    if (strategyInDB !== null) {
      return strategyInDB
    }
    // 2 - use InitVia annotation
    val InitVia [] annotations = typeToInitialize.getAnnotationsByType(InitVia)
    if (annotations.size > 0) 
      return annotations.get(0).value.newInstance
    // 3 - back to default
    return defaultInitializationStrategy
  }
  
  @Data
  static class InstantiationContext {
    val Instantiator instantiator
    
    @Accessors(PUBLIC_GETTER)
    val Type requestedType
    
    val Arguments arguments

    def Optional<List<String>> getArgumentValue() {
      return arguments.argumentValue
    }
    
    def InstantiationStrategy getInstantiationStrategy(Type type) {
      return instantiator.getInstantiationStrategy(type)
    }
    
    def InstantiationContext implementationContext(Type implementationType, boolean consumeValue) {
      return new InstantiationContext(instantiator, implementationType, arguments.consumeValue)
    }
    
    def Class<?> rawType() {
      return getRawClass(requestedType)
    }
  }
  
}