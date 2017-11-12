package ca.ubc.stat.blang.jvmmodel

import blang.core.DeboxedName
import blang.core.ForwardSimulator
import blang.core.IntVar
import blang.core.Model
import blang.core.ModelBuilder
import blang.core.Param
import blang.core.RealVar
import blang.core.WritableIntVar
import blang.core.WritableRealVar
import blang.inits.Arg
import ca.ubc.stat.blang.StaticJavaUtils
import ca.ubc.stat.blang.blangDsl.BlangDist
import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.Dependency
import ca.ubc.stat.blang.blangDsl.ForLoop
import ca.ubc.stat.blang.blangDsl.IndicatorDeclaration
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution
import ca.ubc.stat.blang.blangDsl.JavaDist
import ca.ubc.stat.blang.blangDsl.LawNode
import ca.ubc.stat.blang.blangDsl.LogScaleFactorDeclaration
import ca.ubc.stat.blang.blangDsl.VariableDeclaration
import ca.ubc.stat.blang.blangDsl.VariableDeclarationComponent
import ca.ubc.stat.blang.blangDsl.VariableType
import ca.ubc.stat.blang.jvmmodel.BlangScope.BlangVariable
import java.lang.annotation.Annotation
import java.lang.reflect.Constructor
import java.lang.reflect.Parameter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.ArrayList
import java.util.List
import java.util.Optional
import java.util.Random
import java.util.function.Supplier
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static ca.ubc.stat.blang.StaticUtils.eagerlyEvaluate
import static ca.ubc.stat.blang.StaticUtils.expressionText
import static ca.ubc.stat.blang.StaticUtils.getterName
import static ca.ubc.stat.blang.StaticUtils.setterName
import static ca.ubc.stat.blang.StaticUtils.initializerDependencies
import static ca.ubc.stat.blang.StaticUtils.isParam
import static ca.ubc.stat.blang.StaticUtils.uniqueDeclaredMethod
import blang.core.ModelComponent
import java.util.Collection
import blang.core.ConstantSupplier
import blang.core.Distribution
import blang.core.UnivariateModel
import blang.core.DistributionAdaptor
import blang.core.RealDistribution
import blang.core.RealDistributionAdaptor.WritableRealVarImpl
import blang.core.RealDistributionAdaptor
import blang.core.IntDistributionAdaptor
import blang.core.IntDistribution
import blang.core.IntDistributionAdaptor.WritableIntVarImpl
import ca.ubc.stat.blang.StaticUtils

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
    val JvmGenericType builderOutput = setupBuilder()
    val BlangScope globalScope = setupVariables(builderOutput)
    setupMain(builderOutput)
    // This first call to the method bodies involving XExpression (below) 
    // will only generate the auxiliary methods needed 
    // by the XExpressionProcessor machinery. 
    eagerlyEvaluate(componentsMethodBody(globalScope))                  
    eagerlyEvaluate(builderBody(globalScope))
    if (hasForwardGenerationBlock) { 
      eagerlyEvaluate(forwardSimulationMethodBody(globalScope))
    }
    // Once these auxiliary methods have been generated, we setup the 
    // generation the methods (ie. adding them to the generated types).
    // This two-pass approach is required to work around limitations of 
    // Xtext (one pass leads to a ConcurrentModificationException)
    xExpressions.endAuxiliaryMethodGenerationPhase() 
    generateConstructor(globalScope)
    generateBuilder(globalScope, builderOutput)
    generateComponentsMethod(globalScope)
    generateForwardSimulationMethod(globalScope)
    if (uniqueRandomVariable.present) {
      generateGetRealization
      generateStaticDistributionBuilder(globalScope)
    }
  } 
  
  def setupMain(JvmGenericType type) {
    val main = model.toMethod("main", typeRef(Void.TYPE)) [
      documentation = '''Utility main method for posterior inference on this model'''
      val String paramName = "arguments"
      parameters += model.toParameter(paramName, typeRef(StaticJavaUtils.STRING_ARRAY))
      body = '''
        «typeRef(StaticJavaUtils)».callRunner(«BUILDER_NAME».class, «paramName»);
      ''' 
    ]
    main.static = true
    output.members += main
  }
  
  def private void setupClass() { 
    if (model.package !== null) {
      output.packageName = model.package
    }
    for (annotation : model.annotations) {
      output.addAnnotation(annotation) 
    } 
    output.superTypes += typeRef(Model)
    if (uniqueRandomVariable.present) {
      output.superTypes += typeRef(UnivariateModel, uniqueRandomVariable.get.deboxedType)
    }
    if (hasForwardGenerationBlock) {
      output.superTypes += typeRef(ForwardSimulator)
    }
  }
  
  def private boolean hasForwardGenerationBlock() {
    return model.generationAlgorithm !== null
  }
  
  def private JvmGenericType setupBuilder() {
    val JvmGenericType builderOutput = model.toClass(BUILDER_NAME) [
      it.static = true
    ]
    builderOutput.superTypes += typeRef(ModelBuilder)
    output.members += builderOutput
    return builderOutput
  }
  
  // empty if none or more than one 'random' defined
  def private Optional<BlangVariable> uniqueRandomVariable() {
    var Optional<BlangVariable> result = Optional.empty
    for (VariableDeclaration variableDeclaration : model.variableDeclarations) {
      if (variableDeclaration.variableType == VariableType.RANDOM) {
        for (VariableDeclarationComponent varDeclComponent : variableDeclaration.getComponents()) {
          if (result.isPresent) {
            return Optional.empty
          } else {
            result = Optional.of(new BlangVariable(variableDeclaration.type, varDeclComponent.getName(), false))
          }
        }  
      }
    }
    return result
  }
  
  def private String isInitializedMethodName(String deboxedName) {
    return deboxedName + "_initialized";
  }
  
  def private BlangScope setupVariables(JvmGenericType builderOutput) {
    val BlangScope result = BlangScope::emptyScope
    for (VariableDeclaration variableDeclaration : model.variableDeclarations) {
      for (VariableDeclarationComponent varDeclComponent : variableDeclaration.getComponents()) {
        val String name = varDeclComponent.getName()
        val BlangVariable blangVariable = new BlangVariable(variableDeclaration.type, name, isParam(variableDeclaration.variableType))
        result += blangVariable
        // field
        output.members += variableDeclaration.toField(blangVariable.boxedName(), blangVariable.boxedType(_typeReferenceBuilder)) [
          final = true
          if (blangVariable.isParam)
            annotations += annotationRef(Param)
        ]
        // getter
        output.members += variableDeclaration.toMethod(getterName(blangVariable.deboxedName), blangVariable.deboxedType) [
          body = '''
            return «blangVariable.deboxingInvocationString»;
          '''
        ]
        // builder fields and setters
        val boolean optional = varDeclComponent.getVarInitBlock() !== null
        builderOutput.members += variableDeclaration.toField(blangVariable.deboxedName, optionalize(blangVariable.deboxedType, optional)) [
          visibility = JvmVisibility.PUBLIC
          annotations += annotationRef(Arg)
        ]
        if (!optional) {
          builderOutput.members += variableDeclaration.toField(isInitializedMethodName(blangVariable.deboxedName), typeRef("boolean")) [
            visibility = JvmVisibility.PRIVATE
          ]
        }
        builderOutput.members += variableDeclaration.toMethod(setterName(blangVariable.deboxedName), typeRef(builderOutput)) [
          parameters += model.toParameter(blangVariable.deboxedName, blangVariable.deboxedType)
          visibility = JvmVisibility.PUBLIC
          body = 
            '''
            «IF optional»
            // work around typeRef(..) limitation
            «typeRef(Optional, blangVariable.deboxedType)» «StaticUtils::generatedName("dummy")» = null;
            «ELSE»
            «isInitializedMethodName(blangVariable.deboxedName)» = true;
            «ENDIF»
            this.«blangVariable.deboxedName» = «IF optional»Optional.of(«blangVariable.deboxedName»)«ELSE»«blangVariable.deboxedName»«ENDIF»;
            return this;
            '''
        ]
      }
    }
    return result
  }
  
  def JvmTypeReference optionalize(JvmTypeReference deboxedType, boolean makeOptional) {
    if (makeOptional) {
      return typeRef(Optional, deboxedType)
    } else {
      return deboxedType
    }
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
  
  def private void generateBuilder(BlangScope scope, JvmGenericType builderOutput) {
    val JvmOperation method = model.toMethod(BUILDER_METHOD_NAME, typeRef(output)) [
      visibility = JvmVisibility.PUBLIC
      body = builderBody(scope)
    ]
    builderOutput.members += method
  }
  
  def private StringConcatenationClient builderBody(BlangScope globalScope) {
    val String prefixForFinalVariable = "__"
    val BlangScope incrementalScope = BlangScope::emptyScope
    return '''
      // For each optional type, either get the value, or evaluate the ?: expression
      «FOR variableDeclaration : model.variableDeclarations»
        «FOR varDeclComponent : variableDeclaration.components»
          «IF varDeclComponent.getVarInitBlock() !== null»
            «variableDeclaration.getType()» «varDeclComponent.getName()»;
            if (this.«varDeclComponent.getName()» != null && this.«varDeclComponent.getName()».isPresent()) {
              «varDeclComponent.getName()» = this.«varDeclComponent.getName()».get();
            } else {
              «varDeclComponent.getName()» = «xExpressions.process(varDeclComponent.getVarInitBlock(), incrementalScope, variableDeclaration.type)»;
            }
          «ELSE»
            if (!«isInitializedMethodName(varDeclComponent.getName())»)
              throw new RuntimeException("Not all fields were set in the builder, e.g. missing «varDeclComponent.getName()»");
          «ENDIF»
          final «variableDeclaration.getType()» «prefixForFinalVariable»«varDeclComponent.getName()» = «varDeclComponent.getName()»;
          «incrementalScope += new BlangVariable(variableDeclaration.type, varDeclComponent.name, false)»
        «ENDFOR»
      «ENDFOR»
      // Build the instance after boxing params
      return new «typeRef(output)»(
        «FOR BlangVariable variable : constructorOrder(globalScope) SEPARATOR ", "»
        «IF variable.param»
          new «typeRef(ConstantSupplier)»(«prefixForFinalVariable»«variable.deboxedName»)
        «ELSE»
          «prefixForFinalVariable»«variable.deboxedName»
        «ENDIF»
        «ENDFOR»
      );
    '''
  }
  
  def private void generateGetRealization() {
    output.members += model.toMethod(uniqueDeclaredMethod(UnivariateModel), uniqueRandomVariable.get.deboxedType) [
      visibility = JvmVisibility.PUBLIC
      body = '''
        return «uniqueRandomVariable.get.deboxedName»;
      '''
    ]
  }
  
  def private void generateStaticDistributionBuilder(BlangScope scope) {
    output.members += model.toMethod("distribution", distributionType) [
      visibility = JvmVisibility.PUBLIC
      static = true
      for (BlangVariable variable : constructorOrder(scope)) {
        if (!isRealOrIntDistributionType || variable.isParam) {
          val JvmFormalParameter param = model.toParameter(variable.deboxedName, variable.deboxedType) 
          if (variable.param) {
            param.annotations += annotationRef(Param) 
          }
          parameters += param
        }
      }
      body = '''
        «typeRef(UnivariateModel, uniqueRandomVariable.get.deboxedType)» univariateModel = new «model.name»(
          «FOR BlangVariable variable : constructorOrder(scope) SEPARATOR ", "»
            «IF variable.param»
              new «typeRef(ConstantSupplier)»(«variable.deboxedName»)
            «ELSE»
              «IF isRealOrIntDistributionType»
                new «writableVariableImpl»()
              «ELSE»
                «variable.deboxedName»
              «ENDIF»
            «ENDIF»
          «ENDFOR»
        );
        «typeRef(Distribution, uniqueRandomVariable.get.deboxedType)» distribution = new «typeRef(DistributionAdaptor)»(univariateModel);
        «IF isRealOrIntDistributionType»
          return new «adaptorType»(distribution);
        «ELSE»
          return distribution;
        «ENDIF»
      '''
      documentation = '''
        Returns an instance with fixed parameters values and conforming the Distribution interface. 
        Useful when passing around distributions as parameters, e.g. for Dirichlet Process mixtures. 
      '''
    ]
  }
  
  def JvmTypeReference adaptorType() {
    return switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : typeRef(RealDistributionAdaptor)
        case IntVar.canonicalName :  typeRef(IntDistributionAdaptor)
        default : throw new RuntimeException
      }
  }
  
  def JvmTypeReference distributionType() {
    return switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : typeRef(RealDistribution)
        case IntVar.canonicalName :  typeRef(IntDistribution)
        default : typeRef(Distribution, uniqueRandomVariable.get.deboxedType)
      }
  }
  
  def JvmTypeReference writableVariableImpl() {
    return switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : typeRef(WritableRealVarImpl)
        case IntVar.canonicalName :  typeRef(WritableIntVarImpl)
        default : throw new RuntimeException
      }
  }
  
  def boolean isRealOrIntDistributionType() {
    return switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : true
        case IntVar.canonicalName :  true
        default : false
      }
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
      body = '''
        «FOR BlangVariable variable : scope.variables»
        this.«variable.boxedName» = «variable.boxedName»;
        «ENDFOR»
      '''
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
  
  def private void generateForwardSimulationMethod(BlangScope scope) {
    if (!hasForwardGenerationBlock) {
      return
    }
    output.members += model.toMethod(FWD_SIM_METHOD_NAME, typeRef(Void.TYPE)) [
      visibility = JvmVisibility.PUBLIC
      parameters += model.generationAlgorithm.toParameter(model.generationRandom, typeRef(Random))
      body = forwardSimulationMethodBody(scope)
    ]
  }
  
  def private StringConcatenationClient forwardSimulationMethodBody(BlangScope scope) {
    val Optional<BlangVariable> uniqueRandomVariable = uniqueRandomVariable()
    val deboxedType = 
      switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : Double
        case IntVar.canonicalName :  Integer
        default : null
      }
    val writableType = 
      switch uniqueRandomVariable.get.deboxedType.qualifiedName {
        case RealVar.canonicalName : WritableRealVar
        case IntVar.canonicalName :  WritableIntVar
        default : null
      }
    val scopeWithRandom = scope.child(new BlangVariable(typeRef(Random), model.generationRandom, false))
    return 
      if (uniqueRandomVariable.isPresent && deboxedType !== null) {
        '''
          ((«typeRef(writableType)») «uniqueRandomVariable.get.deboxedName»).set(
            «xExpressions.process(model.generationAlgorithm, scopeWithRandom, typeRef(deboxedType))»
          );
        '''
      } else {
        '''
          «xExpressions.process(model.generationAlgorithm, scopeWithRandom, typeRef(Void.TYPE))»;
        '''
      }
  }
  
  def private void generateComponentsMethod(BlangScope scope) {
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
    val List<InitializerDependency> initializerDependencies = initializerDependencies(dependencies)
    return '''
    { // Code generated by: «expressionText(node)»
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
        )»);
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
    return '''«xExpressions.processLogScaleFactor(logScaleFactor.contents.factorBody, scope)»'''
  }
  
  def private dispatch StringConcatenationClient instantiateFactor(IndicatorDeclaration indic, BlangScope scope, BlangScope parentScope) {
    // The following creates two methods:
    // 1. "static LogScaleFactor method1(..)": with body "return new IndicatorDeclaration(() -> method2(..))" (the fact that IndicatorDeclaration's constructor argument (Support) is a functional interface is exploited here)
    // 2. "static Boolean method2(..)": with body given by the XExpression
    // In the components(..) body, method1() is called inside the line "components.add(___);" 
    return '''«xExpressions.processSupportFactor(indic.contents.factorBody, scope)»'''
  }
  
  def private dispatch String fullyQualifiedName(BlangDist blangDist) {
    val String prefix = 
      if (blangDist.distributionType.package === null) {
        ""
      } else {
        blangDist.distributionType.package + "."
      }
    return prefix + blangDist.distributionType.name
  }
  
  def private dispatch String fullyQualifiedName(JavaDist javaDist) {
    return javaDist.distributionType.identifier
  }
  
  def private dispatch StringConcatenationClient instantiateFactor(InstantiatedDistribution distribution, BlangScope scope, BlangScope parentScope) {
    // TODO: check # args match!!!
    val List<ConstructorArgument> constructorArguments = constructorParameters(distribution.typeSpec)
    val int nRandomVariables = constructorArguments.filter[!param].size()  // TODO: exception here; this is null when reference type not found
    return '''
      new «fullyQualifiedName(distribution.typeSpec)»(
        «FOR int index : 0 ..< constructorArguments.size() SEPARATOR ", "»
        «IF constructorArguments.get(index).param»
«««       For each argument that are param's, generate two methods:
«««       1. "static Supplier<ArgType> method1(..)": with body "return () -> method2()" (the fact that Supplier is a functional interface is exploited here)
«««       2. "static ArgType method2()": with body given by the XExpression
«««       In the components(..) body, method1() is called inside the segment constructed by the present method.
        «xExpressions.processSupplier(distribution.arguments.get(index - nRandomVariables), scope, constructorArguments.get(index).deboxedType)»
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
  
  def private dispatch List<ConstructorArgument> constructorParameters(BlangDist distribution) {
    val BlangModel model = distribution.distributionType
    // infer constructor ordering
    val List<ConstructorArgument> result = new ArrayList
    val VariableType[] order = #[VariableType.RANDOM, VariableType.PARAM]
    for (varType : order) {
      for (VariableDeclaration variableDecl : model.variableDeclarations.filter[it.variableType == varType]) {
        for (VariableDeclarationComponent item : variableDecl.components) {
          val boolean isParam = isParam(variableDecl.variableType)
          val ConstructorArgument argument = new ConstructorArgument(variableDecl.type, isParam)
          result.add(argument)
        }
      }
    }
    return result
  }

  def private dispatch List<ConstructorArgument> constructorParameters(JavaDist distribution) {
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
          extractSupplierType(parameter)
        else 
          typeRef(parameter.getType())
          
      val ConstructorArgument argument = new ConstructorArgument(typeRef, isParam)
      result.add(argument)
    }
    return result
  }
  
  def JvmTypeReference extractSupplierType(Parameter supplier) {
    if (!Supplier.isAssignableFrom(supplier.getType())) {
      throw new RuntimeException
    }
    
    val supplierType = supplier.parameterizedType as ParameterizedType
    val Type[] supplierTypeArgs = supplierType.actualTypeArguments
    if (supplierTypeArgs.length != 1) {
        throw new RuntimeException("Supplier must have exactly one type argument: " + supplierType)
    }
    
    return typeRef(supplierTypeArgs.get(0).typeName)
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
  
  val static final String FWD_SIM_METHOD_NAME = uniqueDeclaredMethod(ForwardSimulator) 
  val static final String COMPONENTS_METHOD_NAME = uniqueDeclaredMethod(Model) // = "components", but robust to re-factoring
  val public static final String COMPONENTS_LIST_NAME = "components"
  val public static final String BUILDER_NAME = "Builder"
  val static final String BUILDER_METHOD_NAME = uniqueDeclaredMethod(ModelBuilder)
}
