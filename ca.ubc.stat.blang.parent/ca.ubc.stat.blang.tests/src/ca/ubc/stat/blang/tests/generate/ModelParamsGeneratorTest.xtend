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
class ModelParamsGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension TestSupport
    
    @Test
    def void emptyParams() {
        '''
            model {
            }
        '''.check
    }
    

    
    @Test
    def void randomParams() {
        '''
            import blang.core.RealVar
            
            model {
                random RealVar mu
                random RealVar y
            }
        '''.check
    }
    
    
    @Test
    def void normalModelWithNamedParamBlock() {
        '''
            import blang.core.RealVar
            import ca.ubc.stat.blang.tests.types.Normal
            
            model {
                param RealVar mu
                
                random RealVar y
                
                laws {
                    y | RealVar mean = mu ~ new Normal(mean, [mean.doubleValue ** 2])
                }
            }
        '''.check
    }
}
