/*
 * generated by Xtext 2.10.0
 */
package ca.ubc.stat.blang.web

import ca.ubc.stat.blang.BlangDslRuntimeModule
import ca.ubc.stat.blang.BlangDslStandaloneSetup
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.util.Modules
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
class BlangDslWebSetup extends BlangDslStandaloneSetup {
	
	val Provider<ExecutorService> executorServiceProvider;
	
	override Injector createInjector() {
		val runtimeModule = new BlangDslRuntimeModule()
		val webModule = new BlangDslWebModule(executorServiceProvider)
		return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
	}
	
}
