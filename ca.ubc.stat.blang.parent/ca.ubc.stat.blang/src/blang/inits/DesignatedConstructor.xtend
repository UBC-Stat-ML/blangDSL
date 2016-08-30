package blang.inits

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.lang.annotation.ElementType

/**
 * More precisely, this can be used both for constructor and 
 * also static factory methods.
 */
@Retention(RUNTIME)
@Target(CONSTRUCTOR, METHOD)
annotation DesignatedConstructor {
  
}