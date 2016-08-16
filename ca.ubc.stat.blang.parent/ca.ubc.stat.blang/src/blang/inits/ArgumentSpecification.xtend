package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.lang.reflect.Type
import java.util.Optional

@Data
class ArgumentSpecification {
  val Type type
  val Optional<Arguments> defaultArguments
  val String description
}