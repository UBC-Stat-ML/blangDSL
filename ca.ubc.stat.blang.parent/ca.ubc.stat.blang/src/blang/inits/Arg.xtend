package blang.inits

import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
annotation Arg {
  val String description = ""
}