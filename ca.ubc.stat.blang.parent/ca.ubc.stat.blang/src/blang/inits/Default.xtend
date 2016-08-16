package blang.inits

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import java.lang.annotation.Target
import java.lang.annotation.Repeatable

// TODO: add repetition support
@Repeatable(Defaults)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD, ElementType.PARAMETER)
annotation Default {
  val String [] value 
  val String [] key = #[]
}