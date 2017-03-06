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
class LoopGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension TestSupport
        
    
    @Test
    def void forLoop() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    for (int i : 0..<3) {
                        indicator(rand) { rand.nextInt(4) > /* i */ 2 }
                    }
                }
            }
        '''.check
    }
    
    @Test
    def void nestedForLoops() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    for (int i : 0..<3) {
                        for (int j : 0..<3) {
                            indicator(rand) { rand.nextInt(4) > /* i + j */ 1 + 2 }
                        }
                    }
                }
            }
        '''.check
    }
    
    @Test
    def void instantiatedDistribution() {
        '''
            import blang.core.RealVar
            import ca.ubc.stat.blang.tests.types.Normal
            import java.util.List
            
            model {
                param RealVar m
                param RealVar v
                random List<RealVar> means

                
                laws {
                    for (int i : 0..<2) {
                        means.get(i) | m, v ~ new Normal(m, v)
                    }
                }
            }
        '''.check
    }
    
}
