package ca.ubc.stat.blang.jvmmodel

import blang.core.DeboxedName
import blang.core.LogScaleFactor
import blang.core.Model
import blang.core.ModelComponent
import blang.core.Param
import blang.core.SupportFactor
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
import ca.ubc.stat.blang.blangDsl.VariableType
import ca.ubc.stat.blang.jvmmodel.BlangScope.BlangVariable
import java.lang.annotation.Annotation
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Parameter
import java.util.ArrayList
import java.util.Collection
import java.util.List
import java.util.function.Supplier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import blang.inits.ConstructorArg
import blang.inits.DesignatedConstructor
import org.eclipse.xtext.naming.IQualifiedNameConverter

/**
 * SingleBlangModelInferrer gets instantiated for each model being inferred.
 */
class SingleBlangModelInferrer {

  // input: an AST for a single model
  val private BlangModel model

  // output: a generated type
  val private JvmDeclaredType output
  
  // used to work around some xText limitations when
  // working with XExpressions 
  val private XExpressionProcessor xExpressions

  // extension facilities provided by xtext
  val extension private JvmTypesBuilder _typeBuilder
  val extension private JvmAnnotationReferenceBuilder _annotationTypesBuilder
  val extension private JvmTypeReferenceBuilder _typeReferenceBuilder
  val extension private IResourceDescriptionsProvider index
  val IQualifiedNameConverter qualNameConverter
  
  def void infer() {
    setupClass()
    val BlangScope globalScope = setupVariables()
    // This first call will only generate the auxiliary methods needed 
    // by the XExpressionProcessor machinery. 
    StaticUtils::eagerlyEvaluate(componentsMethodBody(globalScope))
    StaticUtils::eagerlyEvaluate(constructorBody(globalScope))
    // Once the auxiliary methods have been generated, setup the 
    // generation of "components(..)" itself.
    // This two-pass approach is required to work around limitations of 
    // Xtext (one pass leads to a ConcurrentModificationException)
    xExpressions.endAuxiliaryMethodGenerationPhase() 
    generateConstructor(globalScope)
    generateFixedParamStaticMethod(globalScope)
    generateMethods(globalScope)
  }
  
  def private void setupClass() { 
    if (model.package != null) {
      output.packageName = model.package
    }
    output.superTypes += typeRef(Model)
  }
  
  def private BlangScope setupVariables() {
    val BlangScope result = BlangScope::emptyScope
    for (VariableDeclaration variableDeclaration : model.variableDeclarations) {
      for (String name : variableDeclaration.getNames()) {
        val BlangVariable blangVariable = new BlangVariable(variableDeclaration.type, name, StaticUtils::isParam(variableDeclaration.variableType))
        result += blangVariable
        // field
        output.members += variableDeclaration.toField(blangVariable.boxedName(), blangVariable.boxedType(_typeReferenceBuilder)) [
          final = true
          if (blangVariable.isParam)
            annotations += annotationRef(Param)
        ]
        // getter
        output.members += variableDeclaration.toMethod(StaticUtils::getterName(blangVariable.deboxedName), blangVariable.deboxedType) [
          body = '''
            return «blangVariable.deboxingInvocationString»;
          '''
        ]
      }
    }
    return result
  }
  
  def static private List<BlangVariable> constructorOrder(BlangScope scope) {
    var List<BlangVariable> result = new ArrayList
    val boolean [] variablesOrder = #[false, true]; // isParam == false, then, isParam == true
    for (boolean isParam : variablesOrder) {
      for (BlangVariable variable : scope.variables.filter[it.param === isParam]) {
        result.add(variable)
      }
    }
    return result
  }
  
  def private void generateFixedParamStaticMethod(BlangScope scope) {
    val JvmOperation method = model.toMethod(BUILD_WITH_CONSTANT_PARAMS_STATIC_METHOD_NAME, typeRef(output)) [
      visibility = JvmVisibility.PUBLIC
      static = true
      for (BlangVariable variable : constructorOrder(scope)) {
        val JvmFormalParameter param = model.toParameter(variable.deboxedName, variable.deboxedType)
        if (variable.param) {
          param.annotations += annotationRef(Param) 
        }
        param.annotations += annotationRef(ConstructorArg, variable.deboxedName)
        parameters += param
      }
      body = '''
        return new «typeRef(output)»(
          «FOR BlangVariable variable : constructorOrder(scope) SEPARATOR ", "»
          «IF variable.param»
            () -> «variable.deboxedName»
          «ELSE»
            «variable.deboxedName»
          «ENDIF»
          «ENDFOR»
        );
      '''
    ]
    method.annotations += annotationRef(DesignatedConstructor)
    output.members += method
  }
  
