package ca.ubc.stat.blang.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.TemporaryFolder

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class BlangDslGeneratorTest {
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper
	
	@Test
	def void emptyParams() {
		'''
			model {
			}
		'''.assertCompilesTo(
		'''
		import blang.core.Model;
		
		@SuppressWarnings("all")
		public class MyFile implements Model {
		}
		'''
		)
	}
	

	
	@Test
	def void randomParams() {
		'''
			model {
				random Real mu
				random Real y
			}
		'''.assertCompilesTo(
		'''
		import blang.core.Model;
		import blang.prototype3.Real;
		
		@SuppressWarnings("all")
		public class MyFile implements Model {
		  public final Real mu;
		  
		  public final Real y;
		  
		  public MyFile(final Real mu, final Real y) {
		    this.mu = mu;
		    this.y = y;
		  }
		}
		'''	
		)
	}
	
	
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
            
            components.add(new SupportFactor(new $Generated_SetupSupport0(variance)));
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Supplier<Real> variance;
            
            public $Generated_SetupSupport0(final Supplier<Real> variance) {
              this.variance = variance;
            }
            
            @Override
            public boolean inSupport() {
              return $inSupport(variance.get());
            }
            
            private boolean $inSupport(final Real variance) {
              double _doubleValue = variance.doubleValue();
              return (_doubleValue > 0);
            }
          }
        }
        '''
        )
	}
	
	
    @Test
    def void simpleNormalModel() {
        '''
            model {
                random Real mu
                random Real y
                
                laws {
                	y | Real mean = mu ~ Normal(mean, [mean.doubleValue ** 2])
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.prototype3.Real;
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
            
            components.add(new Normal(
                y,
                new $Generated_SupplierSubModel0Param0(mu),
                new $Generated_SupplierSubModel0Param1(mu))
            );
            
            return components;
          }
          
          public static class $Generated_SupplierSubModel0Param0 implements Supplier<Real> {
            private final Real mean;
            
            public $Generated_SupplierSubModel0Param0(final Real mean) {
              this.mean = mean;
            }
            
            @Override
            public Real get() {
              return mean;
            }
          }
          
          public static class $Generated_SupplierSubModel0Param1 implements Supplier<Real> {
            private final Real mean;
            
            public $Generated_SupplierSubModel0Param1(final Real mean) {
              this.mean = mean;
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
