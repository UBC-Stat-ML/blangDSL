package blang.inits.strategies.parsers

import blang.inits.strategies.Parser
import java.util.Optional
import java.util.List
import blang.inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class IntParser implements Parser<Integer> {
  
  override parse(Optional<List<String>> arguments) {
    val String argument = Joiner.on(" ").join(arguments.get)
    if (argument.matches("\\s*INF\\s*")) {
      return Integer.MAX_VALUE
    } else {
      return Integer.parseInt(argument)
    }
  }
  
  override formatDescription(InstantiationContext context) {
    return "An integer or INF"
  }
  
}