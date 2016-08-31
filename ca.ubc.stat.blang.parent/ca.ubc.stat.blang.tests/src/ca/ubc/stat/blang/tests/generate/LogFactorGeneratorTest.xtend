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
class LogFactorGeneratorTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension CompilationTestHelper        
    
    @Test
    def void logFactor() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                param Real variance
                
                // TODO: const double LOG2PI = Math.log(2 * Math.PI)
                laws {
                    logf(variance) { -0.5 * ( Math.log(variance.doubleValue) + /* LOG2PI */ Math.log(2 * Math.PI) ) }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.LogScaleFactor;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.inits.Arg;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public Real variance;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
                () -> variance
              );
            }
          }
          
          @Param
          private final Supplier<Real> $generated__variance;
          
          public Real getVariance() {
            return $generated__variance.get();
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * ( Math.log(variance.doubleValue) + Math.log(2 * Math.PI) ) }
           */
          private static Double $generated__0(final Real variance) {
            double _doubleValue = variance.doubleValue();
            double _log = Math.log(_doubleValue);
            double _log_1 = Math.log((2 * Math.PI));
            double _plus = (_log + _log_1);
            return Double.valueOf(((-0.5) * _plus));
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * ( Math.log(variance.doubleValue) + Math.log(2 * Math.PI) ) }
           */
          private static LogScaleFactor $generated__0_lazy(final Supplier<Real> $generated__variance) {
            return () -> $generated__0($generated__variance.get());
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
          public MyFile(@Param @DeboxedName("variance") final Supplier<Real> $generated__variance) {
            this.$generated__variance = $generated__variance;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            { // Code generated by: (variance) { -0.5 * ( Math.log(variance.doubleValue) + Math.log(2 * Math.PI) ) }
              // Construction and addition of the factor/model:
              components.add(
                $generated__0_lazy($generated__variance)
              );
            }
            
            return components;
          }
        }
        '''
        )
    }
    
    
    @Test
    def void logFactorMultiParam() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                param Real mean
                
                param Real variance
                
                laws {
                    logf(variance, mean) { -0.5 * mean.doubleValue / variance.doubleValue }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.LogScaleFactor;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.inits.Arg;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public Real mean;
            
            @Arg
            public Real variance;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
                () -> mean, 
                () -> variance
              );
            }
          }
          
          @Param
          private final Supplier<Real> $generated__mean;
          
          public Real getMean() {
            return $generated__mean.get();
          }
          
          @Param
          private final Supplier<Real> $generated__variance;
          
          public Real getVariance() {
            return $generated__variance.get();
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * mean.doubleValue / variance.doubleValue }
           */
          private static Double $generated__0(final Real variance, final Real mean) {
            double _doubleValue = mean.doubleValue();
            double _multiply = ((-0.5) * _doubleValue);
            double _doubleValue_1 = variance.doubleValue();
            return Double.valueOf((_multiply / _doubleValue_1));
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * mean.doubleValue / variance.doubleValue }
           */
          private static LogScaleFactor $generated__0_lazy(final Supplier<Real> $generated__variance, final Supplier<Real> $generated__mean) {
            return () -> $generated__0($generated__variance.get(), $generated__mean.get());
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
          public MyFile(@Param @DeboxedName("mean") final Supplier<Real> $generated__mean, @Param @DeboxedName("variance") final Supplier<Real> $generated__variance) {
            this.$generated__mean = $generated__mean;
            this.$generated__variance = $generated__variance;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            { // Code generated by: (variance, mean) { -0.5 * mean.doubleValue / variance.doubleValue }
              // Construction and addition of the factor/model:
              components.add(
                $generated__0_lazy($generated__variance, $generated__mean)
              );
            }
            
            return components;
          }
        }
        '''
        )
    }
    
    
    @Test
    def void logScaleFactorMultiVar() {
        '''
            import ca.ubc.stat.blang.tests.types.Real
            
            model {
                param Real mean

                param Real variance
                
                random Real x
                
                laws {
                    logf(x, mean, variance) {
                        -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue
                    }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.DeboxedName;
        import blang.core.LogScaleFactor;
        import blang.core.Model;
        import blang.core.ModelBuilder;
        import blang.core.ModelComponent;
        import blang.core.Param;
        import blang.inits.Arg;
        import ca.ubc.stat.blang.tests.types.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public static class Builder implements ModelBuilder {
            @Arg
            public Real mean;
            
            @Arg
            public Real variance;
            
            @Arg
            public Real x;
            
            public MyFile build() {
              // For each optional type, either get the value, or evaluate the ?: expression
              // Build the instance after boxing params
              return new MyFile(
                x, 
                () -> mean, 
                () -> variance
              );
            }
          }
          
          @Param
          private final Supplier<Real> $generated__mean;
          
          public Real getMean() {
            return $generated__mean.get();
          }
          
          @Param
          private final Supplier<Real> $generated__variance;
          
          public Real getVariance() {
            return $generated__variance.get();
          }
          
          private final Real x;
          
          public Real getX() {
            return x;
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue }
           */
          private static Double $generated__0(final Real x, final Real mean, final Real variance) {
            double _doubleValue = x.doubleValue();
            double _doubleValue_1 = mean.doubleValue();
            double _minus = (_doubleValue - _doubleValue_1);
            double _multiply = ((-0.5) * _minus);
            double _power = Math.pow(_multiply, 2);
            double _doubleValue_2 = variance.doubleValue();
            return Double.valueOf((_power / _doubleValue_2));
          }
          
          /**
           * Auxiliary method generated to translate:
           * { -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue }
           */
          private static LogScaleFactor $generated__0_lazy(final Real x, final Supplier<Real> $generated__mean, final Supplier<Real> $generated__variance) {
            return () -> $generated__0(x, $generated__mean.get(), $generated__variance.get());
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
          public MyFile(@DeboxedName("x") final Real x, @Param @DeboxedName("mean") final Supplier<Real> $generated__mean, @Param @DeboxedName("variance") final Supplier<Real> $generated__variance) {
            this.$generated__mean = $generated__mean;
            this.$generated__variance = $generated__variance;
            this.x = x;
          }
          
          /**
           * A component can be either a distribution, support constraint, or another model  
           * which recursively defines additional components.
           */
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            { // Code generated by: (x, mean, variance) { -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue }
              // Construction and addition of the factor/model:
              components.add(
                $generated__0_lazy(x, $generated__mean, $generated__variance)
              );
            }
            
            return components;
          }
        }
        '''
        )
    }
}