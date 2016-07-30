package ca.ubc.stat.blang

import ca.ubc.stat.blang.blangDsl.VariableType
import java.util.Map
import java.util.Collections
import java.util.LinkedHashMap

class StaticUtils {
  
  private new() {}
  
  def static uniqueDeclaredMethod(Class<?> someClass) {
    val declaredMethod = someClass.declaredMethods
    if (declaredMethod.size != 1)
      throw new RuntimeException('''
        Class «someClass» was assumed to have only one method but found «declaredMethod.size»
      ''')
    return declaredMethod.get(0).name
  }
  
  def static boolean isParam(VariableType variableType) {
    return switch(variableType) {
      case VariableType.PARAM  : true
      case VariableType.RANDOM : false
      default :
        throw new RuntimeException
    }
  }
  
  def static String generatedMethodName(String uniqueName) {
    return '''$generated__«uniqueName»'''
  }
  
}