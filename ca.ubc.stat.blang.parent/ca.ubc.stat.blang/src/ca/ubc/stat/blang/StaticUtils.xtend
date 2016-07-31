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
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.common.types.JvmTypeReference

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
}