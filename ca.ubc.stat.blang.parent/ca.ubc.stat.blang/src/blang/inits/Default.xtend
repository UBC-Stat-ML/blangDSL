package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.Target
import java.lang.annotation.Repeatable

// TODO: add repetition support
@Repeatable(Defaults)
@Retention(RUNTIME)
@Target(FIELD, PARAMETER)
annotation Default {
  val String [] value 
  val String [] key = #[]
}