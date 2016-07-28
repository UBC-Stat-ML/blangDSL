package ca.ubc.stat.blang

class StaticUtils {
  
  def static uniqueDeclaredMethod(Class<?> someClass) {
    val declaredMethod = someClass.declaredMethods
    if (declaredMethod.size != 1)
      throw new RuntimeException
    return declaredMethod.get(0).name
  }
}