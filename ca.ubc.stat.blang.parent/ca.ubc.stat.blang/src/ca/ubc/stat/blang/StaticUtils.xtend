package ca.ubc.stat.blang

import ca.ubc.stat.blang.blangDsl.Dependency
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import ca.ubc.stat.blang.blangDsl.VariableType
import java.util.ArrayList
import java.util.List
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution
import java.lang.reflect.Constructor
import org.eclipse.xtend.lib.annotations.Data
import java.lang.reflect.Parameter
import java.lang.annotation.Annotation
import blang.core.Param

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
  
  def static List<InitializerDependency> initializerDependencies(List<Dependency> dependencies) {
    val List<InitializerDependency> result = new ArrayList
    for (Dependency dependency : dependencies) {
      switch (dependency) {
        InitializerDependency : result.add(dependency)
      }
    }
    return result
  }
  
  def static List<ConstructorArgument> constructorParameters(InstantiatedDistribution distribution) {
    val Class<?> distributionClass = Class.forName(distribution.distributionType.identifier)
    val Constructor<?> constructor = {
      val Constructor<?>[] constructors = distributionClass.constructors
      if (constructors.size() !== 1) {
        throw new RuntimeException
      }
      constructors.get(0)  
    }
    val List<ConstructorArgument> result = new ArrayList
    for (Parameter parameter : constructor.parameters) {
      var isParam = false
      for (Annotation annotation : parameter.annotations) {
        if (annotation.annotationType == Param) {
          isParam = true
        }
      }
      val ConstructorArgument argument = new ConstructorArgument(parameter.getType(), isParam)
      result.add(argument)
    }
    return result
  }
  
  @Data
  static class ConstructorArgument {
    val Class<?> boxedClass
    val boolean isParam
  }

}