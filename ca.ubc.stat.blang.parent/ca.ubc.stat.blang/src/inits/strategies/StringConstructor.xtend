package inits.strategies

import inits.InstantiationStrategy
import inits.Instantiator.InstantiationContext
import java.util.Set
import java.util.Map
import inits.InitResult
import java.util.Optional
import java.util.LinkedHashMap
import inits.ArgumentSpecification
import java.lang.reflect.Constructor
import com.google.common.base.Joiner

class StringConstructor<T> implements InstantiationStrategy<T> {
  
  override String formatDescription(InstantiationContext context) {
    return "Any string(s)"
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(InstantiationContext context, Set<String> providedChildrenKeys) {
    return new LinkedHashMap
  }
  
  override InitResult<T> instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val Constructor<T> constructor = context.rawType.getConstructor(String) as Constructor<T>
    val String argument = Joiner.on(" ").join(context.argumentValue.get)
    return InitResult.success(constructor.newInstance(#[argument]))
  }
  
  override boolean acceptsInput() {
    return true
  }
  
}