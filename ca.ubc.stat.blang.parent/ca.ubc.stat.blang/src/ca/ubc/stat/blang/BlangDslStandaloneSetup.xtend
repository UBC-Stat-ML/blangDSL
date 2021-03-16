package ca.ubc.stat.blang


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class BlangDslStandaloneSetup extends BlangDslStandaloneSetupGenerated {

	def static void doSetup() {
		new BlangDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
