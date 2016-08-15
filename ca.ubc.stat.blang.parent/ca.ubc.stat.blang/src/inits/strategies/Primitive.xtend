package inits.strategies

import inits.InstantiationStrategy
import inits.Instantiator.InstantiationContext
import java.util.Set
import java.util.Map
import inits.InitResult
import java.util.LinkedHashMap
import inits.ArgumentSpecification
import org.eclipse.xtend.lib.annotations.Data

@Data
class Primitive<T> implements InstantiationStrategy {
  
  val Class<T> type
  val Parser<T> parser
  
  override String formatDescription(InstantiationContext context) {
    return parser.formatDescription(context)
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(InstantiationContext context, Set<String> providedChildrenKeys) {
    return new LinkedHashMap
  }
  
  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val T parsed = parser.parse(context.argumentValue)
    return InitResult.success(parsed)
  }
  
  override boolean acceptsInput() {
    return true
  }
  
}