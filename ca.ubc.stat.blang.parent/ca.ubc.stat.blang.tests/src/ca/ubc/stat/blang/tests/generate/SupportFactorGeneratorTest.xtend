package ca.ubc.stat.blang.tests.generate

import ca.ubc.stat.blang.tests.BlangDslInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import ca.ubc.stat.blang.tests.TestSupport

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class SupportFactorGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension TestSupport
    
    @Test
    def void supportFactor() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar variance
                
                laws {
                    indicator(variance) variance.doubleValue > 0
                }
            }
        '''.check
    }
    
    
    @Test
    def void supportFactorRandom() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    indicator(rand) rand.nextBoolean()
                }
            }
        '''.check
    }
    
    
    @Test
    def void supportFactorMultiParam() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar mean

                param RealVar variance
                
                laws {
                    indicator(mean, variance) { mean.doubleValue > 0.5 && variance.doubleValue > 0 }
                }
            }
        '''.check
    }
}