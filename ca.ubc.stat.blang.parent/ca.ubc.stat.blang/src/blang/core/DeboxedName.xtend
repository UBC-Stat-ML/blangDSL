package blang.core

import java.lang.annotation.Target
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER, ElementType.FIELD)
annotation DeboxedName {
  String value
}