  def StringConcatenationClient constructorBody(BlangScope scope) {
    return '''
        «FOR BlangVariable variable : scope.variables»
        this.«variable.boxedName» = «variable.boxedName»;
        «ENDFOR»
        «IF model.initBlock !== null»«xExpressions.process(model.initBlock, scope, typeRef(Void.TYPE))»;«ENDIF»
      '''
  }
  
  def private void generateConstructor(BlangScope scope) {
    output.members += model.toConstructor[
      visibility = JvmVisibility.PUBLIC
      for (BlangVariable variable : constructorOrder(scope)) {
        val JvmFormalParameter param = model.toParameter(variable.boxedName, variable.boxedType(_typeReferenceBuilder)) 
        if (variable.param) {
          param.annotations += annotationRef(Param) 
        }
        param.annotations += annotationRef(DeboxedName, variable.deboxedName)
        parameters += param
      }
      body = constructorBody(scope)
      documentation = '''
        Note: the generated code has the following properties used at runtime:
          - all arguments are annotated with a BlangVariable annotation
          - params additionally have a Param annotation
          - the order of the arguments is as follows:
            - first, all the random variables in the order they occur in the blang file
            - second, all the params in the order they occur in the blang file
      '''
    ]
  }
  
  def private void generateMethods(BlangScope scope) {
    output.members += model.toMethod(COMPONENTS_METHOD_NAME, typeRef(Collection, typeRef(ModelComponent))) [
      visibility = JvmVisibility.PUBLIC
      documentation = '''
        A component can be either a distribution, support constraint, or another model  
        which recursively defines additional components.'''
      body = componentsMethodBody(scope)
    ]
  }

  /**
   * Entry point of generation of the body of the method components(), the core of a probabilistic model.
   */
  def private StringConcatenationClient componentsMethodBody(BlangScope scope) {
    return '''
      «typeRef(ArrayList, typeRef(ModelComponent))» «COMPONENTS_LIST_NAME» = new «typeRef(ArrayList)»();
      
      «FOR LawNode node : model.lawNodes»
        «componentsMethodBody(node, scope)»
      «ENDFOR»
      
      return «COMPONENTS_LIST_NAME»;
    '''
  }
  
  /*
   * Recursively generate the body of the components() method via a dispatch/recursive collection of methods.
   */

  def private dispatch StringConcatenationClient componentsMethodBody(ForLoop forLoop, BlangScope scope) {
    val BlangVariable iteratorVariable = new BlangVariable(forLoop.iteratorType, forLoop.name, false)
    val BlangScope childScope = scope.child(iteratorVariable)
    return  '''
      for («forLoop.iteratorType» «forLoop.name» : «xExpressions.process(forLoop.iteratorRange, scope, typeRef(Iterable,forLoop.iteratorType))») {
        «FOR node : forLoop.loopBody»
        «componentsMethodBody(node, childScope)»
        «ENDFOR»
      }
    '''
  }
  
  def private dispatch StringConcatenationClient componentsMethodBody(LogScaleFactorDeclaration factor, BlangScope scope) {
    return componentsMethodBody(factor, scope, factor.contents.dependencies)
  }
  
  def private dispatch StringConcatenationClient componentsMethodBody(IndicatorDeclaration factor, BlangScope scope) {
    return componentsMethodBody(factor, scope, factor.contents.dependencies)
  }
  
  def private dispatch StringConcatenationClient componentsMethodBody(InstantiatedDistribution instantiatedDist, BlangScope scope) {
    return componentsMethodBody(instantiatedDist, scope, instantiatedDist.dependencies)
  }
  
