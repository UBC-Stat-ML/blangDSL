package blang.inits.strategies.parsers

import blang.inits.strategies.Parser
import java.util.Optional
import java.util.List
import blang.inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class LongParser implements Parser<Long> {
  
  override parse(Optional<List<String>> arguments) {
    val String argument = Joiner.on(" ").join(arguments.get)
    if (argument.matches("\\s*INF\\s*")) {
      return Long.MAX_VALUE
    } else {
      return Long.parseLong(argument)
    }
  }
  
  override formatDescription(InstantiationContext context) {
    return "A number or INF"
  }
  
}