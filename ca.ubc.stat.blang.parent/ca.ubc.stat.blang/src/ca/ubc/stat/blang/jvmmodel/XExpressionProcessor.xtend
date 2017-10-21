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
import org.eclipse.xtext.common.types.JvmGenericType
import java.util.function.Supplier
import blang.core.LogScaleFactor
import blang.core.SupportFactor.Support
import blang.core.SupportFactor

@Data
class XExpressionProcessor {
  
  val PhaseTracker phaseTracker = new PhaseTracker
  
  val private JvmDeclaredType output
  
  val extension private JvmTypesBuilder _typeBuilder
  val extension private JvmTypeReferenceBuilder _typeReferenceBuilder
  
  def void endAuxiliaryMethodGenerationPhase() {
    phaseTracker.endMethodGenerationPhase()
  }
  
  def public StringConcatenationClient process(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference xExpressionReturnType
  ) {
    val String xExpressionGeneratedName = generatedMethodName(xExpression)
    val String generatedDoc = '''
          Auxiliary method generated to translate:
          «StaticUtils::expressionText(xExpression)»'''
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
      return '''<methodGenerationPhase>'''
    }
    return '''«xExpressionGeneratedName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.deboxingInvocationString()»«ENDFOR»)'''
  }

  def StringConcatenationClient processSupplier(XExpression xExpression, BlangScope scope, JvmTypeReference suppliedType) {
    return processViaFunctionalInterfaceImplementation(xExpression, scope, typeRef(Supplier, suppliedType), StaticUtils::uniqueDeclaredMethod(Supplier), suppliedType)
  }
  
  def StringConcatenationClient processLogScaleFactor(XExpression xExpression, BlangScope scope) {
    return processViaFunctionalInterfaceImplementation(xExpression, scope, typeRef(LogScaleFactor), StaticUtils::uniqueDeclaredMethod(LogScaleFactor), typeRef("double"))
  }
  
  def StringConcatenationClient processSupportFactor(XExpression xExpression, BlangScope scope) {
    return '''
      new «typeRef(SupportFactor)»(«processViaFunctionalInterfaceImplementation(xExpression, scope, typeRef(Support), StaticUtils::uniqueDeclaredMethod(Support), typeRef("boolean"))»)
    '''
  } 
  
  def private StringConcatenationClient processViaFunctionalInterfaceImplementation(
    XExpression xExpression, 
    BlangScope scope, 
    JvmTypeReference functionalInterfaceTypeRef,
    String methodToImplement,
    JvmTypeReference methodToImplementReturnType
  ) {
    val String xExpressionGeneratedName = generatedMethodName(xExpression)
    val String generatedAuxiliaryClassName = xExpressionGeneratedName + "_class"
    val String generatedDoc = '''
          Auxiliary method generated to translate:
          «StaticUtils::expressionText(xExpression)»'''
    
    if (phaseTracker.methodGenerationPhase) {
      output.members += xExpression.toMethod(xExpressionGeneratedName, methodToImplementReturnType) [ 
        visibility = JvmVisibility.PRIVATE
        static = true
        documentation = generatedDoc
        for (BlangVariable variable : scope.variables) {
          parameters += xExpression.toParameter(variable.deboxedName, variable.deboxedType)  
        }
        body = xExpression
      ]
      
      val JvmGenericType implementation = xExpression.toClass(generatedAuxiliaryClassName) [
        static = true
        visibility = JvmVisibility.PUBLIC
      ]
      implementation.superTypes += functionalInterfaceTypeRef
      implementation.members += xExpression.toMethod(methodToImplement, methodToImplementReturnType) [
        visibility = JvmVisibility.PUBLIC
        body = '''return «xExpressionGeneratedName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.deboxingInvocationString()»«ENDFOR»);'''
      ]
      implementation.members += xExpression.toMethod("toString", typeRef(String)) [
        visibility = JvmVisibility.PUBLIC
        body = '''return "«StaticUtils::escape(StaticUtils::expressionText(xExpression))»";'''
      ]
      for (BlangVariable variable : scope.variables()) {
        implementation.members += xExpression.toField(variable.boxedName, variable.boxedType(_typeReferenceBuilder)) [
          final = true
        ] 
      }
      implementation.members += xExpression.toConstructor[
        for (BlangVariable variable : scope.variables) {
          parameters += xExpression.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder))  
        }
        body = '''
          «FOR BlangVariable variable : scope.variables()»
            this.«variable.boxedName» = «variable.boxedName»;
          «ENDFOR»
        '''
      ]
      output.members += implementation
      return '''<methodGenerationPhase>'''
    } else {
      return '''new «generatedAuxiliaryClassName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.boxedName»«ENDFOR»)'''
    }
  }
  
  val private Map<Integer, Integer> _generatedIds = new LinkedHashMap
  def String generatedMethodName(Object object) {
    val int hashCode = object.hashCode
    if (_generatedIds.containsKey(hashCode))
      return StaticUtils::generatedName("" + _generatedIds.get(hashCode))
    val int newSerialId = _generatedIds.size()
    _generatedIds.put(hashCode, newSerialId)
    return StaticUtils::generatedName("" + newSerialId)
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