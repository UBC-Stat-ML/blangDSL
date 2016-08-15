package inits

import inits.strategies.Primitive
import inits.strategies.parsers.IntParser
import inits.strategies.OneArgConstructor
import inits.strategies.parsers.StringParser
import inits.strategies.parsers.DoubleParser
import inits.strategies.parsers.BooleanParser
import java.util.Random
import inits.strategies.parsers.LongParser
import java.util.Map

class Instantiators {
  
  def static <T> Instantiator<T> getDefault(Class<T> type, Arguments arguments) {
    val Instantiator<T> result = new Instantiator(type, arguments)
    addPrimitiveStrategies(result.strategies)
    addOneArgConstructorStrategies(result.strategies)
    return result
  }
  
  // strategies for creating  primitive
  def static <T> void addPrimitiveStrategies(Map<Class<?>,InstantiationStrategy> strategies) {
    strategies => [
      put(int,     new Primitive<Integer>(  int,      new IntParser))
      put(double,  new Primitive<Double>(   double,   new DoubleParser))
      put(boolean, new Primitive<Boolean>(  boolean,  new BooleanParser))
      put(long,    new Primitive<Long>(     long,     new LongParser))
    ]
  }
  
  // strategies for classes with a one-argument constructor
  def static <T> void addOneArgConstructorStrategies(Map<Class<?>,InstantiationStrategy> strategies) {
    strategies => [
    
      put(String, new OneArgConstructor<String>(String, new StringParser))
    
      put(Integer, new OneArgConstructor<Integer>(int, new IntParser))
      put(Double, new OneArgConstructor<Double>(double, new DoubleParser))
      put(Boolean, new OneArgConstructor<Boolean>(boolean, new BooleanParser))
      put(Long, new OneArgConstructor<Long>(long, new LongParser)) 
    
      put(Random, new OneArgConstructor<Long>(long, new LongParser))
      
    ]
  }
  
}