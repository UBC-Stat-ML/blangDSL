package blang.inits.strategies

import blang.inits.InstantiationStrategy
import org.eclipse.xtend.lib.annotations.Delegate

class DefaultImplementation implements InstantiationStrategy { 
  
  @Delegate
  val SelectImplementation implementation = new SelectImplementation(false, false)
  
}