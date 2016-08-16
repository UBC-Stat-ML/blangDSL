package blang.inits.strategies

import com.google.common.base.Joiner
import blang.inits.ArgumentSpecification
import blang.inits.Implementation
import blang.inits.InitResult
import blang.inits.InstantiationStrategy
import blang.inits.Instantiator.InstantiationContext
import java.util.LinkedHashMap
import java.util.List
import java.util.Map
import java.util.Optional
import java.util.Set
import com.ibm.icu.lang.UScript.ScriptUsage

/**
 * Limitation of the select version: consumes all the input. Use DefaultImplementation 
 * strategy instead (which just uses this with the right switch turned on).
 * 
 * TODO: Perhaps later do something where just the first item in the list is used
 * Before then, just do not document that feature yet.
 */
class SelectImplementation implements InstantiationStrategy {
  
  val public static String DEFAULT_KEY = "default"
  val boolean allowMultiple
  val boolean useFullyQualified
  
  new() {
    this.allowMultiple = true
    this.useFullyQualified = false
  }
  
  new(boolean allowMultiple, boolean useFullyQualified) {
    this.allowMultiple = allowMultiple
    this.useFullyQualified = useFullyQualified
  }
  
  override String formatDescription(InstantiationContext context) {
    if (allowMultiple) {
      if (useFullyQualified) {
        return "Fully qualified type implementing " + context.rawType.name
      } else {
        // print the choice of implementation
        val ImplementationSpec spec = readImplementations(context)
        return Joiner.on("|").join(spec.implementations.keySet)
      }
    } else {
      // just forward to the implementation
      val ImplementationSpec spec = readImplementations(context)
      val Class<?> impl = spec.pickImplementation(context.argumentValue, useFullyQualified)
      context.getInstantiationStrategy(impl).formatDescription(context)
    }
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    // pick the implementation
    val ImplementationSpec spec = readImplementations(context)
    val Class<?> impl = spec.pickImplementation(context.argumentValue, useFullyQualified)
    
    if (!allowMultiple && spec.implementations.size !== 1) {
      throw new RuntimeException("Only one implementation allowed.")
    }
    
    return context.getInstantiationStrategy(impl).childrenSpecifications(childContext(context), providedChildrenKeys)
  }
  
  override InitResult instantiate(
    InstantiationContext context, 
    Map<String, Object> instantiatedChildren
  ) {
    // pick the implementation
    val ImplementationSpec spec = readImplementations(context)
    val Class<?> impl = spec.pickImplementation(context.argumentValue, useFullyQualified)
    
    return context.getInstantiationStrategy(impl).instantiate(childContext(context), instantiatedChildren)
  }
  
  // if the implementation name was read, consume the argument
  def InstantiationContext childContext(InstantiationContext context) {
    val ImplementationSpec spec = readImplementations(context)
    val Class<?> impl = spec.pickImplementation(context.argumentValue, useFullyQualified)
    if (allowMultiple) 
      return context.newInstance(impl, Optional.empty)
    else
      return context
  }
  
  override boolean acceptsInput(InstantiationContext context) {
    if (allowMultiple) {
      return true
    } else {
      val ImplementationSpec spec = readImplementations(context)
      val Class<?> impl = spec.pickImplementation(context.argumentValue, useFullyQualified)
      context.getInstantiationStrategy(impl).acceptsInput(context)
    }
  }
  
  static private class ImplementationSpec {
    var Map<String, Class<?>> implementations = new LinkedHashMap
    var Optional<Class<?>> defaultImpl = Optional.empty
  
    def Class<?> pickImplementation(Optional<List<String>> optional, boolean useQual) {
      if (optional.isPresent && !useQual) {
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
    if (useFullyQualified) {
      val String argument = Joiner.on(" ").join(context.argumentValue.get)
      result.defaultImpl = Optional.of(Class.forName(argument))
    } else {
      for (Implementation impl : type.getAnnotationsByType(Implementation)) {
        if (impl.key == DEFAULT_KEY) {
          if (result.defaultImpl.present) {
            throw new RuntimeException("There cannot be two default implementations")
          }
          result.defaultImpl = Optional.of(impl.value)
        }
        if (result.implementations.keySet.contains(impl.key)) {
          throw new RuntimeException("Implementation keys should be distinct")
        }
        result.implementations.put(impl.key, impl.value)
      }
    }
    return result
  }
  

  
}