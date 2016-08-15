package inits

import inits.strategies.FeatureAnnotation
import java.util.Optional
import inits.strategies.parsers.IntParser
import inits.strategies.OneArgConstructor
import inits.strategies.Primitive
import inits.strategies.parsers.StringParser

class QuickTests {
  

  
  @InitVia(FeatureAnnotation)
  static class AnotherOne {
    @Arg(description = "Some explanations")
    @Default("pirates")
    var String myString
    
    @Arg
    var SubOne subOne
    
    @Arg
    var int anInt
  }
  
  static class SubOne {
    @Arg
    var String subStr
  }
  
  
  def public static void main(String [] args) {
    
    val Arguments parsed = PosixParser.parse("--myString", "it worked!", "--subOne.subStr", "rabbit", "--anInt", "18")
//    
    val Instantiator<AnotherOne> inst = new Instantiator(AnotherOne, parsed)
    inst.strategies.put(String, new OneArgConstructor<String>(String, new StringParser))
    inst.strategies.put(Integer, new OneArgConstructor<Integer>(int, new IntParser))
    inst.strategies.put(int, new Primitive<Integer>(int, new IntParser))
    
//    
    val Optional<AnotherOne> result = inst.init
    
    println(inst.lastInitReport)
    
    println(result.get.anInt)
    
//    
//    println("done")
    
//    val Arguments parsed = PosixParser.parse("contents")
//    
//    val Instantiator<MyClass> inst = new Instantiator(MyClass, parsed)
//    
//    val MyClass product = inst.init().get()
//    

//    println("---")
//    
//    
//    val Arguments parsed = PosixParser.parse("test", "--suboption", "my subopt value", "asdf", "--suboption.child", "subchi", "--a.b.c", "asdf", "--a.b", "asssss") 
//    println(parsed)
    
    
  }
}