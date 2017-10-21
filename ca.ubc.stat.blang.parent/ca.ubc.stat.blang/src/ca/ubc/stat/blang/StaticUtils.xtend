package ca.ubc.stat.blang

import ca.ubc.stat.blang.blangDsl.Dependency
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import ca.ubc.stat.blang.blangDsl.VariableType
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtend2.lib.StringConcatenation
import java.lang.reflect.Field
import org.eclipse.xtext.util.Strings
import ca.ubc.stat.blang.blangDsl.BlangModel

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
  
  def static String generatedName(String uniqueName) {
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
  
  def static expressionText(EObject ex) {
    NodeModelUtils.getTokenText(NodeModelUtils.getNode(ex))
  }
  
  def static void eagerlyEvaluate(StringConcatenationClient lazyString) {
    val StringConcatenation dummy = new StringConcatenation()
    dummy.append(lazyString, "")
  }
  
  def static void setFieldValue(Field f, Object instance, Object value) {
		var boolean isAccessible=f.isAccessible() 
		if (!isAccessible) f.setAccessible(true) 
		f.set(instance, value) 
		if (!isAccessible) f.setAccessible(false) 
	}
	
	def static String getterName(String fieldName) {
    return ("get" + Strings.toFirstUpper(fieldName));
	}
	
	def static String setterName(String fieldName) {
    return ("set" + Strings.toFirstUpper(fieldName));
  }
	
	def static String fullyQualifiedNameString(BlangModel model) {
	  val String prefix = 
      if (model.package.nullOrEmpty) {
        ""
      } else {
        model.package
      }
	  return prefix + model.name
	}
	
	/**
	 * Transforms a blang string into a string that can be 
	 * inserted into Java code inside an expression of the form
	 * String str = "<output string pasted here>";
	 */
	def static String escape(String blangString) {
	  return blangString
	   .replace("\\", "\\\\") // order important
	   .replace("\"", "\\\""); 
	}
}