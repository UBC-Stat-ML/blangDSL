package ca.ubc.stat.blang.jvmmodel

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmTypeReference
import ca.ubc.stat.blang.blangDsl.VariableDeclaration
import ca.ubc.stat.blang.StaticUtils
import java.util.ArrayList
import com.google.common.collect.Iterables
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import java.util.function.Supplier

@Data
class BlangScope {
  
  val BlangScope parent
  val ArrayList<BlangVariable> topVariables
  
  /**
   * Create an empty scope.
   */
  def static emptyScope() {
    return new BlangScope(null, new ArrayList)
  }
  
  def +=(BlangVariable newVariable) {
    this.topVariables += newVariable
  }
  
  /**
   * Return a new scope containing this (via a pointer) + a single additional 
   * variable.
   */
  def BlangScope child(BlangVariable variable) {
    val BlangScope result = new BlangScope(this, new ArrayList)
    result += variable
    return result
  }
  
  /**
   * Returns the variables in this scope
   */
  def Iterable<BlangVariable> variables() {
    if (parent == null) {
      return topVariables
    } else {
      return Iterables.concat(topVariables, parent.variables())
    }
  }
  
  /**
   * These can be either param or random
   * // Ignore constant for now as they can just be in separate Java/Xtend files
   */
  static class BlangVariable {
    val private JvmTypeReference type 
    val private String name
    
    // if true, this means that the variable is not actually of type above,
    // but rather of type Supplier<type> unknowingly by the DSL user
    // the variable is also actually called name_supplier in this case.
    // therefore if true it needs to be deboxed just before
    val private boolean enclosedBySupplier
    
    def boolean isParam() {
      return enclosedBySupplier
    }
    
    new (VariableDeclaration variableDeclaration) {
      this.type = variableDeclaration.type
      this.name = variableDeclaration.name
      this.enclosedBySupplier = StaticUtils::isParam(variableDeclaration.variableType)
    }
  
    def String fieldName() {
      if (enclosedBySupplier) {
        return StaticUtils::generatedMethodName(name, "supplier")
      } else {
        return name
      }
    }
  
    def JvmTypeReference fieldType(extension JvmTypeReferenceBuilder _typeReferenceBuilder) {
      if (enclosedBySupplier) {
        return typeRef(Supplier, type)
      } else {
        return type
      }
    }
  
  }
}