  /**
   * Common behavior extracted for LogScaleFactorDeclaration, IndicatorDeclaration, InstantiatedDistribution:
   * - taking care of dependencies,
   * - creation of a scope restricted to dependencies,
   * - creating and adding factor to collection.
   */
  def private StringConcatenationClient componentsMethodBody(LawNode node, BlangScope scope, List<Dependency> dependencies) {
    // Initializer dependencies are sub-statements of the form "Type name = <XExpression>"; 
    // their RHS are executed at initialization.
    val List<InitializerDependency> initializerDependencies = StaticUtils::initializerDependencies(dependencies)
    return '''
    { // Code generated by: «StaticUtils::expressionText(node)»
      «IF !initializerDependencies.isEmpty()»// Required initialization:«ENDIF»
      «FOR InitializerDependency dependency : initializerDependencies»
      «dependency.type» «dependency.name» = «xExpressions.process(dependency.init, scope, dependency.type)»;
      «ENDFOR»
      // Construction and addition of the factor/model:
      «COMPONENTS_LIST_NAME».add(
        «instantiateFactor( 
          node, 
          /* Enforces using only dependencies: */ 
          scope.restrict(dependencies), 
          /* Outer scope still needed in arguments of distributions instantiations: */ 
          scope
        )»
      );
    }
    '''
  }
  
  /*
   * instantiateFactor deals with the particularities between defining new factors (via logf and indicator) vs 
   * invoking one (via ~)
   */
   
  /*
   * Note: in the following documentation, "method1" and "method2" refer to globally, uniquely generated method names.
   * Low-level details needed to cover XExpressions are covered in the class XExpressionProcessor.
   */
  
  def private dispatch StringConcatenationClient instantiateFactor(LogScaleFactorDeclaration logScaleFactor, BlangScope scope, BlangScope parentScope) {
    // The following creates two methods:
    // 1. "static LogScaleFactor method1(..)": with body "return () -> method2(..)" (the fact that LogScaleFactor is a functional interface is exploited here)
    // 2. "static Double method2(..)": with body given by the XExpression
    // In the components(..) body, method1() is called inside the line "components.add(___);" 
    return '''«xExpressions.process_via_functionalInterface(logScaleFactor.contents.factorBody, scope, typeRef(Double), typeRef(LogScaleFactor))»'''
  }
  
  def private dispatch StringConcatenationClient instantiateFactor(IndicatorDeclaration indic, BlangScope scope, BlangScope parentScope) {
    // The following creates two methods:
    // 1. "static LogScaleFactor method1(..)": with body "return new IndicatorDeclaration(() -> method2(..))" (the fact that IndicatorDeclaration's constructor argument (Support) is a functional interface is exploited here)
    // 2. "static Boolean method2(..)": with body given by the XExpression
    // In the components(..) body, method1() is called inside the line "components.add(___);" 
    return '''«xExpressions.process_via_constructionOfAnotherType(indic.contents.factorBody, scope, typeRef(Boolean), typeRef(SupportFactor))»'''
  }
  
  def private dispatch StringConcatenationClient instantiateFactor(InstantiatedDistribution distribution, BlangScope scope, BlangScope parentScope) {
    // TODO: check # args match!!!
    val List<ConstructorArgument> constructorArguments = constructorParameters(distribution)
    val int nRandomVariables = constructorArguments.filter[!param].size()  // TODO: exception here; this is null when reference type not found
    return '''
      new «distribution.distributionType»(
        «FOR int index : 0 ..< constructorArguments.size() SEPARATOR ", "»
        «IF constructorArguments.get(index).param»
«««       For each argument that are param's, generate two methods:
«««       1. "static Supplier<ArgType> method1(..)": with body "return () -> method2()" (the fact that Supplier is a functional interface is exploited here)
«««       2. "static ArgType method2()": with body given by the XExpression
«««       In the components(..) body, method1() is called inside the segment constructed by the present method.
        «xExpressions.process_via_functionalInterface(distribution.arguments.get(index - nRandomVariables), scope, constructorArguments.get(index).deboxedType, typeRef(Supplier, constructorArguments.get(index).deboxedType))»
        «ELSE»
        «xExpressions.process(distribution.generatedVariables.get(index), parentScope, constructorArguments.get(index).deboxedType)»
        «ENDIF»
        «ENDFOR»
      )
    '''
  }
  
