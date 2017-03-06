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
class SimpleNormalModelGeneratorTest {
	@Inject public TemporaryFolder temporaryFolder
  @Inject extension TestSupport
	
    @Test
    def void simpleNormalModel() {
        '''
            import blang.core.RealVar
            import ca.ubc.stat.blang.tests.types.Normal
            
            model {
                param RealVar m
                param RealVar v
                random RealVar y
                
                laws {
                	y | m, v ~ new Normal(m, v)
                }
            }
        '''.check
    }
}
