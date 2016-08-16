package blang.inits

import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import blang.inits.Instantiator.InstantiationContext

interface InstantiationStrategy {
  
  /**
   * Human-redable description of the format expected by this strategy
   */
  def String formatDescription(InstantiationContext context)
  
  def boolean acceptsInput(InstantiationContext context)
  
  def LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context,
    Set<String> providedChildrenKeys
  )
  
  def InitResult instantiate(
    InstantiationContext context,
    Map<String, Object> instantiatedChildren
  )
  
}