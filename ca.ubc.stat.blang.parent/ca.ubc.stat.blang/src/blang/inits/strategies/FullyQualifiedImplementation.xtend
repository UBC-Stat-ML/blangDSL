package blang.inits.strategies

import blang.inits.InstantiationStrategy
import org.eclipse.xtend.lib.annotations.Delegate

class FullyQualifiedImplementation implements InstantiationStrategy {
  
  @Delegate
  val SelectImplementation implementation = new SelectImplementation(true, true)
  
}