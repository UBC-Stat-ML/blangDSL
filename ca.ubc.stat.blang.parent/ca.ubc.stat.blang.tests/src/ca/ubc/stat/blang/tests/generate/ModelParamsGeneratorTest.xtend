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
    def void randomParams() {
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
    def void normalModelWithNamedParamBlock() {
        '''
            import blang.core.RealVar
            import ca.ubc.stat.blang.tests.types.Normal
            
            model {
                param RealVar mu
                
                random RealVar y
                
                laws {
                    y | RealVar mean = mu ~ new ca.ubc.stat.blang.tests.types.Normal(mean, [mean.doubleValue ** 2])
                }
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
            public RealVar y;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              final RealVar __mu = mu;
              final RealVar __y = y;
              // Build the instance after boxing params
              return new MyFile(
                __y, 
                () -> __mu
              );
            }
          }
          
          @Param
          private final Supplier<RealVar> $generated__mu;
          
          public RealVar getMu() {
            return $generated__mu.get();
          }
          
          private final RealVar y;
          
          public RealVar getY() {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * mu
           */
          private static RealVar $generated__0(final RealVar mu, final RealVar y) {
            return mu;
          }
          
          /**
           * Auxiliary method generated to translate:
           * y
           */
          private static RealVar $generated__1(final RealVar mu, final RealVar y) {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * mean
           */
          private static RealVar $generated__2(final RealVar mean) {
            return mean;
          }
          
          /**
           * Auxiliary method generated to translate:
           * mean
           */
          private static Supplier<RealVar> $generated__2_lazy(final RealVar mean) {
            return () -> $generated__2(mean);
          }
          
          /**
           * Auxiliary method generated to translate:
           * [mean.doubleValue ** 2]
           */
          private static RealVar $generated__3(final RealVar mean) {
            final RealVar _function = new RealVar() {
              public double doubleValue() {
                double _doubleValue = mean.doubleValue();
                return Math.pow(_doubleValue, 2);
              }
            };
            return _function;
          }
          
          /**
           * Auxiliary method generated to translate:
           * [mean.doubleValue ** 2]
           */
          private static Supplier<RealVar> $generated__3_lazy(final RealVar mean) {
            return () -> $generated__3(mean);
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
          public MyFile(@DeboxedName("y") final RealVar y, @Param @DeboxedName("mu") final Supplier<RealVar> $generated__mu) {
            this.$generated__mu = $generated__mu;
            this.y = y;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            { // Code generated by: y | RealVar mean = mu ~ new ca.ubc.stat.blang.tests.types.Normal(mean, [mean.doubleValue ** 2])
              // Required initialization:
              RealVar mean = $generated__0($generated__mu.get(), y);
              // Construction and addition of the factor/model:
              components.add(
                new ca.ubc.stat.blang.tests.types.Normal(
                  $generated__1($generated__mu.get(), y), 
                  $generated__2_lazy(mean), 
                  $generated__3_lazy(mean)
                )
              );
            }
            
            return components;
          }
        }
        ''' 
        )
    }
}
