package blang.inits.strategies

import blang.inits.ArgumentSpecification
import blang.inits.ConstructorArg
import blang.inits.Default
import blang.inits.InitResult
import blang.inits.InstantiationStrategy
import blang.inits.Instantiator.InstantiationContext
import java.lang.reflect.Constructor
import java.lang.reflect.Parameter
import java.lang.reflect.Type
import java.util.LinkedHashMap
import java.util.Map
import java.util.Optional
import java.util.Set
import java.lang.reflect.Method
import org.eclipse.xtend.lib.annotations.Data
import blang.inits.DesignatedConstructor

class ConstructorAnnotation implements InstantiationStrategy {
  
  override String formatDescription(InstantiationContext context) {
    return ""
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    val Builder builder = getConstructor(context)
    val LinkedHashMap<String, ArgumentSpecification> result = new LinkedHashMap
    for (Parameter p : builder.parameters) {
      val ConstructorArg [] args = p.getAnnotationsByType(ConstructorArg)
      if (args.size != 1) {
        throw new RuntimeException("Each argument of the designated constructor should have exactly one annotation @" + ConstructorArg.simpleName)
      }
      val ConstructorArg arg = args.get(0)
      val Type childType = p.parameterizedType
      val ArgumentSpecification spec = new ArgumentSpecification(childType, FeatureAnnotation::readDefault(p.getAnnotationsByType(Default)), arg.description)
      val String name = arg.value
      result.put(name, spec)
    }
    return result
  }

  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val Builder builder = getConstructor(context)
    val Object [] sortedArguments = newArrayOfSize(instantiatedChildren.size)
    var int i = 0
    for (String key : childrenSpecifications(context, instantiatedChildren.keySet).keySet) {
      sortedArguments.set(i++, instantiatedChildren.get(key))
    }
    return InitResult.success(builder.build(sortedArguments))
  }
  
  static interface Builder {
    def Object build(Object ... arguments)
    def Iterable<Parameter> parameters()
  }
  
  @Data
  static class ConstructorBuilder implements Builder {
    val Constructor<?> constructor
    override Object build(Object... arguments) {
      return constructor.newInstance(arguments)
    }
    override Iterable<Parameter> parameters() {
      return constructor.parameters
    }
  }
  
  @Data
  static class FactoryMethod implements Builder {
    val Method staticBuilder
    override Object build(Object... arguments) {
      return staticBuilder.invoke(null, arguments)
    }
    override Iterable<Parameter> parameters() {
      return staticBuilder.parameters
    }
    
  }
  
  def static Builder getConstructor(InstantiationContext context) {
    var Optional<Builder> found = Optional.empty
    for (Constructor<?> c : context.rawType.constructors) {
      if (!c.getAnnotationsByType(DesignatedConstructor).empty) {
        if (found.present) {
          throw new RuntimeException("Not more than one constructor/static factory should be marked with @" + DesignatedConstructor.simpleName)
        }
        found = Optional.of(new ConstructorBuilder(c))
      }
    }
    for (Method m : context.rawType.methods) {
      if (!m.getAnnotationsByType(DesignatedConstructor).empty) {
        if (found.present) {
          throw new RuntimeException("Not more than one constructor/static factory should be marked with @" + DesignatedConstructor.simpleName)
        }
        found = Optional.of(new FactoryMethod(m))
      } 
    }
    if (found.present) {
      return found.get
    } else {
      throw new RuntimeException("One of the constructors should be marked with @" + DesignatedConstructor.simpleName)
    }
  }
  
  override boolean acceptsInput() {
    return false
  }
  
}