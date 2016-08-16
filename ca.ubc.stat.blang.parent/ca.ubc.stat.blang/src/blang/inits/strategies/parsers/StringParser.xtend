package blang.inits.strategies.parsers

import blang.inits.strategies.Parser
import java.util.Optional
import java.util.List
import blang.inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class StringParser implements Parser<String> {
  
  override parse(Optional<List<String>> arguments) {
    return Joiner.on(" ").join(arguments.get)
  }
  
  override formatDescription(InstantiationContext context) {
    return "Any string(s)"
  }
}