package blang.inits

import blang.inits.strategies.SelectImplementation
import java.lang.annotation.Repeatable
import java.lang.annotation.Retention
import java.lang.annotation.Target

@Repeatable(Implementations)
@Retention(RUNTIME)
@Target(TYPE)
annotation Implementation {
  val Class<?> value
  val String key = SelectImplementation.DEFAULT_KEY
}