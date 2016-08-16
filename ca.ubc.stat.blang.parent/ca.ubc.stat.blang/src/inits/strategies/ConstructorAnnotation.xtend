package inits.strategies

import inits.ArgumentSpecification
import inits.ConstructorArg
import inits.Default
import inits.DesignatedConstructor
import inits.InitResult
import inits.InstantiationStrategy
import inits.Instantiator.InstantiationContext
import java.lang.reflect.Constructor
import java.lang.reflect.Parameter
import java.lang.reflect.Type
import java.util.LinkedHashMap
import java.util.Map
import java.util.Optional
import java.util.Set

class ConstructorAnnotation implements InstantiationStrategy {
  
  override String formatDescription(InstantiationContext context) {
    return ""
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    val Constructor<?> designatedConstructor = getConstructor(context)
    val LinkedHashMap<String, ArgumentSpecification> result = new LinkedHashMap
    for (Parameter p : designatedConstructor.parameters) {
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
    val Constructor<?> designatedConstructor = getConstructor(context)
    val Object [] sortedArguments = newArrayOfSize(instantiatedChildren.size)
    var int i = 0
    for (String key : childrenSpecifications(context, instantiatedChildren.keySet).keySet) {
      sortedArguments.set(i++, instantiatedChildren.get(key))
    }
    return InitResult.success(designatedConstructor.newInstance(sortedArguments))
  }
  
  def static Constructor<?> getConstructor(InstantiationContext context) {
    var Optional<Constructor<?>> found = Optional.empty
    for (Constructor<?> c : context.rawType.constructors) {
      if (!c.getAnnotationsByType(DesignatedConstructor).empty) {
        if (found.present) {
          throw new RuntimeException("Not more than one constructor should be marked with @" + DesignatedConstructor.simpleName)
        }
        found = Optional.of(c)
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