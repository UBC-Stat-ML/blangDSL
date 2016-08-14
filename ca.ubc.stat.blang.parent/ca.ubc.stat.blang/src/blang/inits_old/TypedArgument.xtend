package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.Optional
import java.util.List

@Data
class TypedArgument { // the complete (typed) specification of a command line argument
  val QualifiedName qualName
  val Class<?> type // if primitive, use boxed type
  val Optional<ParsedArguments> defaultValue // no value means it's required
  val String description
}