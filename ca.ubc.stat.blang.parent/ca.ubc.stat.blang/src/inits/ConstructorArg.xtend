package inits

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.lang.annotation.ElementType

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
annotation ConstructorArg {
  val String value 
  val String description = ""
}