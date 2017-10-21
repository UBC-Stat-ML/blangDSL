package ca.ubc.stat.blang.jvmmodel

import ca.ubc.stat.blang.StaticUtils
import ca.ubc.stat.blang.blangDsl.Dependency
import ca.ubc.stat.blang.blangDsl.InitializerDependency
import ca.ubc.stat.blang.blangDsl.SimpleDependency
import com.google.common.collect.Iterables
import java.util.LinkedHashMap
import java.util.List
import java.util.function.Supplier
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder

@Data
class BlangScope {
  
  val BlangScope parent
  
  /*
   * variables on 'top' of this hierarchy, i.e. not 
   * including those in the parent
   */ 
  val LinkedHashMap<String,BlangVariable> topVariables
  
  /**
   * Create an empty scope.
   */
  def static emptyScope() {
    return new BlangScope(null, new LinkedHashMap)
  }
  
  def +=(BlangVariable newVariable) {
    this.topVariables.put(newVariable.deboxedName, newVariable)
  }
  
  /**
   * Return a new scope containing this (via a pointer) + a single additional 
   * variable.
   */
  def BlangScope child(BlangVariable variable) {
    val BlangScope result = new BlangScope(this, new LinkedHashMap)
    result += variable
    return result
  }
  
  /**
   * Return the variable with the given deboxed name or null otherwise.
   */
  def BlangVariable find(String deboxedName) {
    val BlangVariable result = topVariables.get(deboxedName)
    if (result !== null)
      return result
    if (parent !== null)
      return parent.find(deboxedName)
    else
      return null // not found
  }
  
  /**
   * Returns the variables in this scope
   */
  def Iterable<BlangVariable> variables() {
    if (parent === null) {
      return topVariables.values
    } else {
      return Iterables.concat(topVariables.values, parent.variables())
    }
  }
  
  /**
   * These can be either param (boxed) or random (no boxing)
   * 
   * When there is no boxing, deboxed and boxed version are equal, 
   * otherwise they differ.
   */
  static class BlangVariable {
    val public JvmTypeReference deboxedType 
    val public String deboxedName
    
    // if true, this means that the variable is not actually of type above,
    // but rather of type Supplier<type> unknowingly by the DSL user
    // the variable is also actually called name_supplier in this case.
    // therefore if true it needs to be deboxed just before
    val private boolean isBoxed
    
    def boolean isParam() {
      return isBoxed
    }
    
    def String deboxingInvocationString() {
      if (isBoxed) {
        return '''«boxedName()».get()'''
      } else {
        return deboxedName
      }
    }
    
    new (JvmTypeReference deboxedType, String deboxedName, boolean isBoxed) {
      this.deboxedType = deboxedType
      this.deboxedName = deboxedName
      this.isBoxed = isBoxed
    }
  
    def String boxedName() {
      if (isBoxed) {
        return StaticUtils::generatedName(deboxedName)
      } else {
        return deboxedName
      }
    }
  
    def JvmTypeReference boxedType(extension JvmTypeReferenceBuilder _typeReferenceBuilder) {
      if (isBoxed) {
        return typeRef(Supplier, deboxedType)
      } else {
        return deboxedType
      }
    }
  
  }
  
  def BlangScope restrict(List<Dependency> dependencies) {
    val BlangScope result = emptyScope
    for (Dependency dependency : dependencies) {
      switch dependency {
        SimpleDependency : {
          val BlangVariable additional = this.find(dependency.variable.name)
          if (additional !== null)
            result += additional
          // else
          //   TODO: error message: dependency not found 
          //   *However*: now detected by the fact SimpleDependency uses a link to a variable
        }
        InitializerDependency :
          result += new BlangVariable(dependency.type, dependency.name, false)
        default :
          throw new RuntimeException
      }
    }
    return result
  }
  
}