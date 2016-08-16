package blang.inits.strategies

import blang.inits.ArgumentSpecification
import blang.inits.InitResult
import blang.inits.InstantiationStrategy
import blang.inits.Instantiator.InstantiationContext
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.Map
import java.util.Set

/**
 * Combines:
 * 
 * (1) DefaultImplementation (if it's an interface)
 * (2) ConstructorAnnotation
 * (3) FeatureAnnotation (applied on the outcome of (2))
 */
class Combined implements InstantiationStrategy {
  
  override String formatDescription(InstantiationContext context) {
    if (context.rawType.isInterface) {
      return new DefaultImplementation().formatDescription(context)
    } else {
      return new ConstructorAnnotation().formatDescription(context)
    }    
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    if (context.rawType.isInterface) {
      return new DefaultImplementation().childrenSpecifications(context, providedChildrenKeys)
    }
    
    val LinkedHashMap<String, ArgumentSpecification> result = new LinkedHashMap
    result.putAll(new ConstructorAnnotation().childrenSpecifications(context, providedChildrenKeys))
    val LinkedHashMap<String, ArgumentSpecification> other = new FeatureAnnotation().childrenSpecifications(context, providedChildrenKeys)
    for (String otherKey : other.keySet) {
      if (result.containsKey(otherKey)) {
        throw new RuntimeException("Constructor argument names and field names should be distinct")
      }
      result.put(otherKey, other.get(otherKey))
    }
    return result
  }

  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    if (context.rawType.isInterface) {
      return new DefaultImplementation().instantiate(context, instantiatedChildren)
    }
    val Set<String> keys1 = new ConstructorAnnotation().childrenSpecifications(context, instantiatedChildren.keySet).keySet
    val Map<String, Object> reducedInstantiatedChildren1 = new HashMap
    val Map<String, Object> reducedInstantiatedChildren2 = new HashMap
    for (String key : instantiatedChildren.keySet) {
      if (keys1.contains(key)) {
        reducedInstantiatedChildren1.put(key, instantiatedChildren.get(key))
      } else {
        reducedInstantiatedChildren2.put(key, instantiatedChildren.get(key))
      }
    }
    val InitResult result = new ConstructorAnnotation().instantiate(context, reducedInstantiatedChildren1) 
    if (!result.success) {
      return result
    }
    return new FeatureAnnotation().instantiate(context, reducedInstantiatedChildren2, result.result.get)
  }
  
  override boolean acceptsInput(InstantiationContext context) {
    if (context.rawType.isInterface) {
      return new DefaultImplementation().acceptsInput(context)
    } else {
      return new ConstructorAnnotation().acceptsInput(context)
    }  
  }
}