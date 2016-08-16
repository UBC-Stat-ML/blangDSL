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
import blang.inits.strategies.FeatureAnnotation
import java.util.Optional
import java.util.ArrayList
import com.google.common.base.Joiner

class Instantiator<T> {
  
  val Type _type
  val Arguments _arguments
  
  @Accessors(PUBLIC_GETTER)
  val Map<String, Object> globals = new HashMap
  
  val InstantiationStrategy defaultInitializationStrategy
  
  @Accessors(PUBLIC_GETTER)
  val Map<Class<?>,InstantiationStrategy> strategies = new HashMap
  
  @Accessors(PUBLIC_SETTER)
  var boolean debug = false
  
  new(Type _type, Arguments _arguments) {
    this._type = _type
    this._arguments = _arguments
    this.defaultInitializationStrategy = new FeatureAnnotation
  }
  
  var InitTree lastInitTree = null
  def Optional<T> init() {
    lastInitTree = init(_type, _arguments) as InitTree
    return lastInitTree.initResult.result as Optional
  }
  
  def public String lastInitReport() {
    val List<String> result = new ArrayList
    val ArgumentSpecification rootSpec = new ArgumentSpecification(_type, Optional.empty, "")
    lastInitReport(result, rootSpec, new ArrayList, _arguments, lastInitTree)
    return Joiner.on("\n").join(result) + "\n"
  }
  
  def private void lastInitReport(
    List<String> result, 
    ArgumentSpecification specifications, 
    List<String> qualifiedName,
    Arguments currentArguments,
    InitTree initTree
  ) {
    val StringBuilder builder = new StringBuilder
    val currentType = specifications.type
    val InstantiationContext context = new InstantiationContext(this, currentType, currentArguments.argumentValue)
    val InstantiationStrategy strategy = getInstantiationStrategy(currentType)
    if (!qualifiedName.empty || strategy.acceptsInput(context)) {
      if (strategy.acceptsInput(context)) {
        builder.append(qualifiedNameToString(qualifiedName) + " <" + currentType.typeName + " : " + strategy.formatDescription(context) + ">\n")
      } else {
        builder.append("group " + Joiner.on(".").join(qualifiedName) + "\n")
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
    val LinkedHashMap<String, ArgumentSpecification> childrenSpecifications = 
      strategy.childrenSpecifications(context, currentArguments.childrenKeys)
    for (String childName : childrenSpecifications.keySet) {
      val InitTree subTree = 
        if (initTree === null) {
          null
        } else {
          initTree.children.children.get(childName)
        }
      lastInitReport(result, childrenSpecifications.get(childName), qualName(qualifiedName, childName), currentArguments.child(childName), subTree)
    }
  }
  
  def private List<String> qualName(List<String> prefix, String name) {
    val List<String> result = new ArrayList
    result.addAll(prefix)
    result.add(name)
    return result
  }
  
  def private String qualifiedNameToString(List<String> prefix) {
    if (prefix.empty) {
      return "<root>"
    } else {
      return "--" + Joiner.on(".").join(prefix)
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
  
  def private InitTree init(
    Type currentType, 
    Arguments currentArguments
  ) {
    val InstantiationContext context = new InstantiationContext(this, currentType, currentArguments.argumentValue)
    val InitChildren children = new InitChildren
    val InstantiationStrategy strategy = getInstantiationStrategy(currentType)
    val LinkedHashMap<String, ArgumentSpecification> childrenSpecifications = 
      strategy.childrenSpecifications(context, currentArguments.childrenKeys)
    for (String childName : childrenSpecifications.keySet) {
      val ArgumentSpecification childSpec = childrenSpecifications.get(childName)
      // check if subtree of Argument has anything at all (contents or further children)
      if (currentArguments.childrenKeys.contains(childName)) {
        // if so, recurse
        children.addChild(childName, init(childSpec.type, currentArguments.child(childName)))
      } else if (globals.containsKey(childName)) {
        children.addChild(childName, new InitTree(InitResult.success(globals.get(childName)), new InitChildren))
      } else {
        // if not, check if default is provided
        if (childSpec.defaultArguments.isPresent()) {
           val InitTree fromDefault = init(childSpec.type, childSpec.defaultArguments.get())
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
      ParameterizedType :   return type.rawClass
      TypeVariable<?> :     return type.rawClass
      WildcardType :        return type.rawClass
      GenericArrayType :    return type.rawClass
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
    val Instantiator<?> instantiator
    
    @Accessors(PUBLIC_GETTER)
    val Type requestedType
    
    /**
     * null if the switch key was not provided
     */
    @Accessors(PUBLIC_GETTER)
    val Optional<List<String>> argumentValue
    
    def public getInstantiationStrategy(Type type) {
      return instantiator.getInstantiationStrategy(type)
    }
    
    def public InstantiationContext newInstance(Type requestedType, Optional<List<String>> argumentValue) {
      return new InstantiationContext(instantiator, requestedType, argumentValue)
    }
    
    def public Class<?> rawType() {
      return getRawClass(requestedType)
    }
  }
  
}