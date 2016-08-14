package inits

import inits.strategies.StringConstructor
import inits.strategies.FeatureAnnotation
import java.util.Optional

class QuickTests {
  
  @InitVia(StringConstructor)
  static class MyClass {
    
    new (String test) {
      println("ok: " + test)
    }
    
  }
  
  @InitVia(FeatureAnnotation)
  static class AnotherOne {
    @Arg
    var String myString
  }
  
  
  def public static void main(String [] args) {
    
    val Arguments parsed = PosixParser.parse("--myString", "it worked!")
    
    val Instantiator<AnotherOne> inst = new Instantiator(AnotherOne, parsed)
    
    inst.init
    
    println("done")
    
//    val Arguments parsed = PosixParser.parse("contents")
//    
//    val Instantiator<MyClass> inst = new Instantiator(MyClass, parsed)
//    
//    val MyClass product = inst.init().get()
//    
    
    
//    val Arguments parsed = PosixParser.parse("test", "--suboption", "my subopt value", "asdf", "--suboption.child", "subchi", "--a.b.c", "asdf", "--a.b", "asssss") 
//    println(parsed)
    
    
  }
}