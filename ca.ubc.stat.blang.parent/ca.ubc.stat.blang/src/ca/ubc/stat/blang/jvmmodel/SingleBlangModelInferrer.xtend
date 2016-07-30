package ca.ubc.stat.blang.jvmmodel

import blang.core.Model
import blang.core.ModelComponent
import blang.core.Param
import blang.factors.LogScaleFactor
import ca.ubc.stat.blang.StaticUtils
import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.Dependency
import ca.ubc.stat.blang.blangDsl.ForLoop
import ca.ubc.stat.blang.blangDsl.IndicatorDeclaration
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution
import ca.ubc.stat.blang.blangDsl.LawNode
import ca.ubc.stat.blang.blangDsl.LogScaleFactorDeclaration
import ca.ubc.stat.blang.blangDsl.VariableDeclaration
import ca.ubc.stat.blang.jvmmodel.BlangScope.BlangVariable
import java.util.ArrayList
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import java.util.Map
import java.util.LinkedHashMap

@Data
class SingleBlangModelInferrer {

  // input: an AST for a single model
  val BlangModel model

  // output: a generated 
  val JvmDeclaredType output

  // extension facilities provided by xtext
  extension JvmTypesBuilder _typeBuilder
  extension JvmAnnotationReferenceBuilder _annotationTypesBuilder;
  extension JvmTypeReferenceBuilder _typeReferenceBuilder;
  
  def void infer() {
    setupClass()
    val BlangScope globalScope = setupVariables()
    generateConstructor()
    generateMethods(globalScope)
  }
  
  def private void setupClass() {
    if (model.packageName != null) {
      output.packageName = model.packageName;
    }
    output.superTypes += typeRef(Model)
  }
  
  def private BlangScope setupVariables() {
    val BlangScope result = BlangScope::emptyScope
    for (VariableDeclaration variableDeclaration : model.variableDeclarations) {
      val BlangVariable blangVariable = new BlangVariable(variableDeclaration)
      result += blangVariable
      output.members += variableDeclaration.toField(blangVariable.boxedName(), blangVariable.boxedType(_typeReferenceBuilder)) [
        // TODO: uncomment line below once constructor generation is setup
        //final = true
        if (blangVariable.isParam)
          annotations += annotationRef(Param)
      ]
    }
    return result
  }
  
  def private void generateConstructor() {
//    if (!hasVariables()) 
//      return; // simplifies code; nothing to do
//    output.members += model.toConstructor [
//      visibility = JvmVisibility.PUBLIC
//      // Random variables show up earlier in the constructor parameters
//      for (varDecl : randomVariables()) {
//        parameters += varDecl.toParameter(varDecl.name, getVarType(varDecl))
//      }
//      // Then, param variables
//      for (varDecl : paramVariables()) {
//        parameters += varDecl.toParameter(varDecl.name, getVarType(varDecl))
//      }
//      body = '''
//        «FOR varDecl : model.vars»
//          this.«varDecl.name» = «varDecl.name»;
//        «ENDFOR»
//      '''
//    ]
  }
  
  val static final String COMPONENTS_METHOD_NAME = StaticUtils::uniqueDeclaredMethod(Model)
  val static final String COMPONENTS_LIST_NAME = "components"
  
  def String xExpressionGeneratedMethodCall(XExpression xExpression, BlangScope scope, JvmTypeReference returnType) {
      val String generatedName = generatedMethodName(xExpression.hashCode)
      return '''«generatedName»(«FOR BlangVariable variable : scope.variables() SEPARATOR ", "»«variable.deboxingInvocationString()»«ENDFOR»)'''
  }

