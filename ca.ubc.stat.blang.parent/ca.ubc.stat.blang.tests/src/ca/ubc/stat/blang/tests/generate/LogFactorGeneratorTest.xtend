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
class LogFactorGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    
    @Inject
    extension TestSupport support  
    
    @Test
    def void logFactor() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar variance
                
                // TODO: const double LOG2PI = Math.log(2 * Math.PI)
                laws {
                    logf(variance) { -0.5 * ( Math.log(variance) + /* LOG2PI */ Math.log(2 * Math.PI) ) }
                }
            }
        '''.check
    }
    
    
    @Test
    def void logFactorMultiParam() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar mean
                
                param RealVar variance
                
                laws {
                    logf(variance, mean) { -0.5 * mean.doubleValue / variance.doubleValue }
                }
            }
        '''.check
    }
    
    
    @Test
    def void logScaleFactorMultiVar() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar mean

                param RealVar variance
                
                random RealVar x
                
                laws {
                    logf(x, mean, variance) {
                        -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue
                    }
                }
            }
        '''.check
    }
}
