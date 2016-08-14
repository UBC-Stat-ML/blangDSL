package blang.inits.strategies

import blang.inits.InitializationStrategy
import blang.inits.ParsedArguments
import blang.inits.Initializer
import blang.inits.TypedArgument
import java.util.Collections
import java.lang.reflect.Constructor
import java.util.Optional
import blang.inits.MissingRequiredArgument
import blang.inits.QualifiedName

/** 
 * Assumes there is a constructor taking as argument a single string
 */
class StringConstructor<T> 
//implements InitializationStrategy<T> 
{
  
//  override T init(ParsedArguments parsed, Class<T> typeToInitialize, Initializer initializer) throws MissingRequiredArgument {
//    val Constructor<T> constructor = typeToInitialize.getConstructor(String)
//    val Optional<String> argument = parsed.contents
//    if (argument.isPresent()) {
//      return constructor.newInstance(#[argument.get()])
//    } else {
//      throw new MissingRequiredArgument(new TypedArgument(parsed.prefix, ))
//    }
//  }
//  
//  override Iterable<TypedArgument> children(QualifiedName prefix, Class<T> typeToInitialize) {
//    return Collections.EMPTY_LIST
//  }
  
}