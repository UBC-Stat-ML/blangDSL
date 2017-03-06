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
class ModelVarsGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension TestSupport
    
    @Test
    def void emptyVars() {
        '''
            model {
            }
        '''.check
    }

    
    @Test
    def void randomVars() {
        '''
            import blang.core.RealVar
            
            model {
                random RealVar mu
                random RealVar y
            }
        '''.check
    }

    
    @Test
    def void paramVars() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar mu
                param RealVar variance
            }
        '''.check
    }

    
    @Test
    def void mixedVars() {
        '''
            import blang.core.RealVar
            
            model {
                param RealVar mu
                param RealVar variance
                random RealVar y
            }
        '''.check
    }
    
    @Test
    def void consts() {
        '''
            import static java.lang.Math.*
            
            model {
                // TODO: const double LOG2PI = log(2 * PI)
            }
        '''.check
    }
    
}