package blang.inits

import blang.inits.strategies.Primitive
import blang.inits.strategies.parsers.IntParser
import blang.inits.strategies.OneArgConstructor
import blang.inits.strategies.parsers.StringParser
import blang.inits.strategies.parsers.DoubleParser
import blang.inits.strategies.parsers.BooleanParser
import java.util.Random
import blang.inits.strategies.parsers.LongParser
import java.util.Map

class Instantiators {
  
  def static Instantiator getDefault() {
    val Instantiator result = new Instantiator()
    addPrimitiveStrategies(result.strategies)
    addOneArgConstructorStrategies(result.strategies)
    return result
  }
  
  // strategies for creating  primitive
  def static void addPrimitiveStrategies(Map<Class<?>,InstantiationStrategy> strategies) {
    strategies => [
      put(int,     new Primitive<Integer>(  int,      new IntParser))
      put(double,  new Primitive<Double>(   double,   new DoubleParser))
      put(boolean, new Primitive<Boolean>(  boolean,  new BooleanParser))
      put(long,    new Primitive<Long>(     long,     new LongParser))
    ]
  }
  
  // strategies for classes with a one-argument constructor
  def static void addOneArgConstructorStrategies(Map<Class<?>,InstantiationStrategy> strategies) {
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