package blang.inits

import blang.inits.strategies.SelectImplementation
import java.lang.annotation.Repeatable
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.ElementType
import java.lang.annotation.Target

@Repeatable(Implementations)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
annotation Implementation {
  val Class<?> value
  val String key = SelectImplementation.DEFAULT_KEY
}