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
					y | Real mean = mu ~ Normal(mean, [mean.doubleValue * 2])
				}
			}
		'''.parse
		model.assertNoErrors;
	}

    @Test
    def void supportFactor() {
        val model = '''
            model {
                param Real variance
                
                laws {
                    indicator(variance) = { variance.doubleValue > 0 }
                }
            }
        '''.parse
        model.assertNoErrors;
    }

    @Test
    def void supportFactorMultiParam() {
        val model = '''
            model {
                param Real mean

                param Real variance
                
                laws {
                    indicator(mean, variance) = { mean.doubleValue > 0.5 && variance.doubleValue > 0 }
                }
            }
        '''.parse
        model.assertNoErrors;
    }

    @Test
    def void logFactor() {
        val model = '''
            model {
                param Real mean
                
                param Real variance
                
                const double LOG2PI = Math.log(2 * Math.PI)
                
                laws {
                    logf(variance) = { -0.5 * ( Math.log(variance.doubleValue) + LOG2PI ) }
                }
            }
        '''.parse
        model.assertNoErrors;
    }

    @Test
    def void logFactorMultiParam() {
        val model = '''
            model {
                param Real mean
                
                param Real variance
                
                laws {
                    logf(variance, mean) = { -0.5 * mean.doubleValue / variance.doubleValue }
                }
            }
        '''.parse
        model.assertNoErrors;
    }
}
