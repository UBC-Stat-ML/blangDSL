package inits.strategies

import com.google.common.base.Joiner
import inits.ArgumentSpecification
import inits.Implementation
import inits.InitResult
import inits.InstantiationStrategy
import inits.Instantiator.InstantiationContext
import java.util.LinkedHashMap
import java.util.List
import java.util.Map
import java.util.Optional
import java.util.Set

class SelectImplementation implements InstantiationStrategy {
  
  val public static String DEFAULT_KEY = "default"
  
  override String formatDescription(InstantiationContext context) {
    val ImplementationSpec spec = readImplementations(context)
    return Joiner.on("|").join(spec.implementations.keySet)
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    // pick the implementation
    val ImplementationSpec spec = readImplementations(context)
    val Class<?> impl = spec.pickImplementation(context.argumentValue)
    
    // consume
    val InstantiationContext consumed = context.newInstance(impl, Optional.empty)
    return context.getInstantiationStrategy(impl).childrenSpecifications(consumed, providedChildrenKeys)
  }
  
  override InitResult instantiate(
    InstantiationContext context, 
    Map<String, Object> instantiatedChildren
  ) {
    // pick the implementation
    val ImplementationSpec spec = readImplementations(context)
    val Class<?> impl = spec.pickImplementation(context.argumentValue)
    
    // consume
    val InstantiationContext consumed = context.newInstance(impl, Optional.empty)
    return context.getInstantiationStrategy(impl).instantiate(consumed, instantiatedChildren)
  }
  
  override boolean acceptsInput() {
    return true 
  }
  
  static private class ImplementationSpec {
    var Map<String, Class<?>> implementations = new LinkedHashMap
    var Optional<Class<?>> defaultImpl = Optional.empty
  
    def Class<?> pickImplementation(Optional<List<String>> optional) {
      if (optional.isPresent) {
        val String argument = Joiner.on(" ").join(optional.get)
        for (String key : implementations.keySet) {
          if (argument.matches("\\s*" + key + "\\s*")) {  // TODO: avoid regex
            return implementations.get(key)
          }
        }
        throw new RuntimeException("Key not found: " + argument)
      }
      // default then?
      if (defaultImpl.present) {
        return defaultImpl.get
      }
      // not found
      throw new RuntimeException("No implementation key provided, and there is no default value defined")
    }
  
  }
  
  def ImplementationSpec readImplementations(InstantiationContext context) {
    val ImplementationSpec result = new ImplementationSpec
    val Class<?> type = context.rawType
    for (Implementation impl : type.getAnnotationsByType(Implementation)) {
      if (impl.key == DEFAULT_KEY) {
        if (result.defaultImpl.present) {
          throw new RuntimeException("The cannot be two default implementations")
        }
        result.defaultImpl = Optional.of(impl.value)
      }
      if (result.implementations.keySet.contains(impl.key)) {
        throw new RuntimeException("Implementation keys should be distinct")
      }
      result.implementations.put(impl.key, impl.value)
    }
    return result
  }
  

  
}