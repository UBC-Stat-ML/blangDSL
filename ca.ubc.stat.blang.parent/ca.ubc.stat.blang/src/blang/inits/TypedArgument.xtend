package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.Optional
import java.util.List

@Data
class TypedArgument {
  val QualifiedName qualName
  val Class<?> type // if primitive, use boxed type
  val Optional<String> defaultValue // no value mean it's required
  val String description
}