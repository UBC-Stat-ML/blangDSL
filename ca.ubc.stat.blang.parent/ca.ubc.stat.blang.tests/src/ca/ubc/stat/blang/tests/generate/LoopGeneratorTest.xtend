package ca.ubc.stat.blang.tests.generate

import ca.ubc.stat.blang.tests.BlangDslInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class LoopGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension CompilationTestHelper
        
    
    @Test
    def void forLoop() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    for (int i = 0; i < 3; i++) {
                        indicator(rand) = { rand.nextInt(4) > i }
                    }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.SupportFactor;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Random;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Random rand;
          
          public MyFile(final Random rand) {
            this.rand = rand;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            for (int i = 0; i < 3; i++) {
              components.add(new blang.core.SupportFactor(new $Generated_SetupSupport0(rand, i)));
            }
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Random rand;
            private final int i;
            
            public $Generated_SetupSupport0(final Random rand, final int i) {
              this.rand = rand;
              this.i = i;
            }
            
            @Override
            public boolean inSupport() {
              return $inSupport(rand, i);
            }
            
            private boolean $inSupport(final Random rand, final int i) {
              return rand.nextInt(4) > i;
            }
          }
        }
        '''
        )
    }
    
    @Test
    def void nestedForLoops() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            indicator(rand) = { rand.nextInt(4) > i + j }
                        }
                    }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.SupportFactor;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Random;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Random rand;
          
          public MyFile(final Random rand) {
            this.rand = rand;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                components.add(new blang.core.SupportFactor(new $Generated_SetupSupport0(rand, i, j)));
              }
            }
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Random rand;
            private final int i;
            private final int j;
            
            public $Generated_SetupSupport0(final Random rand, final int i, final int j) {
              this.rand = rand;
              this.i = i;
              this.j = j;
            }
            
            @Override
            public boolean inSupport() {
              return $inSupport(rand, i, j);
            }
            
            private boolean $inSupport(final Random rand, final int i, final int j) {
              return rand.nextInt(4) > (i + j);
            }
          }
        }
        ''')
    }
}