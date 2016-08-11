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
            public boolean isInSupport() {
              return $isInSupport(rand, i);
            }
            
            private boolean $isInSupport(final Random rand, final int i) {
              int _nextInt = rand.nextInt(4);
              return (_nextInt > i);
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
            public boolean isInSupport() {
              return $isInSupport(rand, i, j);
            }
            
            private boolean $isInSupport(final Random rand, final int i, final int j) {
              int _nextInt = rand.nextInt(4);
              return (_nextInt > (i + j));
            }
          }
        }
        ''')
    }
    
    @Test
    def void simpleNormalModel() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                random Real mu
                random Real y
                
                laws {
                    for (int i = 0; i < 4; i++) {
                        y | Real mean = mu ~ Normal(mean, [mean.doubleValue ** 2])
                    }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Real mu;
          
          public final Real y;
          
          public MyFile(final Real mu, final Real y) {
            this.mu = mu;
            this.y = y;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            for (int i = 0; i < 4; i++) {
              components.add(new blang.prototype3.Normal(
                  y,
                  new $Generated_SupplierSubModel0Param0(mu, i),
                  new $Generated_SupplierSubModel0Param1(mu, i))
              );
            }
            
            return components;
          }
          
          public static class $Generated_SupplierSubModel0Param0 implements Supplier<Real> {
            private final Real mean;
            
            private final int i;
            
            public $Generated_SupplierSubModel0Param0(final Real mean, final int i) {
              this.mean = mean;
              this.i = i;
            }
            
            @Override
            public Real get() {
              return mean;
            }
          }
          
          public static class $Generated_SupplierSubModel0Param1 implements Supplier<Real> {
            private final Real mean;
            
            private final int i;
            
            public $Generated_SupplierSubModel0Param1(final Real mean, final int i) {
              this.mean = mean;
              this.i = i;
            }
            
            @Override
            public Real get() {
              final Real _function = new Real() {
                public double doubleValue() {
                  double _doubleValue = $Generated_SupplierSubModel0Param1.this.mean.doubleValue();
                  return Math.pow(_doubleValue, 2);
                }
              };
              return _function;
            }
          }
        }
        ''' 
        )
    }
    
}