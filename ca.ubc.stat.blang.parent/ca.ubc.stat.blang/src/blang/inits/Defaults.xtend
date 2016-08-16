package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.Target

@Retention(RUNTIME)
@Target(FIELD, PARAMETER)
annotation Defaults {
  val Default [] value
}