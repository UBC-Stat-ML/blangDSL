package ca.ubc.stat.blang.jvmmodel

import blang.core.Model
import blang.core.ModelComponent
import ca.ubc.stat.blang.StaticUtils
import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.ForLoop
import ca.ubc.stat.blang.blangDsl.IndicatorDeclaration
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution
import ca.ubc.stat.blang.blangDsl.LawNode
import ca.ubc.stat.blang.blangDsl.LogScaleFactorDeclaration
import ca.ubc.stat.blang.blangDsl.VariableDeclaration
import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import ca.ubc.stat.blang.jvmmodel.BlangScope.BlangVariable
import blang.core.Param
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.common.types.JvmTypeReference
import ca.ubc.stat.blang.blangDsl.Dependency
import java.util.List
import com.ibm.icu.impl.StringUCharacterIterator
import blang.factors.LogScaleFactor
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import org.eclipse.xtend2.lib.StringConcatenationClient
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
//  
//  def private StringConcatenationClient register(EObject key, StringConcatenationClient value) {
//     generatedCode.put(key, value)
//     // eagerly evaluate too
//     val String temp = '''«value»'''
//     temp.toString()
//     return value
//   }
  
  val static final String COMPONENTS_METHOD_NAME = StaticUtils::uniqueDeclaredMethod(Model)
  val static final String COMPONENTS_LIST_NAME = "components"
  
