package ca.ubc.stat.blang.jvmmodel

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.common.types.JvmTypeReference
import java.util.Map
import java.util.LinkedHashMap
import ca.ubc.stat.blang.StaticUtils
import ca.ubc.stat.blang.jvmmodel.BlangScope.BlangVariable
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import blang.annotations.Param

@Data
class XExpressionProcessor {
  
  val PhaseTracker phaseTracker = new PhaseTracker
  
  val private JvmDeclaredType output
  
  val extension private JvmTypesBuilder _typeBuilder
  val extension private JvmTypeReferenceBuilder _typeReferenceBuilder
  
  def void endAuxiliaryMethodGenerationPhase() {
    phaseTracker.endMethodGenerationPhase()
  }
  
  def StringConcatenationClient process(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference xExpressionReturnType
  ) {
    return _processXExpression(xExpression, scope, xExpressionReturnType, null, null)
  }
  
  /**
   * requiredReturnType is assumed to be a FunctionalInterface of the form ()->xExpressionReturnType
   */
  def StringConcatenationClient process_via_functionalInterface(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference xExpressionReturnType, 
    JvmTypeReference processedReturnType
  ) {
    return _processXExpression(xExpression, scope, xExpressionReturnType, processedReturnType, false)
  }
  
  /**
   * processedReturnType is assumed to have a constructor that consumes ()->xExpressionReturnType
   */
  def StringConcatenationClient process_via_constructionOfAnotherType(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference xExpressionReturnType, 
    JvmTypeReference processedReturnType
  ) {
    return _processXExpression(xExpression, scope, xExpressionReturnType, processedReturnType, true)
  }
  
  /**
   * returnType should NOT include Supplier<..>
   * 
   * if typeConversionViaConstructor, assume requiredReturnTypeIfDifferent has a constructor that consumes
   * ()->xExpressionReturnType, otherwise, requiredReturnTypeIfDifferent is assumed to be a FunctionalInteface of the form ()->xExpressionReturnType
   */
  def private StringConcatenationClient _processXExpression(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference xExpressionReturnType, 
    JvmTypeReference requiredReturnTypeIfDifferent,
    Boolean typeConversionViaConstructor
  ) {
    val lambdaCallNeeded = requiredReturnTypeIfDifferent !== null
    val String xExpressionGeneratedName = generatedMethodName(xExpression)
    val String lazyGeneratedName = xExpressionGeneratedName + "_lazy"
    val String generatedDoc = '''
          Auxiliary method generated to translate:
          «StaticUtils::expressionText(xExpression)»'''
    val StringConcatenationClient invokeString = '''
      «xExpressionGeneratedName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.deboxingInvocationString()»«ENDFOR»)'''
    if (phaseTracker.methodGenerationPhase()) {
      output.members += xExpression.toMethod(xExpressionGeneratedName, xExpressionReturnType) [ 
        visibility = JvmVisibility.PRIVATE
        static = true
        documentation = generatedDoc
        for (BlangVariable variable : scope.variables) {
          parameters += xExpression.toParameter(variable.deboxedName, variable.deboxedType)  
        }
        body = xExpression
      ]
      if (lambdaCallNeeded) {
        val StringConcatenationClient prefix = if (typeConversionViaConstructor) '''new «requiredReturnTypeIfDifferent»(''' else ''''''
        val StringConcatenationClient suffix = if (typeConversionViaConstructor) ''')''' else ''''''
        output.members += xExpression.toMethod(lazyGeneratedName, requiredReturnTypeIfDifferent) [
          visibility = JvmVisibility.PRIVATE
          static = true
          documentation = generatedDoc
          for (BlangVariable variable : scope.variables) {
            parameters += xExpression.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder))  
          }
          body = '''
            return «prefix»() -> «invokeString»«suffix»;
          '''
        ]
      }
      return '''<methodGenerationPhase>'''
    }
    return if (lambdaCallNeeded) {
      '''«lazyGeneratedName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.boxedName»«ENDFOR»)'''
    } else {
      invokeString
    }
  }
  
  val private Map<Integer, Integer> _generatedIds = new LinkedHashMap
  def String generatedMethodName(Object object) {
    val int hashCode = object.hashCode
    if (_generatedIds.containsKey(hashCode))
      return StaticUtils::generatedMethodName("" + _generatedIds.get(hashCode))
    val int newSerialId = _generatedIds.size()
    _generatedIds.put(hashCode, newSerialId)
    return StaticUtils::generatedMethodName("" + newSerialId)
  }
  
  static class PhaseTracker {
    var boolean methodGenerationPhase = true
    def private boolean methodGenerationPhase() {
      return methodGenerationPhase
    }
    def private void endMethodGenerationPhase() {
      methodGenerationPhase = false
    }
  }
}