package ca.ubc.stat.blang.jvmmodel

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeReference

@Data
class BlangScope {
  
  
  // Type in which auxiliary methods will be generated for each XExpression
  val JvmDeclaredType referenceType
  val BlangScope parent
  
  /**
   * Return a new scope containing this (via a pointer) + a single additional 
   * variable.
   */
  def BlangScope child(BlangVariable variable) {
    throw new RuntimeException
  }
  
  /**
   * Returns the variables in this scope
   */
  def Iterable<BlangVariable> variables() {
    throw new RuntimeException
  }

//  /**
//   * Create a new scope based on the provided list of dependencies.
//   * Note: this is not a static method since the type information in this may 
//   * be used to get shorter syntax for dependency definition.
//   */
//  def BlangScope fromDependencies(EList<Dependency> list) {
//    throw new UnsupportedOperationException("TODO: auto-generated method stub")
//  }
  
    /**
   * These can be either param or random
   * // Ignore constant for now as they can just be in separate Java/Xtend files
   */
  @Data
  static class BlangVariable {
    val private JvmTypeReference type 
    val private String name
    
    // if true, this means that the variable is not actually of type above,
    // but rather of type Supplier<type> unknowingly by the DSL user
    // the variable is also actually called name_supplier in this case.
    // therefore if true it needs to be deboxed just before
    val private boolean enclosedBySupplier
    // TODO: information on param vs random
  }
  

  
}