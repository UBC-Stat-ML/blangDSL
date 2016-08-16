package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.Target
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.ElementType

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
annotation InitVia {
  Class<? extends InstantiationStrategy> value
}