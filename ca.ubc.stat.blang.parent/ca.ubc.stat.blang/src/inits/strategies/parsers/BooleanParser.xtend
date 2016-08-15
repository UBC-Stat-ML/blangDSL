package inits.strategies.parsers

import inits.strategies.Parser
import java.util.Optional
import java.util.List
import inits.Instantiator.InstantiationContext
import com.google.common.base.Joiner

class BooleanParser implements Parser<Boolean> {
  
  override parse(Optional<List<String>> arguments) {
    val String argument = Joiner.on(" ").join(arguments.get)
    if (argument.matches("\\s*true\\s*"))
      return true
    else if (argument.matches("\\s*false\\s*"))
      return false
    else
      throw new RuntimeException("Could not parse as boolean: '" + argument + "'; should be 'true' or 'false'")
  }
  
  override formatDescription(InstantiationContext context) {
    return "'true' or 'false'"
  }
  
}