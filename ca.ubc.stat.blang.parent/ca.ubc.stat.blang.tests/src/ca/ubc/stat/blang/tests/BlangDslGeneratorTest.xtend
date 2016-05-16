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
		import blang.prototype.Real;
		
		@SuppressWarnings("all")
		public class MyFile implements Model {
		  public final Real mu;
		  
		  public final Real y;
		  
		  public MyFile(final Real mu, final Real y) {
		    this.mu = mu
		    this.y = y
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
        import blang.prototype2.Real;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Real mu;
          
          public final Real y;
          
          public MyFile(final Real mu, final Real y) {
            this.mu = mu
            this.y = y
          }
          
          public Collection<ModelComponent> components() {
            java.util.ArrayList<ModelComponent> components = new java.util.ArrayList();
            
            components.add(new Normal(y,
                                      $generated_setupSubModel0Param0(mu),
                                      $generated_setupSubModel0Param1(mu))
            );
            
            return components;
          }
          
          private static java.util.function.Supplier<Real> $generated_setupSubModel0Param0(final Real mean) {
            new java.util.function.Supplier<Real>() {
                @Override
                public Real get() {
                    return mean;
                }
            };
          }
          
          private static java.util.function.Supplier<Real> $generated_setupSubModel0Param1(final Real mean) {
            new java.util.function.Supplier<Real>() {
                @Override
                public Real get() {
                    return () -> Math.pow(mean.doubleValue(), 2);
                }
            };
          }
        }
        ''' 
        )
    }
}
