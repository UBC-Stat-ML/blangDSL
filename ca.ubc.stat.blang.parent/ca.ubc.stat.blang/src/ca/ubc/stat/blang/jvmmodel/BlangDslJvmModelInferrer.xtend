package ca.ubc.stat.blang.jvmmodel

import ca.ubc.stat.blang.blangDsl.BlangModel
import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter

/**
 * <p>Infers a JVM model from the source model.</p> 
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class BlangDslJvmModelInferrer extends AbstractModelInferrer {

  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject extension JvmTypesBuilder _typeBuilder
  
  @Inject extension IResourceDescriptionsProvider _irdProvider
  
  @Inject IQualifiedNameConverter qualNameConverter
  
  /**
   * The dispatch method {@code infer} is called for each instance of the
   * given element's type that is contained in a resource.
   * 
   * @param element
   *            the model to create one or more
   *            {@link JvmDeclaredType declared
   *            types} from.
   * @param acceptor
   *            each created
   *            {@link JvmDeclaredType type}
   *            without a container should be passed to the acceptor in order
   *            get attached to the current resource. The acceptor's
   *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
   *            accept(..)} method takes the constructed empty type for the
   *            pre-indexing phase. This one is further initialized in the
   *            indexing phase using the closure you pass to the returned
   *            {@link IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
   *            initializeLater(..)}.
   * @param isPreIndexingPhase
   *            whether the method is called in a pre-indexing phase, i.e.
   *            when the global index is not yet fully updated. You must not
   *            rely on linking using the index if isPreIndexingPhase is
   *            <code>true</code>.
   */
  def dispatch void infer(BlangModel model, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
    acceptor.accept(model.toClass(model.name)) [
      val singleBlangModelInferrer = new SingleBlangModelInferrer(model, it, _typeBuilder, _annotationTypesBuilder, _typeReferenceBuilder, _irdProvider, qualNameConverter, isPreIndexingPhase)
      singleBlangModelInferrer.infer()
    ]
  }
}
