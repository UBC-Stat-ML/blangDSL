package ca.ubc.stat.blang.jvmmodel

import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.ConstParam
import ca.ubc.stat.blang.blangDsl.ForLoop
import ca.ubc.stat.blang.blangDsl.LazyParam
import ca.ubc.stat.blang.blangDsl.LogScaleFactor
import ca.ubc.stat.blang.blangDsl.ModelComponent
import ca.ubc.stat.blang.blangDsl.ModelParam
import ca.ubc.stat.blang.blangDsl.ModelVar
import ca.ubc.stat.blang.blangDsl.Param
import ca.ubc.stat.blang.blangDsl.SupportFactor
import ca.ubc.stat.blang.blangDsl.impl.DependencyImpl
import java.lang.reflect.ParameterizedType
import java.util.List
import java.util.Map
import java.util.function.Supplier
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import blang.core.Model
import java.util.Collection
import java.util.HashMap
import java.util.ArrayList

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

    if (model.packageName != null) {
      output.packageName = model.packageName;
    }

    output.superTypes += typeRef(Model)

    for (varDecl : model.vars) {
      output.members += varDecl.toField(varDecl.name, getVarType(varDecl)) [
        it.visibility = JvmVisibility.PUBLIC
        it.final = true
      ]
    }
    for (varDecl : model.consts) {
      output.members += varDecl.toField(varDecl.name, varDecl.type) [
        visibility = JvmVisibility.DEFAULT
        it.final = true
        it.static = true
        initializer = varDecl.right
      ]
    }

    if (model.vars != null && !model.vars.empty) {
      output.members += model.toConstructor [
        visibility = JvmVisibility.PUBLIC
        // Random variables show up earlier in the constructor parameters
        for (varDecl : model.vars.filter[qualType == 'random']) {
          parameters += varDecl.toParameter(varDecl.name, getVarType(varDecl))
        }
        for (varDecl : model.vars.filter[qualType != 'random']) {
          parameters += varDecl.toParameter(varDecl.name, getVarType(varDecl))
        }
        body = '''
          «FOR varDecl : model.vars»
            this.«varDecl.name» = «varDecl.name»;
          «ENDFOR»
        '''
      ]
    }

    if (model.laws?.modelComponents != null && !model.laws.modelComponents.empty) {
      val map = collectModels(model.laws.modelComponents, new HashMap)
      extendLoopModels(model.laws.modelComponents, new ArrayList)
      output.members += model.toMethod("components", typeRef(Collection, typeRef(blang.core.ModelComponent))) [
        visibility = JvmVisibility.PUBLIC
        body = '''
          «typeRef(ArrayList, typeRef(blang.core.ModelComponent))» components = new «typeRef(ArrayList)»();
          
          «FOR i : 0..<model.laws.modelComponents.size»
            «generateModelComponentInit(model.laws.modelComponents.get(i), i)»
          «ENDFOR»
          
          return components;
        '''
      ]

      for (entry : map.entrySet) {
        val component = entry.key
        val componentCounter = entry.value
        switch (component) {
          ModelParam:
            for (paramCounter : 0 ..< component.right.param.size) {
              output.members += generateModelComponentParamSupplier(component, componentCounter, paramCounter)
            }
          SupportFactor:
            output.members += generateSupportFactor(model, component, componentCounter)
          LogScaleFactor:
            output.members += generateLogScaleFactor(model, component, componentCounter)
          default:
            throw new IllegalArgumentException("Cannot generate a supplier class for " + component.class)
        }
      }
    }
  }

  def Map<ModelComponent, Integer> collectModels(List<ModelComponent> components,
    Map<ModelComponent, Integer> componentMap) {
    for (c : components) {
      switch (c) {
        ForLoop:
          collectModels(c.body, componentMap)
        default:
          if (componentMap.putIfAbsent(c, componentMap.size) != null) throw new Exception("Duplicate model component?")
      }
    }
    componentMap
  }

  def void extendLoopModels(List<ModelComponent> components, List<String> loopVars) {
    for (c : components) {
      switch (c) {
        ForLoop: {
          loopVars.add(c.initExpression.name)
          extendLoopModels(c.body, loopVars)
          loopVars.remove(loopVars.size - 1)
        }
        SupportFactor:
          for (v : loopVars)
            c.params += v
        LogScaleFactor:
          for (v : loopVars)
            c.params += v
        ModelParam:
          for (v : loopVars) {
            c.deps += new DependencyImpl() {
              override getName() {
                v
              }
            }
          }
        default:
          throw new IllegalArgumentException("Not sure how to extend loop model " + c)
      }
    }
  }

  def dispatch CharSequence generateModelComponentInit(ForLoop component,
    int modelCounter) {
    '''
      for («expressionText(component.initExpression)»; «expressionText(component.testExpression)»; «expressionText(component.updateExpression)») {
        «FOR e : component.body»
          «generateModelComponentInit(e, modelCounter)»
        «ENDFOR»
      }
    '''
  }

  def expressionText(EObject ex) {
    NodeModelUtils.getTokenText(NodeModelUtils.getNode(ex))
  }

  def dispatch generateModelComponentInit(ModelParam component, int modelCounter) {
    '''
      components.add(new «component.right.clazz.type.identifier»(
          «component.name»«FOR i : 0..<component.right.param.size»,
          new $Generated_SupplierSubModel«modelCounter»Param«i»(«
                    FOR d : component.deps SEPARATOR ", "»«
                      d.init ?: d.name»«
                    ENDFOR
                    »)«ENDFOR»)
      );
    '''
  }

  def dispatch generateModelComponentInit(SupportFactor component,
    int modelCounter) {
    '''components.add(new «typeRef(blang.core.SupportFactor).identifier»(new $Generated_SetupSupport«modelCounter»(«FOR p : component.params SEPARATOR ", "»«
                      p»«ENDFOR»)));'''
  }

  def dispatch generateModelComponentInit(LogScaleFactor component, int modelCounter) {
    '''components.add(new $Generated_LogScaleFactor«modelCounter»(«FOR p : component.params SEPARATOR ", "»«
              p»«ENDFOR»));'''
  }

  def generateModelComponentParamSupplier(ModelParam component, int modelCounter, int paramCounter) {
    val dist = component.right.clazz.type
    val distClass = Class.forName(dist.identifier)
    val distCtors = distClass.constructors
    val distCtor = distCtors?.get(0)
    val paramType = distCtor.genericParameterTypes.get(paramCounter + 1)
    val paramTypeArgs = (paramType as ParameterizedType).actualTypeArguments
    val Param param = component.right.param.get(paramCounter)
    val paramSupplierTypeRef = typeRef(Supplier, typeRef(paramTypeArgs.get(0).typeName))

    param.toClass("$Generated_SupplierSubModel" + modelCounter + "Param" + paramCounter) [
      it.superTypes += paramSupplierTypeRef
      it.static = true
      for (dep : component.deps) {
        it.members += param.toField(dep.name, dep.type ?: getVarType(param, dep.name)) [
          final = true
        ]
      }
      it.members += param.toConstructor [
        visibility = JvmVisibility.PUBLIC
        for (dep : component.deps) {
          parameters += param.toParameter(dep.name, dep.type ?: getVarType(param, dep.name))
        }
        body = '''
          «FOR dep : component.deps»
            this.«dep.name» = «dep.name»;
          «ENDFOR»
        '''
      ]

      it.members += param.toMethod("get", typeRef(paramTypeArgs.get(0).typeName)) [
        annotations += annotationRef("java.lang.Override")
        switch (param) {
          ConstParam:
            body = '''return «param.id»;'''
          LazyParam:
            body = param.expr
        }
      ]
    ]
  }

  def generateSupportFactor(BlangModel model, SupportFactor factor, int modelCounter) {
    factor.toClass("$Generated_SetupSupport" + modelCounter) [
      it.superTypes += typeRef(blang.core.SupportFactor.Support)
      it.static = true
      for (p : factor.params) {
        it.members += factor.toField(p, getVarType(factor, p)) [
          final = true
        ]
      }

      it.members += factor.toConstructor [
        it.visibility = JvmVisibility.PUBLIC
        for (p : factor.params) {
          parameters += factor.toParameter(p, getVarType(factor, p))
        }
        body = '''
          «FOR p : factor.params»
            this.«p» = «p»;
          «ENDFOR»
        '''
      ]

      it.members += factor.expr.toMethod("isInSupport", typeRef(boolean)) [
        annotations += annotationRef("java.lang.Override")
        body = '''
          return $isInSupport(«FOR p : factor.params SEPARATOR ", "»«p»«
                      IF isLazy(getVarType(factor, p)) ».get()« ENDIF»«ENDFOR»);
        '''
      ]
      it.members += factor.expr.toMethod("$isInSupport", typeRef(boolean)) [
        visibility = JvmVisibility.PRIVATE
        for (p : factor.params) {
          var varType = getVarType(factor, p)
          if (isLazy(varType)) varType = (varType as JvmParameterizedTypeReference).getArguments().get(0)
          parameters += factor.toParameter(p, varType)
        }
        body = factor.expr
      ]
    ]
  }

  def generateLogScaleFactor(BlangModel model, LogScaleFactor factor, int modelCounter) {
    factor.toClass("$Generated_LogScaleFactor" + modelCounter) [
      it.superTypes += typeRef(blang.factors.LogScaleFactor)
      it.static = true

      for (p : factor.params) {
        it.members += factor.toField(p, getVarType(factor, p)) [
          final = true
        ]
      }

      it.members += factor.toConstructor [
        it.visibility = JvmVisibility.PUBLIC
        for (p : factor.params) {
          parameters += factor.toParameter(p, getVarType(factor, p))
        }
        body = '''
          «FOR p : factor.params»
            this.«p» = «p»;
          «ENDFOR»
        '''
      ]

      it.members += factor.expr.toMethod("logDensity", typeRef(double)) [
        annotations += annotationRef("java.lang.Override")
        body = '''
          return $logDensity(«FOR p : factor.params SEPARATOR ", "»«p»«
                      IF isLazy(getVarType(factor, p)) ».get()« ENDIF»«ENDFOR»);
        '''
      ]
      it.members += factor.expr.toMethod("$logDensity", typeRef(double)) [
        visibility = JvmVisibility.PRIVATE
        for (p : factor.params) {
          parameters += factor.toParameter(p, model.vars.findFirst[name == p].type)
        }
        body = factor.expr
      ]
    ]
  }

  def JvmTypeReference getVarType(EObject container, String name) {
    switch (container) {
      ForLoop:
        if (name.equals(container.initExpression?.name)) {
          val JvmTypeReference type = container.initExpression.type
          return if (expressionText(type) == "int") typeRef("int") else type
        } else {
          return getVarType(container.eContainer, name)
        }
      BlangModel:
        for (v : container.vars) {
          if (v.name.equals(name)) return getVarType(v)
        }
      default:
        return getVarType(container.eContainer, name)
    }
    throw new RuntimeException("No such variable: " + name)

  }

  def getVarType(ModelVar v) {
    switch (v.qualType) {
      case "random": v.type
      case "param": typeRef(Supplier, v.type)
    }
  }

  def isLazy(JvmTypeReference type) {
    type.identifier.startsWith("java.util.function.Supplier")
  }

}
