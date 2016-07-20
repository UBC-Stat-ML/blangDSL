package ca.ubc.stat.blang

import ca.ubc.stat.blang.scoping.ImplicitImportsScopeProvider
import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class BlangDslRuntimeModule extends AbstractBlangDslRuntimeModule {

	override configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(ImplicitImportsScopeProvider);
	}
}
