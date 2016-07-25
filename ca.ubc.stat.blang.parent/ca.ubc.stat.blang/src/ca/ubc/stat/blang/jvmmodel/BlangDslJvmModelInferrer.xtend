package ca.ubc.stat.blang.jvmmodel

import blang.core.Model
import ca.ubc.stat.blang.blangDsl.BlangModel
import ca.ubc.stat.blang.blangDsl.Param
import com.google.inject.Inject
import java.lang.reflect.ParameterizedType
import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.function.Supplier
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import ca.ubc.stat.blang.blangDsl.ConstParam
import ca.ubc.stat.blang.blangDsl.ForLoop
import ca.ubc.stat.blang.blangDsl.LazyParam
import ca.ubc.stat.blang.blangDsl.LogScaleFactor
import ca.ubc.stat.blang.blangDsl.ModelComponent
import ca.ubc.stat.blang.blangDsl.ModelParam
import ca.ubc.stat.blang.blangDsl.SupportFactor
import ca.ubc.stat.blang.blangDsl.ModelVar
import ca.ubc.stat.blang.blangDsl.impl.DependencyImpl

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
     *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
     *            initializeLater(..)}.
     * @param isPreIndexingPhase
     *            whether the method is called in a pre-indexing phase, i.e.
     *            when the global index is not yet fully updated. You must not
     *            rely on linking using the index if isPreIndexingPhase is
     *            <code>true</code>.
     */
    def dispatch void infer(BlangModel model, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
        val className = model.eResource.URI.trimFileExtension.lastSegment
        acceptor.accept(model.toClass(className)) [
          new SingleBlangModelInferrer(model, it, _typeBuilder, _annotationTypesBuilder, _typeReferenceBuilder).infer()
        ]
    }
}
