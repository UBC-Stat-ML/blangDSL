package ca.ubc.stat.blang

import ca.ubc.stat.blang.compiler.BlangXbaseCompiler
import ca.ubc.stat.blang.typesystem.BlangSynonymTypesProvider
import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import ca.ubc.stat.blang.scoping.ImplicitImportsScopeProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class BlangDslRuntimeModule extends AbstractBlangDslRuntimeModule {

	def Class<? extends SynonymTypesProvider> bindSynonymTypesProvider() {
    return typeof(BlangSynonymTypesProvider);
  }
    
  def Class<? extends XbaseCompiler> bindXbaseCompiler() {
    return typeof(BlangXbaseCompiler);
  }
  
  override configureIScopeProviderDelegate(Binder binder) {
    binder.bind(IScopeProvider).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(ImplicitImportsScopeProvider);
  }
  
}
