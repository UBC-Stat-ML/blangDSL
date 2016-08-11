package blang.inits

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data

@Data
class Initializer {
  
  val InitializationStrategy<?> defaultInitializationStrategy
  val Map<Class<?>,InitializationStrategy<?>> strategies
  
//  def <T> T init(ParsedArguments parsed, Class<T> typeToInitialize) {
//    val InitializationStrategy<T> strategy = getInitializationStrategy(typeToInitialize) as InitializationStrategy<T>
//    return strategy.init(parsed, typeToInitialize, this)
//  }
  
  def private InitializationStrategy<?> getInitializationStrategy(Class<?> typeToInitialize) {
    // 1 - check in DB
    val InitializationStrategy<?> strategyInDB = strategies.get(typeToInitialize)
    if (strategyInDB !== null) {
      return strategyInDB
    }
    // 2 - use InitVia annotation
    val InitVia [] annotations = typeToInitialize.getAnnotationsByType(InitVia)
    if (annotations.size > 0) 
      return annotations.get(0).value.newInstance
    // 3 - back to default
    return defaultInitializationStrategy
  }
  
}