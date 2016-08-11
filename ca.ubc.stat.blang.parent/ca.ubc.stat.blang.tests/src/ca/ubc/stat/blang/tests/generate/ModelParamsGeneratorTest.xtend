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
class ModelParamsGeneratorTest {
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
        import blang.core.ModelComponent;
        import java.util.ArrayList;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with with BlangVariable annotation
           *   - params have @Param also
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile() {
            
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            
            return components;
          }
        }
        '''
        )
    }
    

    
    @Test
    def void randomParams() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                random Real mu
                random Real y
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelComponent;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          private final Real mu;
          
          private final Real y;
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with with BlangVariable annotation
           *   - params have @Param also
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile(@DeboxedName("mu") final Real mu, @DeboxedName("y") final Real y) {
            this.mu = mu;
            this.y = y;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            
            return components;
          }
        }
        '''    
        )
    }
    
    
    @Test
    def void simpleNormalModel() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
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
            
            components.add(new blang.prototype3.Normal(
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
