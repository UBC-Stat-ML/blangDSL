package blang.inits

import java.lang.annotation.Target
import java.lang.annotation.Retention

@Retention(RUNTIME)
@Target(FIELD)
annotation Arg {
  val String description = ""
}