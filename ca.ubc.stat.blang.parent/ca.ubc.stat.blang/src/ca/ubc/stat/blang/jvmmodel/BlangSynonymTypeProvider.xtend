package ca.ubc.stat.blang.jvmmodel

import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

class BlangSynonymTypeProvider extends SynonymTypesProvider {
  
  override boolean collectCustomSynonymTypes(LightweightTypeReference typeRef, Acceptor acceptor) {
    println("called!")
    return true
  }
  
}