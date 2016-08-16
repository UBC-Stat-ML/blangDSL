package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.Target

@Retention(RUNTIME)
@Target(PARAMETER)
annotation ConstructorArg {
  val String value 
  val String description = ""
}