//  val private Map<EObject, StringConcatenationClient> generatedCode = new LinkedHashMap

  def String xExpressionGeneratedMethodCall(XExpression xExpression, BlangScope scope, JvmTypeReference returnType) {
      val String generatedName = StaticUtils::generatedMethodName(xExpression.hashCode)
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
    val String generatedName = StaticUtils::generatedMethodName(logScaleFactor.hashCode)
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
    val String generatedName = StaticUtils::generatedMethodName(logScaleFactor.hashCode)
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
    for (Dependency dependency : logScaleFactor.contents.dependencies) {
      switch (dependency) {
        InitializerDependency : {
          generateXExpressionAuxMethod(dependency.init, scope, dependency.type)
        }
      }
    }
    generateXExpressionAuxMethod(logScaleFactor.contents.factorBody, restrictedScope, typeRef(Double))
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
  
//  @Data
//  static class DependenciesTranslation {
//    val String translationString
//    val BlangScope newScope
//  }
//  
//  def private DependenciesTranslation translateDependencies(List<Dependency> dependencies, BlangScope enclosingScope) {
//    
//  }
  
  def private void generateXExpressionAuxMethod(XExpression xExpression, BlangScope scope, JvmTypeReference returnType) {
    val String generatedName = StaticUtils::generatedMethodName(xExpression.hashCode)
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
  
//  // TODO: refactor ModelParam name to ____
//  def private dispatch String translate(ModelParam modelParam, BlangScope scope) {
//    // Create scope from deps
//    val BlangScope newScope = BlangScope::emptyScope
//    return '''
//      {
//        
//        components.add(new «modelParam.right.clazz.type.identifier»(
//          // first constructor argument is random variable, followings (if any) are parameters
//          «modelParam.name»«FOR int paramIndex : 0 ..< modelParam.right.param.size», // may need index because makes it easier to get type
//          «translateParam(argumentParam, newScope)»
//          «ENDFOR»)
//        );
//      }
//    '''
//  }
//  
//  @Data
//  static class InstantiatedDistributionScopeTranslation {
//    
//    val String scopeTranslationString
//    val BlangScope newScope
//    
//    new (BlangScope enclosingScope, )
//    
//  }
//  
//  // TODO: avoid brackets for closures - later!
//  
//  def private String translateParam(XExpression argumentParam, BlangScope scope) {
//    // generate static class
//    
//    // return instantiation call
//  }
//  
//  def private void addImplementation() {
//    if (model.laws?.modelComponents != null && !model.laws.modelComponents.empty) {
//      val map = collectModels(model.laws.modelComponents, new HashMap)
//      extendLoopModels(model.laws.modelComponents, new ArrayList)
//      output.members += model.toMethod("components", typeRef(Collection, typeRef(blang.core.ModelComponent))) [
//        visibility = JvmVisibility.PUBLIC
//        body = '''
//          «typeRef(ArrayList, typeRef(blang.core.ModelComponent))» components = new «typeRef(ArrayList)»();
//          
//          «FOR i : 0..<model.laws.modelComponents.size»
//            «generateModelComponentInit(model.laws.modelComponents.get(i), i)»
//          «ENDFOR»
//          
//          return components;
//        '''
//      ]
//
//      for (entry : map.entrySet) {
//        val component = entry.key
//        val componentCounter = entry.value
//        switch (component) {
//          ModelParam:
//            for (paramCounter : 0 ..< component.right.param.size) {
//              output.members += generateModelComponentParamSupplier(component, componentCounter, paramCounter)
//            }
//          SupportFactor:
//            output.members += generateSupportFactor(component, componentCounter)
//          LogScaleFactor:
//            output.members += generateLogScaleFactor(component, componentCounter)
//          default:
//            throw new IllegalArgumentException("Cannot generate a supplier class for " + component.class)
//        }
//      }
//    }    
//  }
//  
//  // creates unique ids for model components
//  def private Map<ModelComponent, Integer> collectModels(List<ModelComponent> components,
//    Map<ModelComponent, Integer> componentMap) {
//    for (c : components) {
//      switch (c) {
//        ForLoop:
//          collectModels(c.body, componentMap)
//        default:
//          if (componentMap.putIfAbsent(c, componentMap.size) != null) throw new Exception("Duplicate model component?")
//      }
//    }
//    componentMap
//  }
//
//  // add iterator variables to component's scopes
//  def private void extendLoopModels(List<ModelComponent> components, List<String> loopVars) {
////    for (c : components) {
////      switch (c) {
////        ForLoop: {
////          loopVars.add(c.initExpression.name)
////          extendLoopModels(c.body, loopVars)
////          loopVars.remove(loopVars.size - 1)
////        }
////        SupportFactor:
////          for (v : loopVars)
////            c.params += v
////        LogScaleFactor:
////          for (v : loopVars)
////            c.params += v
////        ModelParam:
////          for (v : loopVars) {
////            c.deps += new DependencyImpl() {
////              override getName() {
////                v
////              }
////            }
////          }
////        default:
////          throw new IllegalArgumentException("Not sure how to extend loop model " + c)
////      }
////    }
//  }
//
//  def private dispatch CharSequence generateModelComponentInit(ForLoop component,
//    int modelCounter) {
////    '''
////      for («expressionText(component.initExpression)»; «expressionText(component.testExpression)»; «expressionText(component.updateExpression)») {
////        «FOR e : component.body»
////          «generateModelComponentInit(e, modelCounter)»
////        «ENDFOR»
////      }
////    '''
//  }
//
//  def private expressionText(EObject ex) {
//    NodeModelUtils.getTokenText(NodeModelUtils.getNode(ex))
//  }
//
//  def private dispatch generateModelComponentInit(ModelParam component, int modelCounter) {
//    '''
//      components.add(new «component.right.clazz.type.identifier»(
//          «component.name»«FOR i : 0..<component.right.param.size»,
//          new $Generated_SupplierSubModel«modelCounter»Param«i»(«
//                    FOR d : component.deps SEPARATOR ", "»«
//                      d.init ?: d.name»«
//                    ENDFOR
//                    »)«ENDFOR»)
//      );
//    '''
//  }
//
//  def private dispatch generateModelComponentInit(SupportFactor component,
//    int modelCounter) {
//    '''components.add(new «typeRef(blang.core.SupportFactor).identifier»(new $Generated_SetupSupport«modelCounter»(«FOR p : component.params SEPARATOR ", "»«
//                      p»«ENDFOR»)));'''
//  }
//
//  def private dispatch generateModelComponentInit(LogScaleFactor component, int modelCounter) {
//    '''components.add(new $Generated_LogScaleFactor«modelCounter»(«FOR p : component.params SEPARATOR ", "»«
//              p»«ENDFOR»));'''
//  }
//
//  def private JvmGenericType generateModelComponentParamSupplier(ModelParam component, int modelCounter, int paramCounter) {
//    val dist = component.right.clazz.type
//    val distClass = Class.forName(dist.identifier)
//    val distCtors = distClass.constructors
//    val distCtor = distCtors?.get(0)
//    val paramType = distCtor.genericParameterTypes.get(paramCounter + 1)
//    val paramTypeArgs = (paramType as ParameterizedType).actualTypeArguments
//    val Param param = component.right.param.get(paramCounter)
//    val paramSupplierTypeRef = typeRef(Supplier, typeRef(paramTypeArgs.get(0).typeName))
//
//    param.toClass("$Generated_SupplierSubModel" + modelCounter + "Param" + paramCounter) [
//      it.superTypes += paramSupplierTypeRef
//      it.static = true
//      for (dep : component.deps) {
//        it.members += param.toField(dep.name, dep.type ?: getVarType(param, dep.name)) [
//          final = true
//        ]
//      }
//      it.members += param.toConstructor [
//        visibility = JvmVisibility.PUBLIC
//        for (dep : component.deps) {
//          parameters += param.toParameter(dep.name, dep.type ?: getVarType(param, dep.name))
//        }
//        body = '''
//          «FOR dep : component.deps»
//            this.«dep.name» = «dep.name»;
//          «ENDFOR»
//        '''
//      ]
//
//      it.members += param.toMethod("get", typeRef(paramTypeArgs.get(0).typeName)) [
//        annotations += annotationRef("java.lang.Override")
//        switch (param) {
//          ConstParam:
//            body = '''return «param.id»;'''
//          LazyParam:
//            body = param.expr
//        }
//      ]
//    ]
//  }
//
//  def private generateSupportFactor(SupportFactor factor, int modelCounter) {
//    factor.toClass("$Generated_SetupSupport" + modelCounter) [
//      it.superTypes += typeRef(blang.core.SupportFactor.Support)
//      it.static = true
//      for (p : factor.params) {
//        it.members += factor.toField(p, getVarType(factor, p)) [
//          final = true
//        ]
//      }
//
//      it.members += factor.toConstructor [
//        it.visibility = JvmVisibility.PUBLIC
//        for (p : factor.params) {
//          parameters += factor.toParameter(p, getVarType(factor, p))
//        }
//        body = '''
//          «FOR p : factor.params»
//            this.«p» = «p»;
//          «ENDFOR»
//        '''
//      ]
//
//      it.members += factor.expr.toMethod("isInSupport", typeRef(boolean)) [
//        annotations += annotationRef("java.lang.Override")
//        body = '''
//          return $isInSupport(«FOR p : factor.params SEPARATOR ", "»«p»«
//                      IF isLazy(getVarType(factor, p)) ».get()« ENDIF»«ENDFOR»);
//        '''
//      ]
//      it.members += factor.expr.toMethod("$isInSupport", typeRef(boolean)) [
//        visibility = JvmVisibility.PRIVATE
//        for (p : factor.params) {
//          var varType = getVarType(factor, p)
//          if (isLazy(varType)) varType = (varType as JvmParameterizedTypeReference).getArguments().get(0)
//          parameters += factor.toParameter(p, varType)
//        }
//        body = factor.expr
//      ]
//    ]
//  }
//
//  def private generateLogScaleFactor(LogScaleFactor factor, int modelCounter) {
//    factor.toClass("$Generated_LogScaleFactor" + modelCounter) [
//      it.superTypes += typeRef(blang.factors.LogScaleFactor)
//      it.static = true
//
//      for (p : factor.params) {
//        it.members += factor.toField(p, getVarType(factor, p)) [
//          final = true
//        ]
//      }
//
//      it.members += factor.toConstructor [
//        it.visibility = JvmVisibility.PUBLIC
//        for (p : factor.params) {
//          parameters += factor.toParameter(p, getVarType(factor, p))
//        }
//        body = '''
//          «FOR p : factor.params»
//            this.«p» = «p»;
//          «ENDFOR»
//        '''
//      ]
//
//      it.members += factor.expr.toMethod("logDensity", typeRef(double)) [
//        annotations += annotationRef("java.lang.Override")
//        body = '''
//          return $logDensity(«FOR p : factor.params SEPARATOR ", "»«p»«
//                      IF isLazy(getVarType(factor, p)) ».get()« ENDIF»«ENDFOR»);
//        '''
//      ]
//      it.members += factor.expr.toMethod("$logDensity", typeRef(double)) [
//        visibility = JvmVisibility.PRIVATE
//        for (p : factor.params) {
//          parameters += factor.toParameter(p, model.vars.findFirst[name == p].type)
//        }
//        body = factor.expr
//      ]
//    ]
//  }
//
//  def private JvmTypeReference getVarType(EObject container, String name) {
//    switch (container) {
//      ForLoop:
//        return null
////        if (name.equals(container.initExpression?.name)) {
////          val JvmTypeReference type = container.initExpression.type
////          return if (expressionText(type) == "int") typeRef("int") else type
////        } else {
////          return getVarType(container.eContainer, name)
////        }
//      BlangModel:
//        for (v : container.vars) {
//          if (v.name.equals(name)) return getVarType(v)
//        }
//      default:
//        return getVarType(container.eContainer, name)
//    }
//    throw new RuntimeException("No such variable: " + name)
//
//  }
//
//  def private getVarType(ModelVar v) {
//    switch (v.qualType) {
//      case "random": v.type
//      case "param": typeRef(Supplier, v.type)
//      default :
//        throw new RuntimeException
//    }
//  }
//
//  def private isLazy(JvmTypeReference type) {
//    type.identifier.startsWith("java.util.function.Supplier")
//  }

}
