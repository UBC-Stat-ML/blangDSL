package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.Optional
import java.util.List

@Data
class InitResult<T> {
  val Optional<T> instantiated
  
  
  
  // status: filled, unfilled but has default, unfilled no default
}