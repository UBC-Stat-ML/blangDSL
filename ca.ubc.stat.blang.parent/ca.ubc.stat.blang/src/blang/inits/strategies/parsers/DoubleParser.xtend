package blang.inits.strategies.parsers

import blang.inits.strategies.Parser
import java.util.Optional
import java.util.List
import blang.inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class DoubleParser implements Parser<Double> {
  
  override parse(Optional<List<String>> arguments) {
    val String argument = Joiner.on(" ").join(arguments.get)
    if (argument.matches("\\s*INF\\s*")) {
      return Double.POSITIVE_INFINITY
    } else {
      return Double.parseDouble(argument)
    }
  }
  
  override formatDescription(InstantiationContext context) {
    return "A number or INF"
  }
  
}