package inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.Optional

@Data
class InitResult<T> {
  
  val Optional<T> result
  val Optional<String> errorMessage
  
  def static <T> InitResult<T> success(T result) {
    return new InitResult<T>(Optional.of(result), Optional.empty)
  }
  
  def static <T> InitResult<T> failure(String message) {
    return new InitResult<T>(Optional.empty, Optional.of(message))
  }
  
  def boolean isSuccess() {
    return result.isPresent()
  }

}