package blang.inits

import blang.inits.strategies.FeatureAnnotation
import java.util.Random
import java.util.Optional
import blang.inits.strategies.SelectImplementation
import blang.inits.strategies.ConstructorAnnotation
import java.util.List
import com.google.common.base.Joiner
import blang.inits.strategies.FullyQualifiedImplementation
import java.lang.reflect.Type

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
    var WithConstr<Short> withC
    
    @Arg
    var WithStaticFactory withS
    
    @Arg 
    var CombinedTest combined
    
    @Arg
    var MyOtherInterf interf
  }
  
  static class CombinedTest {
    
    @Arg
    var String aStr
    
    var String other
    
    @DesignatedConstructor
    new (@Input(formatDescription = "some format") List<String> input, @ConstructorArg("blah") int blah) {
      other = Joiner.on(" ").join(input) + blah
    }
    
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
  static class WithConstr<T> {
    val String contents
    val int number
    
    @DesignatedConstructor
    new (
      @ConstructorArg("first") String first, 
      @ConstructorArg("second") String second,
      @ConstructorArg(GLOBAL_KEY) String myGlobal,
      @Input(formatDescription = "a number") List<String> input
      ,
      @InitInfoName QualifiedName qName
      ,
      @InitInfoType Type type
    ) {
      contents = first + ", " + second + " - " + myGlobal
      number = Integer.parseInt(input.get(0))
      println("--> qName = " + qName)
      println("--> type = " + type)
    }
    
    override String toString() {
      return contents
    }
  }
  
  @InitVia(FullyQualifiedImplementation)
  static interface MyOtherInterf {
    def String alien()
  }
  
  static class MyOtherImp implements MyOtherInterf {
    @Arg var String asdf
    override String alien() {
      return asdf
    }
  }
  
  
  @InitVia(ConstructorAnnotation)
  static class WithStaticFactory {
    
    var String mine
    
    @DesignatedConstructor
    def static WithStaticFactory buildIt(@ConstructorArg("first") String first) {
      val WithStaticFactory result = new WithStaticFactory
      result.mine = first
      return result
    }
  }
  
  val static String GLOBAL_KEY = "___global_key"
  
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
      "--withC", "666",
      "--withC.first", "Baba",
      "--withC.second", "BouThack",
      "--withS.first", "bouh!",
      "--combined", "COMBINED",
      "--combined.aStr", "A STR",
      "--combined.blah", "123456",
      "--interf", "blang.inits.Demo$MyOtherImp",
      "--interf.asdf", "Klingons")
    
    println(parsed)
    println  
      
    val Instantiator inst = Instantiators::getDefault()
    inst.debug = true
    inst.globals.put(GLOBAL_KEY, "***this is global***")
    val Optional<MyClass> product = inst.init(MyClass, parsed)
    
    println(inst.lastInitReport)
    
    println(product.get.subset.subStr)
    println(product.get.myInterface.quack)
    println(product.get.withC)
    println(product.get.withS.mine)
    println(product.get.withC.number)
    println(product.get.combined.other)
    println(product.get.interf.alien)
  }
}