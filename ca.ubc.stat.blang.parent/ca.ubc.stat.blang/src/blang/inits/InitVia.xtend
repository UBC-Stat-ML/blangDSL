package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.Target

@Retention(RUNTIME)
@Target(TYPE)
annotation InitVia {
  Class<? extends InstantiationStrategy> value
}