  def private StringConcatenationClient componentMethodBody(BlangScope scope) {
    return '''
      «typeRef(ArrayList, typeRef(ModelComponent))» «COMPONENTS_LIST_NAME» = new «typeRef(ArrayList)»();
      
      «FOR LawNode node : model.lawNodes»
        «componentMethodBody(node, scope)»
      «ENDFOR»
      
      return «COMPONENTS_LIST_NAME»;
    '''
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(LogScaleFactorDeclaration logScaleFactor, BlangScope scope) {
    val String generatedName = generatedMethodName(logScaleFactor.hashCode)
    val BlangScope restrictedScope = scope.restrict(logScaleFactor.contents.dependencies)
    return '''
    {
      «componentMethodBody(logScaleFactor.contents.dependencies, scope)»
      «COMPONENTS_LIST_NAME».add(«generatedName»(«FOR BlangVariable variable : restrictedScope.variables() SEPARATOR ", "»«variable.boxedName()»«ENDFOR»));
    }
    '''
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(List<Dependency> dependencies, BlangScope scope) {
    return '''
      «FOR InitializerDependency dependency : initializerDependencies(dependencies)»
      «dependency.type» «dependency.name» = «xExpressionGeneratedMethodCall(dependency.init, scope, dependency.type)»;
      «ENDFOR»
    '''
  }
  
  def private List<InitializerDependency> initializerDependencies(List<Dependency> dependencies) {
    val List<InitializerDependency> result = new ArrayList
    for (Dependency dependency : dependencies) {
      switch (dependency) {
        InitializerDependency : result.add(dependency)
      }
    }
    return result
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(IndicatorDeclaration logScaleFactor, BlangScope scope) {
    return '''// TODO'''
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(ForLoop forLoop, BlangScope scope) {
    val BlangVariable iteratorVariable = new BlangVariable(forLoop.iteratorType, forLoop.name, false)
    val BlangScope childScope = scope.child(iteratorVariable)
    return  '''
      for («forLoop.iteratorType» «forLoop.name» : «xExpressionGeneratedMethodCall(forLoop.iteratorRange, scope, forLoop.iteratorType)») {
        «FOR node : forLoop.loopBody»
        «componentMethodBody(node, childScope)»
        «ENDFOR»
      }
    '''
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(InstantiatedDistribution logScaleFactor, BlangScope scope) {
    return '''// TODO'''
  }
  
  def private void generateMethods(BlangScope scope) {
    output.members += model.toMethod(COMPONENTS_METHOD_NAME, typeRef(Collection, typeRef(ModelComponent))) [
      visibility = JvmVisibility.PUBLIC
      documentation = '''
        A component can be either a distribution, support constraint, or another model  
        which recursively defines additional components.
      '''
      body = componentMethodBody(scope)
    ]
    for (LawNode node : model.lawNodes) {
      generateMethods(node, scope)
    }
  }
  
  def private dispatch void generateMethods(IndicatorDeclaration indicator, BlangScope scope) {
    // TODO
  }
  
  def private dispatch void generateMethods(LogScaleFactorDeclaration logScaleFactor, BlangScope scope) {
    val String generatedName = generatedMethodName(logScaleFactor.hashCode)
    val BlangScope restrictedScope = scope.restrict(logScaleFactor.contents.dependencies)
    output.members += logScaleFactor.toMethod(generatedName, typeRef(LogScaleFactor)) [
      static = true
      for (BlangVariable variable : restrictedScope.variables()) {
        parameters += logScaleFactor.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder))
      }
      body = '''
        return () -> «xExpressionGeneratedMethodCall(logScaleFactor.contents.factorBody, restrictedScope, typeRef(Double))»;
      '''
    ]
    generateXExpressionAuxMethod(logScaleFactor.contents.factorBody, restrictedScope, typeRef(Double))
    
    // Dependencies too
    for (Dependency dependency : logScaleFactor.contents.dependencies) {
      switch (dependency) {
        InitializerDependency : {
          generateXExpressionAuxMethod(dependency.init, scope, dependency.type)
        }
      }
    }
  }
  
  def private dispatch void generateMethods(InstantiatedDistribution instantiated, BlangScope scope) {
    // TODO
  }
  
  def private dispatch void generateMethods(ForLoop forLoop, BlangScope scope) {
    val BlangVariable iteratorVariable = new BlangVariable(forLoop.iteratorType, forLoop.name, false)
    val BlangScope childScope = scope.child(iteratorVariable)
    generateXExpressionAuxMethod(forLoop.iteratorRange, scope, typeRef(Iterable, forLoop.iteratorType))
    for (LawNode node : forLoop.loopBody) {
      generateMethods(node, childScope)
    }
  }
  
  def private void generateXExpressionAuxMethod(XExpression xExpression, BlangScope scope, JvmTypeReference returnType) {
    val String generatedName = generatedMethodName(xExpression.hashCode)
    output.members += xExpression.toMethod(generatedName, returnType) [ 
      visibility = JvmVisibility.PRIVATE
      static = true
      documentation = '''
        Auxiliary method generated to translate:
        «expressionText(xExpression)»
      '''
      for (BlangVariable variable : scope.variables) {
        parameters += xExpression.toParameter(variable.deboxedName, variable.deboxedType)  
      }
      body = xExpression
    ]
  }
  
  def private expressionText(EObject ex) {
    NodeModelUtils.getTokenText(NodeModelUtils.getNode(ex))
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
}
