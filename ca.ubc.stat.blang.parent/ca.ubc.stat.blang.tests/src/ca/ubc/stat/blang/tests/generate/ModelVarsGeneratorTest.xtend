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
class ModelVarsGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension CompilationTestHelper
    
    @Test
    def void emptyVars() {
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
    def void randomVars() {
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
    def void paramVars() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                param Real mu
                param Real variance
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          @Param
          private final Supplier<Real> $generated__mu;
          
          @Param
          private final Supplier<Real> $generated__variance;
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with with BlangVariable annotation
           *   - params have @Param also
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile(@Param @DeboxedName("mu") final Supplier<Real> $generated__mu, @Param @DeboxedName("variance") final Supplier<Real> $generated__variance) {
            this.$generated__mu = $generated__mu;
            this.$generated__variance = $generated__variance;
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
    def void mixedVars() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                param Real mu
                param Real variance
                random Real y
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          @Param
          private final Supplier<Real> $generated__mu;
          
          @Param
          private final Supplier<Real> $generated__variance;
          
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
          public MyFile(@DeboxedName("y") final Real y, @Param @DeboxedName("mu") final Supplier<Real> $generated__mu, @Param @DeboxedName("variance") final Supplier<Real> $generated__variance) {
            this.$generated__mu = $generated__mu;
            this.$generated__variance = $generated__variance;
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
    def void consts() {
        '''
            import static java.lang.Math.*
            
            model {
                // TODO: const double LOG2PI = log(2 * PI)
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
    
}