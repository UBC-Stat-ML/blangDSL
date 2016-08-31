package ca.ubc.stat.blang.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes
import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class BlangDslScopeProvider extends AbstractBlangDslScopeProvider {

//  override getScope(EObject context, EReference reference) {
//    
//    // We want to define the Scope for the Element's superElement cross-reference
//    if (context instanceof InstantiatedDistribution) {
//        println("called getScope on a BlangModel")
//        // Collect a list of candidates by going through the model
//        // EcoreUtil2 provides useful functionality to do that
//        // For example searching for all elements within the root Object's tree
//        val rootElement = EcoreUtil2.getRootContainer(context)
//        val candidates = EcoreUtil2.getAllContentsOfType(rootElement, BlangModel)
//        // Create IEObjectDescriptions and puts them into an IScope instance
//        return Scopes.scopeFor(candidates)
//    } else {
//      println("called getScope on something else: " + context)
//    }
//    
//    return super.getScope(context, reference);
//  }
  
}
