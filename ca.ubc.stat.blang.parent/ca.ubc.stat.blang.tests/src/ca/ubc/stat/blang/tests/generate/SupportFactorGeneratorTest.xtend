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
class SupportFactorGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension CompilationTestHelper
    
    @Test
    def void supportFactor() {
        '''
            model {
                param Real variance
                
                laws {
                    indicator(variance) = variance.doubleValue > 0
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.SupportFactor;
        import blang.prototype3.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Supplier<Real> variance;
          
          public MyFile(final Supplier<Real> variance) {
            this.variance = variance;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            components.add(new blang.core.SupportFactor(new $Generated_SetupSupport0(variance)));
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Supplier<Real> variance;
            
            public $Generated_SetupSupport0(final Supplier<Real> variance) {
              this.variance = variance;
            }
            
            @Override
            public boolean isInSupport() {
              return $isInSupport(variance.get());
            }
            
            private boolean $isInSupport(final Real variance) {
              double _doubleValue = variance.doubleValue();
              return (_doubleValue > 0);
            }
          }
        }
        '''
        )
    }
    
    
    @Test
    def void supportFactorRandom() {
        '''
            model {
                random java.util.Random rand
                
                laws {
                    indicator(rand) = rand.nextBoolean()
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
            
            components.add(new blang.core.SupportFactor(new $Generated_SetupSupport0(rand)));
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Random rand;
            
            public $Generated_SetupSupport0(final Random rand) {
              this.rand = rand;
            }
            
            @Override
            public boolean isInSupport() {
              return $isInSupport(rand);
            }
            
            private boolean $isInSupport(final Random rand) {
              return rand.nextBoolean();
            }
          }
        }
        '''
        )
    }
    
    
    @Test
    def void supportFactorMultiParam() {
        '''
            model {
                param Real mean

                param Real variance
                
                laws {
                    indicator(mean, variance) = { mean.doubleValue > 0.5 && variance.doubleValue > 0 }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.SupportFactor;
        import blang.prototype3.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Supplier<Real> mean;
          
          public final Supplier<Real> variance;
          
          public MyFile(final Supplier<Real> mean, final Supplier<Real> variance) {
            this.mean = mean;
            this.variance = variance;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            components.add(new blang.core.SupportFactor(new $Generated_SetupSupport0(mean, variance)));
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Supplier<Real> mean;
            
            private final Supplier<Real> variance;
            
            public $Generated_SetupSupport0(final Supplier<Real> mean, final Supplier<Real> variance) {
              this.mean = mean;
              this.variance = variance;
            }
            
            @Override
            public boolean isInSupport() {
              return $isInSupport(mean.get(), variance.get());
            }
            
            private boolean $isInSupport(final Real mean, final Real variance) {
              return ((mean.doubleValue() > 0.5) && (variance.doubleValue() > 0));
            }
          }
        }
        '''
        )
    }
}