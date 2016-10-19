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
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import java.util.ArrayList;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
              );
            }
          }
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with a BlangVariable annotation
           *   - params additionally have a Param annotation
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
            import blang.core.RealVar
            
            model {
                random RealVar mu
                random RealVar y
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.RealVar;
        import blang.inits.Arg;
        import java.util.ArrayList;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public RealVar mu;
            
            @Arg
            public RealVar y;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              final RealVar __mu = mu;
              final RealVar __y = y;
              // Build the instance after boxing params
              return new MyFile(
                __mu, 
                __y
              );
            }
          }
          
          private final RealVar mu;
          
          public RealVar getMu() {
            return mu;
          }
          
          private final RealVar y;
          
          public RealVar getY() {
            return y;
          }
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with a BlangVariable annotation
           *   - params additionally have a Param annotation
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile(@DeboxedName("mu") final RealVar mu, @DeboxedName("y") final RealVar y) {
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
            import blang.core.RealVar
            
            model {
                param RealVar mu
                param RealVar variance
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.core.RealVar;
        import blang.inits.Arg;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public RealVar mu;
            
            @Arg
            public RealVar variance;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              final RealVar __mu = mu;
              final RealVar __variance = variance;
              // Build the instance after boxing params
              return new MyFile(
                () -> __mu, 
                () -> __variance
              );
            }
          }
          
          @Param
          private final Supplier<RealVar> $generated__mu;
          
          public RealVar getMu() {
            return $generated__mu.get();
          }
          
          @Param
          private final Supplier<RealVar> $generated__variance;
          
          public RealVar getVariance() {
            return $generated__variance.get();
          }
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with a BlangVariable annotation
           *   - params additionally have a Param annotation
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile(@Param @DeboxedName("mu") final Supplier<RealVar> $generated__mu, @Param @DeboxedName("variance") final Supplier<RealVar> $generated__variance) {
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
            import blang.core.RealVar
            
            model {
                param RealVar mu
                param RealVar variance
                random RealVar y
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.core.RealVar;
        import blang.inits.Arg;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public RealVar mu;
            
            @Arg
            public RealVar variance;
            
            @Arg
            public RealVar y;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              final RealVar __mu = mu;
              final RealVar __variance = variance;
              final RealVar __y = y;
              // Build the instance after boxing params
              return new MyFile(
                __y, 
                () -> __mu, 
                () -> __variance
              );
            }
          }
          
          @Param
          private final Supplier<RealVar> $generated__mu;
          
          public RealVar getMu() {
            return $generated__mu.get();
          }
          
          @Param
          private final Supplier<RealVar> $generated__variance;
          
          public RealVar getVariance() {
            return $generated__variance.get();
          }
          
          private final RealVar y;
          
          public RealVar getY() {
            return y;
          }
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with a BlangVariable annotation
           *   - params additionally have a Param annotation
           *   - the order of the arguments is as follows:
           *     - first, all the random variables in the order they occur in the blang file
           *     - second, all the params in the order they occur in the blang file
           * 
           */
          public MyFile(@DeboxedName("y") final RealVar y, @Param @DeboxedName("mu") final Supplier<RealVar> $generated__mu, @Param @DeboxedName("variance") final Supplier<RealVar> $generated__variance) {
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
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import java.util.ArrayList;
        import java.util.Collection;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
              );
            }
          }
          
          /**
           * Note: the generated code has the following properties used at runtime:
           *   - all arguments are annotated with a BlangVariable annotation
           *   - params additionally have a Param annotation
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