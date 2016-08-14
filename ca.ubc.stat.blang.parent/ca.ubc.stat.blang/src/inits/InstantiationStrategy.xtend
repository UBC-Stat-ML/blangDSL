package inits

import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import inits.Instantiator.InstantiationContext
import java.util.Optional

interface InstantiationStrategy<T> {
  
  /**
   * Human-redable description of the format expected by this strategy
   */
  def String formatDescription(InstantiationContext context)
  
  def boolean acceptsInput()
  
  def LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context,
    Set<String> providedChildrenKeys
  )
  
  def InitResult<T> instantiate(
    InstantiationContext context,
    Map<String, Object> instantiatedChildren
  )
  
}