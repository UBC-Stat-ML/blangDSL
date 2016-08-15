package inits.strategies.parsers

import inits.strategies.Parser
import java.util.Optional
import java.util.List
import inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class StringParser implements Parser<String> {
  
  override parse(Optional<List<String>> arguments) {
    return Joiner.on(" ").join(arguments.get)
  }
  
  override formatDescription(InstantiationContext context) {
    return "An string(s)"
  }
}