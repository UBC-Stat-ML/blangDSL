package blang.inits.strategies

import blang.inits.InstantiationStrategy
import blang.inits.Instantiator.InstantiationContext
import java.util.Optional
import blang.inits.ArgumentSpecification
import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import blang.inits.InitResult
import java.lang.reflect.Field
import blang.inits.Arg
import java.lang.reflect.Type
import blang.inits.Default
import blang.inits.Arguments
import blang.inits.Arguments.ArgumentItem
import java.util.List
import java.util.ArrayList
import ca.ubc.stat.blang.StaticUtils

class FeatureAnnotation implements InstantiationStrategy {
  
  override String formatDescription(InstantiationContext context) {
    return ""
  }
  
  // TODO: add support for setter method calls as well
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(InstantiationContext context, Set<String> providedChildrenKeys) {
    val LinkedHashMap<String, ArgumentSpecification> result = new LinkedHashMap
    // TODO: later could do better than that by not going right away to raw type
    val Class<?> type = context.rawType
    for (Field field : type.declaredFields.filter[!it.getAnnotationsByType(Arg).isEmpty]) {
      val Arg arg = field.getAnnotationsByType(Arg).get(0)
      val Type childType = field.genericType
      val ArgumentSpecification spec = new ArgumentSpecification(childType, readDefault(field.getAnnotationsByType(Default)), arg.description)
      val String name = field.name
      result.put(name, spec)
    }
    return result
  }
  
  def public static Optional<Arguments> readDefault(Default [] defaults) {
    if (defaults.isEmpty) {
      return Optional.empty
    }
    val List<ArgumentItem> items = new ArrayList
    for (Default d : defaults) { 
      items.add(new ArgumentItem(d.key, d.value))
    }
    return Optional.of(Arguments.parse(items))
  }
  
  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val Class<?> rawType = context.rawType
    val Object result = rawType.newInstance
    return instantiate(context, instantiatedChildren, result)
  }
  
  def InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren, Object instance) {
    val Class<?> rawType = context.rawType
    for (Field field : rawType.declaredFields.filter[!it.getAnnotationsByType(Arg).isEmpty]) {
      StaticUtils::setFieldValue(field, instance, instantiatedChildren.get(field.name))
    }
    return InitResult.success(instance)
  }
  
  override boolean acceptsInput(InstantiationContext context) {
    return false
  }
  
}