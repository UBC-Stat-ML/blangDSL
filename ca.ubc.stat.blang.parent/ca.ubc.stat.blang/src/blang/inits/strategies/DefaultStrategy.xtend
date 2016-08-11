package blang.inits.strategies

import blang.inits.InitializationStrategy
import blang.inits.ParsedArguments
import blang.inits.Initializer
import blang.inits.TypedArgument
import ca.ubc.stat.blang.StaticUtils
import blang.inits.Parser
import java.util.List
import java.util.ArrayList
import java.lang.reflect.Field
import java.util.Optional
import blang.inits.MissingRequiredArgument
import blang.inits.QualifiedName

/**
 * Assumes the presence of a zero-argument constructor. 
 * 
 * Then fills in fields marked by annotations
 */
class DefaultStrategy<T> 
// implements InitializationStrategy<T> 
{
  
//  override T init(ParsedArguments parsed, Class<T> typeToInitialize, Initializer initializer) {
//    val T result = typeToInitialize.newInstance
//    val List<TypedArgument> missingArguments = new ArrayList
//    for (TypedArgument argument : children(parsed.prefix(), typeToInitialize))
//    {
//      val ParsedArguments childParseInit = parsed.child(argument.name) 
//      val Object childInstance = 
//        try {
//          initializer.init(childParseInit, argument.type)
//        } catch (MissingRequiredArgument missingArg) {
//          // see if there is a default
//          val Optional<String> defaultValue = argument.defaultValue
//          if (defaultValue.isPresent()) { 
//            
//          } else {
//            missingArguments.addAll(missingArg.missingArguments)
//            null
//          }
//
//        }
//      if (childInstance !== null) {
//        StaticUtils::setFieldValue(typeToInitialize.getField(argument.name), result, childInstance)
//      }
//    }
//    return result
//  }
//  
//  override Iterable<TypedArgument> children(QualifiedName prefix, Class<T> typeToInitialize) {
//    val List<TypedArgument> result = new ArrayList
//    for (Field field : typeToInitialize.fields.filter[!it.getAnnotationsByType(Argument).isEmpty]) {
//      val Argument argument = field.getAnnotationsByType(Argument).get(0)
//      val TypedArgument typed = new TypedArgument(prefix, field.name, field.type, getDefaultValue(argument), argument.description)
//      result.add(typed)
//    }
//    return result
//  }
  
  def private static Optional<String> getDefaultValue(Argument argument) {
    if (argument == NO_INIT) {
      return Optional.empty()
    } else {
      return Optional.of(argument.defaultValue)
    }
  }
  
  // work around limitations of Java Annotations
  val public static final String NO_INIT = "NO_INIT_PROVIDED"
}