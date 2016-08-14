package inits

import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import inits.Instantiator.InstantiationContext
import java.util.Optional

interface InstantiationStrategy<T> {
  
  /**
   * Null if this strategy does not consume input, otherwise a human-readable description of the format
   */
  def Optional<String> formatDescription(InstantiationContext context)
  
  def LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context,
    Set<String> providedChildrenKeys
  )
  
  def InitResult<T> instantiate(
    InstantiationContext context,
    Map<String, Object> instantiatedChildren
  )
  
}