  /*
   * For technical reasons, we need to look into other model's constructors to find out which variables are param and 
   * which are random. The following deal with this aspect.
   */
  
  def private List<ConstructorArgument> constructorParameters(InstantiatedDistribution distribution) {
    try { return _constructorParametersFromXtextIndex(distribution) } catch (Exception e) { e.printStackTrace }
    try { return _constructorParametersFromJavaObject(distribution) } catch (Exception e) { e.printStackTrace }
    return null   // TODO: error handling
  }
  
  def private <T> T first(Iterable<T> iterable) {
    if (iterable.size() != 1) {
      System.err.println("Warning: number of matches was expected to be 1, found: " + iterable.size()) // TODO: make this more robust
      System.err.println(iterable)
    }
    return iterable.iterator().next()
  }
  
  def private List<ConstructorArgument> _constructorParametersFromXtextIndex(InstantiatedDistribution distribution) {
    val IResourceDescriptions descriptions = index.getResourceDescriptions(distribution.eResource.resourceSet)
    
    // Get qualified name
    val QualifiedName qualName = qualNameConverter.toQualifiedName(distribution.distributionType.qualifiedName)
    
    // get URI using the index
    val IEObjectDescription objectDescription = first(descriptions.getExportedObjects(distribution.distributionType.eClass, qualName, false))
    val uri = URI.createURI(objectDescription.EObjectURI.toString().replaceFirst("[.]bl[#].*", ".bl"))
    
    // load object if possible
    val Resource resource = distribution.eResource.resourceSet.getResource(uri, false)
    val BlangModel model = first(resource.contents.filter[it instanceof BlangModel]) as BlangModel
    
    // infer constructor ordering
    val List<ConstructorArgument> result = new ArrayList
    val VariableType[] order = #[VariableType.RANDOM, VariableType.PARAM]
    for (varType : order) {
      for (VariableDeclaration variableDecl : model.variableDeclarations.filter[it.variableType == varType]) {
        for (String name : variableDecl.names) {
          val boolean isParam = StaticUtils::isParam(variableDecl.variableType)
          val ConstructorArgument argument = new ConstructorArgument(variableDecl.type, isParam)
          result.add(argument)
        }
      }
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
      val JvmTypeReference typeRef = 
        if (isParam)
          extractSupplierType(parameter.getType())
        else 
          typeRef(parameter.getType())
          
      val ConstructorArgument argument = new ConstructorArgument(typeRef, isParam)
      result.add(argument)
    }
    return result
  }
  
  def JvmTypeReference extractSupplierType(Class<?> supplier) {
    if (!Supplier.isAssignableFrom(supplier)) {
      throw new RuntimeException
    }
    for (Method method : supplier.methods) {
      if (method.name === "get") {
        return typeRef(method.returnType)
      }
    }
    throw new RuntimeException
  }
  
  @Data
  static class ConstructorArgument {
    val JvmTypeReference deboxedType
    val boolean isParam
  }
  
  new(
    BlangModel model, 
    JvmDeclaredType output, 
    JvmTypesBuilder _typeBuilder, 
    JvmAnnotationReferenceBuilder _annotationTypesBuilder, 
    JvmTypeReferenceBuilder _typeReferenceBuilder, 
    IResourceDescriptionsProvider index,
    IQualifiedNameConverter qualNameConverter
  ) {
    this.model = model
    this.output = output
    this._typeBuilder = _typeBuilder
    this._annotationTypesBuilder = _annotationTypesBuilder
    this._typeReferenceBuilder = _typeReferenceBuilder
    this.index = index
    this.xExpressions = new XExpressionProcessor(output, _typeBuilder, _typeReferenceBuilder)
    this.qualNameConverter = qualNameConverter
  }
  
  val static final String COMPONENTS_METHOD_NAME = StaticUtils::uniqueDeclaredMethod(Model) // = "components", but robust to re-factoring
  val static final String COMPONENTS_LIST_NAME = "components"
  
  val static final String BUILD_WITH_CONSTANT_PARAMS_STATIC_METHOD_NAME = "buildWithConstantParams"
}
