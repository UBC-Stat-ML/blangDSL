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
class SimpleNormalModelGeneratorTest {
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper
	
    @Test
    def void simpleNormalModel() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            import ca.ubc.stat.blang.tests.types.Normal
            
            model {
                param Real m
                param Real v
                random Real y
                
                laws {
                	y | m, v ~ Normal(m, v)
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.inits.Arg;
        import ca.ubc.stat.blang.tests.types.Normal;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder {
            @Arg
            public Real m;
            
            @Arg
            public Real v;
            
            @Arg
            public Real y;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
                y, 
                () -> m, 
                () -> v
              );
            }
          }
          
          @Param
          private final Supplier<Real> $generated__m;
          
          public Real getM() {
            return $generated__m.get();
          }
          
          @Param
          private final Supplier<Real> $generated__v;
          
          public Real getV() {
            return $generated__v.get();
          }
          
          private final Real y;
          
          public Real getY() {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * y
           */
          private static Real $generated__0(final Real m, final Real v, final Real y) {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * m
           */
          private static Real $generated__1(final Real m, final Real v) {
            return m;
          }
          
          /**
           * Auxiliary method generated to translate:
           * m
           */
          private static Supplier<Real> $generated__1_lazy(final Supplier<Real> $generated__m, final Supplier<Real> $generated__v) {
            return () -> $generated__1($generated__m.get(), $generated__v.get());
          }
          
          /**
           * Auxiliary method generated to translate:
           * v
           */
          private static Real $generated__2(final Real m, final Real v) {
            return v;
          }
          
          /**
           * Auxiliary method generated to translate:
           * v
           */
          private static Supplier<Real> $generated__2_lazy(final Supplier<Real> $generated__m, final Supplier<Real> $generated__v) {
            return () -> $generated__2($generated__m.get(), $generated__v.get());
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
          public MyFile(@DeboxedName("y") final Real y, @Param @DeboxedName("m") final Supplier<Real> $generated__m, @Param @DeboxedName("v") final Supplier<Real> $generated__v) {
            this.$generated__m = $generated__m;
            this.$generated__v = $generated__v;
            this.y = y;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            { // Code generated by: y | m, v ~ Normal(m, v)
              // Construction and addition of the factor/model:
              components.add(
                new Normal(
                  $generated__0($generated__m.get(), $generated__v.get(), y), 
                  $generated__1_lazy($generated__m, $generated__v), 
                  $generated__2_lazy($generated__m, $generated__v)
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
