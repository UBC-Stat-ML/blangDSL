package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.lang.annotation.ElementType

@Retention(RUNTIME)
@Target(CONSTRUCTOR, METHOD)
annotation DesignatedConstructor {
  
}