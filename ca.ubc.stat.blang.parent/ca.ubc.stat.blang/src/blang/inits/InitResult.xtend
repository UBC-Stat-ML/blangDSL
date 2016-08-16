package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.Optional

@Data
class InitResult {
  
  val Optional<Object> result
  val Optional<String> errorMessage
  
  def static <T> InitResult success(T result) {
    return new InitResult(Optional.of(result), Optional.empty)
  }
  
  def static <T> InitResult failure(String message) {
    return new InitResult(Optional.empty, Optional.of(message))
  }
  
  def boolean isSuccess() {
    return result.isPresent()
  }

}