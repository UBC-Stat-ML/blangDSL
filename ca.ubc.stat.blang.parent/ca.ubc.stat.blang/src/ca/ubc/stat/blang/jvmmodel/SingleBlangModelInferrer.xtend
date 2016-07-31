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
import ca.ubc.stat.blang.blangDsl.FactorDeclaration
import blang.core.SupportFactor
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmAnnotationReference
import java.lang.reflect.Constructor
import java.lang.reflect.Parameter
import java.lang.annotation.Annotation
import java.util.Collections
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.impl.EClassifierImpl
import org.eclipse.emf.ecore.impl.EClassImpl
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI

@Data
class SingleBlangModelInferrer {

  // input: an AST for a single model
  val private BlangModel model

  // output: a generated 
  val private JvmDeclaredType output

  // extension facilities provided by xtext
  extension private JvmTypesBuilder _typeBuilder
  extension private JvmAnnotationReferenceBuilder _annotationTypesBuilder
  extension private JvmTypeReferenceBuilder _typeReferenceBuilder
  extension private  IResourceDescriptionsProvider index
  
  def void infer() {
    setupClass()
    val BlangScope globalScope = setupVariables()
    generateConstructor(globalScope)
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
        final = true
        if (blangVariable.isParam)
          annotations += annotationRef(Param)
      ]
    }
    return result
  }
  
  def private void generateConstructor(BlangScope scope) {
    output.members += model.toConstructor [
      visibility = JvmVisibility.PUBLIC
      // Random variables show up earlier in the constructor parameters, then params
      val boolean [] variablesOrder = #[false, true]; // isParam == false, then, isParam == true
      for (boolean isParam : variablesOrder) {
        for (BlangVariable variable : scope.variables.filter[it.param === isParam]) {
          val JvmFormalParameter param = model.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder)) 
          param.annotations += annotationRef(Param) 
          parameters += param
        }
      }
      body = '''
        «FOR BlangVariable variable : scope.variables»
        this.«variable.boxedName» = «variable.boxedName»;
        «ENDFOR»
      '''
    ]
  }
  
  val static final String COMPONENTS_METHOD_NAME = StaticUtils::uniqueDeclaredMethod(Model)
  val static final String COMPONENTS_LIST_NAME = "components"
  
  def private String xExpressionGeneratedMethodCall(XExpression xExpression, BlangScope scope, JvmTypeReference returnType) {
      val String generatedName = generatedMethodName(xExpression)
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
  
  def private dispatch StringConcatenationClient componentMethodBody(LogScaleFactorDeclaration factor, BlangScope scope) {
    return componentMethodBody(factor, scope, factor.contents.dependencies)
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(IndicatorDeclaration factor, BlangScope scope) {
    return componentMethodBody(factor, scope, factor.contents.dependencies)
  }
  
  def private dispatch StringConcatenationClient componentMethodBody(InstantiatedDistribution instantiatedDist, BlangScope scope) {
    return componentMethodBody(instantiatedDist, scope, instantiatedDist.dependencies)
  }
  
  def private StringConcatenationClient componentMethodBody(LawNode node, BlangScope scope, List<Dependency> dependencies) {
    val String generatedName = generatedMethodName(node)
    val BlangScope restrictedScope = scope.restrict(dependencies)
    return '''
    { // Code generated by: «expressionText(node)»
      // Required initialization:
      «FOR InitializerDependency dependency : StaticUtils::initializerDependencies(dependencies)»
      «dependency.type» «dependency.name» = «xExpressionGeneratedMethodCall(dependency.init, scope, dependency.type)»;
      «ENDFOR»
      // Construction and addition of the factor/model:
      «COMPONENTS_LIST_NAME».add(
        «IF node instanceof InstantiatedDistribution»
        «distributionInstantiationString(node as InstantiatedDistribution, scope, dependencies)»
        «ELSE»
        «generatedName»(«FOR BlangVariable variable : restrictedScope.variables() SEPARATOR ", "»«variable.boxedName()»«ENDFOR»)
        «ENDIF»
      );
    }
    '''
  }
  
  def private StringConcatenationClient distributionInstantiationString(
    InstantiatedDistribution distribution, 
    BlangScope scope, 
    List<Dependency> dependencies
  ) {
//    val rd = irdProvider.getResourceDescriptions(model.eResource.resourceSet)
//    for (e : rd.getExportedObjects(distribution.distributionType.eClass, QualifiedName.create(distribution.distributionType.qualifiedName), false)) {
//      println("--> " + (e.EObjectOrProxy as JvmDeclaredType).
//    }
//    val List<ConstructorArgument> arguments = StaticUtils::constructorParameters(distribution)
//    '''
//    new «distribution.distributionType»()
//    '''
    val JvmType typeRef = distribution.distributionType
    val List<ConstructorArgument> arguments = constructorParameters(distribution)
    val int nVars = arguments.filter[!param].size()
    return '''
      new «typeRef»(
      «FOR index : 0 ..< arguments.size() SEPARATOR ", "»
      /*«arguments.get(index)»*/
«««      «IF arguments.get(index).param»
«««      null
«««      «ELSE»
«««      «distribution.generatedVariables.get(index)»    /////// /FIXME : THIS SHOULD BE XEXPRESSED!!!
«««      «ENDIF»
      «ENDFOR»
      )
    '''
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
  
  def private void generateMethods(BlangScope scope) {
    output.members += model.toMethod(COMPONENTS_METHOD_NAME, typeRef(Collection, typeRef(ModelComponent))) [
      visibility = JvmVisibility.PUBLIC
      documentation = '''
        A component can be either a distribution, support constraint, or another model  
        which recursively defines additional components.'''
      body = componentMethodBody(scope)
    ]
    for (LawNode node : model.lawNodes) {
      generateMethods(node, scope)
    }
  }
  
  def private dispatch void generateMethods(IndicatorDeclaration indicator, BlangScope scope) {
    generateMethods(indicator, scope, indicator.contents, true)
  }
  
  def private dispatch void generateMethods(LogScaleFactorDeclaration logScaleFactor, BlangScope scope) {
    generateMethods(logScaleFactor, scope, logScaleFactor.contents, false)
  }
  
  def private void generateMethods(LawNode node, BlangScope scope, FactorDeclaration factor, boolean isIndicator) {
    val JvmTypeReference returnType = if (isIndicator) typeRef(Boolean) else typeRef(Double)
    val String generatedName = generatedMethodName(node)
    val BlangScope restrictedScope = scope.restrict(factor.dependencies)
    val StringConcatenationClient prefix = if (isIndicator) '''new «typeRef(SupportFactor)»(''' else ''''''
    val StringConcatenationClient suffix = if (isIndicator) ''')''' else ''''''
    output.members += node.toMethod(generatedName, typeRef(LogScaleFactor)) [
      static = true
      for (BlangVariable variable : restrictedScope.variables()) {
        parameters += node.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder))
      }
      documentation = '''
        Code generated by: «expressionText(node)»
        This level of indirection is used to enforce scope restriction.'''
      body = '''
        return «prefix»() -> «xExpressionGeneratedMethodCall(factor.factorBody, restrictedScope, returnType)»«suffix»;
      '''
    ]
    // Actual body of the factor generated here
    generateXExpressionAuxMethod(factor.factorBody, restrictedScope, returnType)
    
    // Dependencies
    for (InitializerDependency dependency : StaticUtils::initializerDependencies(factor.dependencies)) {
      generateXExpressionAuxMethod(dependency.init, scope, dependency.type)
    }
  }
  
  def private dispatch void generateMethods(InstantiatedDistribution distribution, BlangScope scope) {
    val String generatedName = generatedMethodName(distribution)
    val BlangScope restrictedScope = scope.restrict(distribution.dependencies)
    
    output.members += distribution.toMethod(generatedName, typeRef(distribution.distributionType)) [
      static = true
      for (BlangVariable variable : restrictedScope.variables()) {
        parameters += distribution.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder))
      }
      documentation = '''
        Code generated by: «expressionText(distribution)»
        This level of indirection is used to enforce scope restriction.'''
      body = '''
        return new «distribution.distributionType»();
      '''
    ]
    // One xExpression for each argument
    
    
    // Dependencies
    for (InitializerDependency dependency : StaticUtils::initializerDependencies(distribution.dependencies)) {
      generateXExpressionAuxMethod(dependency.init, scope, dependency.type)
    }
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
    val String generatedName = generatedMethodName(xExpression)
    output.members += xExpression.toMethod(generatedName, returnType) [ 
      visibility = JvmVisibility.PRIVATE
      static = true
      documentation = '''
        Auxiliary method generated to translate:
        «expressionText(xExpression)»'''
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
  
  def private List<ConstructorArgument> constructorParameters(InstantiatedDistribution distribution) {
    try { return _constructorParametersFromXtextIndex(distribution) } catch (Exception e) { System.err.println(e) }
    try { return _constructorParametersFromJavaObject(distribution) } catch (Exception e) { System.err.println(e) }
    return Collections.emptyList()   // TODO: error handling
  }
  
  def private List<ConstructorArgument> _constructorParametersFromXtextIndex(InstantiatedDistribution distribution) {
    val IResourceDescriptions descriptions = index.getResourceDescriptions(distribution.eResource.resourceSet)
    var JvmDeclaredType type = null
    
//    // DEBUG
//    println("-- BEG --")
//    for (IResourceDescription descr : descriptions.allResourceDescriptions) {
//      println(descr)
//      for (IEObjectDescription obj : descr.exportedObjects) {
//        obj.EObjectOrProxy
//      }
//      println("*") 
//    }
//    println("-- END --")
//    // END-DEBUG
    //distribution.eResource.resourceSet.resources.map[it.allContents.filter(distribution.distributionType.)]
    
    println("new test")
    for (Resource r : distribution.eResource.resourceSet.resources) {
      println(r)
      println(" " + r.contents)
      println("*")
    }
    println("end new test")
    
    
    
    for (e : descriptions.getExportedObjects(distribution.distributionType.eClass, QualifiedName.create(distribution.distributionType.qualifiedName), false)) {
      if (type !== null) {
        System.err.println("Warning: more than one match in constructorParametersFromXtextIndex()")
      }
      val uri = URI.createURI(e.EObjectURI.toString().replaceFirst("[.]bl.*", ".bl"))
      println("-->" + uri)
      val Resource res = distribution.eResource.resourceSet.getResource(uri, false)
      println("===>" + res)   //// looks good: org.eclipse.xtext.xbase.resource.BatchLinkableResource@3d457ed uri='platform:/resource/blangProjectTemplate/src/main/java/blangProjectTemplate/Bernoulli.bl'
      
      println("contents: " + res.contents)
      val BlangModel model = res.contents.iterator.next() as BlangModel
      println("law node size: " + model.lawNodes.size())   //// works! = 1
      
      val EClass eClass = e.EClass as EClass
      // TODO: better warning if more than one match
//      System.err.println( e. )
      System.err.println("is proxy?" + eClass.eIsProxy)
//      System.err.println( "# of declared constructors:" + type.declaredConstructors.size() )
//      System.err.println( "# of declared fields:" + type.declaredFields.size() )
    }
    val JvmConstructor constructor = {
      val Iterable<JvmConstructor> constructors = type.declaredConstructors
      if (constructors.size() !== 1) {
        throw new RuntimeException('''Expected size 1 but got «constructors.size()»''')
      }
      constructors.iterator.next()
    }
    
    if (type === null)
      throw new RuntimeException 
    
    val List<ConstructorArgument> result = new ArrayList
    for (JvmFormalParameter parameter : constructor.parameters) {
      var isParam = false
      for (JvmAnnotationReference annotation : parameter.annotations) {
        if (annotation.annotation.simpleName === Param.simpleName) {
          isParam = true
        }
      }
      val ConstructorArgument argument = new ConstructorArgument(typeRef(type), isParam)
      result.add(argument)
    }
    return result
  }
  
  def private List<ConstructorArgument> _constructorParametersFromJavaObject(InstantiatedDistribution distribution) {
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
      val ConstructorArgument argument = new ConstructorArgument(typeRef(parameter.getType()), isParam)
      result.add(argument)
    }
    return result
  }
  
  @Data
  static class ConstructorArgument {
    val JvmTypeReference boxedClass
    val boolean isParam
  }
}
