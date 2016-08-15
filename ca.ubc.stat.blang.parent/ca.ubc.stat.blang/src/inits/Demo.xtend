package inits

import inits.strategies.FeatureAnnotation
import java.util.Random
import java.util.Optional
import inits.strategies.SelectImplementation
import inits.strategies.ConstructorAnnotation

// TODO: move and transform to test
class Demo {
  
  @InitVia(FeatureAnnotation)
  static class MyClass {
    @Arg(description = "Some explanations")
    @Default("pirates")
    var String myString
    
    @Arg
    var SubGroupOfArguments subset
    
    @Arg
    var int anInt
    
    @Arg
    var MyInterface myInterface
    
    @Arg
    var WithConstr withC
  }
  
  @InitVia(FeatureAnnotation)
  static class SubGroupOfArguments {
    @Arg
    var String subStr
    
    @Arg
    @Default("1")
    var Random randomGen
  }
  
  @InitVia(ConstructorAnnotation)
  static class WithConstr {
    val String contents
    
    @DesignatedConstructor
    new (
      @ConstructorArg("first") String first, 
      @ConstructorArg("second") String second
    ) {
      contents = first + ", " + second
    }
    
    override String toString() {
      return contents
    }
  }
  
  @InitVia(SelectImplementation)
  @Implementation(MyImpl) 
  @Implementation(key = "alternative", value = MyOtherImpl)
  static interface MyInterface {
    def String quack()
  }
  
  static class MyImpl implements MyInterface {
    override String quack() {
      "coin coin"
    }
  }
  
  static class MyOtherImpl implements MyInterface {
    override String quack() {
      "quack quack"
    }
  }
  
  def public static void main(String [] args) {
    
    val Arguments parsed = PosixParser.parse(
      "--myString", "it worked!", 
      "--subset.subStr", "rabbit", 
      "--anInt", "18", 
      "--myInterface", "default",
      "--withC.first", "Baba",
      "--withC.second", "BouThack")
    val Instantiator<MyClass> inst = Instantiators::getDefault(MyClass, parsed)
    val Optional<MyClass> product = inst.init
    
    println(inst.lastInitReport)
    
    println(product.get.subset.subStr)
    println(product.get.myInterface.quack)
  }
}