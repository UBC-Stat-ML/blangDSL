/*
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.tests

import ca.ubc.stat.blang.blangDsl.BlangModel
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.diagnostics.Diagnostic

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class BlangDslParsingTest {

	@Inject extension ParseHelper<BlangModel>;
	
	@Inject extension ValidationTestHelper;

	@Test 
	def void emptyModel() {
		val model = '''
			model {
				
			}
		'''.parse
		Assert.assertNotNull(model)
	}

	@Test
	def void emptyFile() {
		val model = '''
		x
		'''.parse;
		Assert.assertNotNull(model);
		assertError(model.eResource, EcorePackage.Literals.EOBJECT, Diagnostic.SYNTAX_DIAGNOSTIC);
	}

	@Test
	def void randomParams() {
		val model = '''
			model {
				random Real mu
				random Real y
				
				laws {
					y | Real mean = mu ~ Normal(mean, [mean * 2])
				}
			}
		'''.parse
		model.assertNoErrors;
	}
}
