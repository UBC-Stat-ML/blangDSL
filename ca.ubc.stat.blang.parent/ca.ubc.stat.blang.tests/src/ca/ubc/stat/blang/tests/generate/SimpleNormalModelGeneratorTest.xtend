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
            import blang.core.RealVar
            import ca.ubc.stat.blang.tests.types.Normal
            
            model {
                param RealVar m
                param RealVar v
                random RealVar y
                
                laws {
                	y | m, v ~ new Normal(m, v)
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
            public RealVar m;
            
            @Arg
            public RealVar v;
            
            @Arg
            public RealVar y;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              final RealVar __m = m;
              final RealVar __v = v;
              final RealVar __y = y;
              // Build the instance after boxing params
              return new MyFile(
                __y, 
                () -> __m, 
                () -> __v
              );
            }
          }
          
          @Param
          private final Supplier<RealVar> $generated__m;
          
          public RealVar getM() {
            return $generated__m.get();
          }
          
          @Param
          private final Supplier<RealVar> $generated__v;
          
          public RealVar getV() {
            return $generated__v.get();
          }
          
          private final RealVar y;
          
          public RealVar getY() {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * y
           */
          private static RealVar $generated__0(final RealVar m, final RealVar v, final RealVar y) {
            return y;
          }
          
          /**
           * Auxiliary method generated to translate:
           * m
           */
          private static RealVar $generated__1(final RealVar m, final RealVar v) {
            return m;
          }
          
          /**
           * Auxiliary method generated to translate:
           * m
           */
          private static Supplier<RealVar> $generated__1_lazy(final Supplier<RealVar> $generated__m, final Supplier<RealVar> $generated__v) {
            return () -> $generated__1($generated__m.get(), $generated__v.get());
          }
          
          /**
           * Auxiliary method generated to translate:
           * v
           */
          private static RealVar $generated__2(final RealVar m, final RealVar v) {
            return v;
          }
          
          /**
           * Auxiliary method generated to translate:
           * v
           */
          private static Supplier<RealVar> $generated__2_lazy(final Supplier<RealVar> $generated__m, final Supplier<RealVar> $generated__v) {
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
          public MyFile(@DeboxedName("y") final RealVar y, @Param @DeboxedName("m") final Supplier<RealVar> $generated__m, @Param @DeboxedName("v") final Supplier<RealVar> $generated__v) {
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
            
            { // Code generated by: y | m, v ~ new Normal(m, v)
              // Construction and addition of the factor/model:
              components.add(
                new ca.ubc.stat.blang.tests.types.Normal(
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
