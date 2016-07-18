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
            model {
                param Real variance
                
                const double LOG2PI = Math.log(2 * Math.PI)
                laws {
                    logf(variance) = -0.5 * ( Math.log(variance.doubleValue) + LOG2PI )
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.factors.LogScaleFactor;
        import blang.prototype3.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Supplier<Real> variance;
          
          final static double LOG2PI = Math.log((2 * Math.PI));
          
          public MyFile(final Supplier<Real> variance) {
            this.variance = variance;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            components.add(new $Generated_LogScaleFactor0(variance));
            
            return components;
          }
          
          public static class $Generated_LogScaleFactor0 implements LogScaleFactor {
            private final Supplier<Real> variance;
            
            public $Generated_LogScaleFactor0(final Supplier<Real> variance) {
              this.variance = variance;
            }
            
            @Override
            public double logDensity() {
              return $logDensity(variance.get());
            }
            
            private double $logDensity(final Real variance) {
              double _doubleValue = variance.doubleValue();
              double _log = Math.log(_doubleValue);
              double _plus = (_log + MyFile.LOG2PI);
              return ((-0.5) * _plus);
            }
          }
        }
        '''
        )
    }
    
    
    @Test
    def void logFactorMultiParam() {
        '''
            model {
                param Real mean
                
                param Real variance
                
                laws {
                    logf(variance, mean) = { -0.5 * mean.doubleValue / variance.doubleValue }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.factors.LogScaleFactor;
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
            
            components.add(new $Generated_LogScaleFactor0(variance, mean));
            
            return components;
          }
          
          public static class $Generated_LogScaleFactor0 implements LogScaleFactor {
            private final Supplier<Real> variance;
            
            private final Supplier<Real> mean;
            
            public $Generated_LogScaleFactor0(final Supplier<Real> variance, final Supplier<Real> mean) {
              this.variance = variance;
              this.mean = mean;
            }
            
            @Override
            public double logDensity() {
              return $logDensity(variance.get(), mean.get());
            }
            
            private double $logDensity(final Real variance, final Real mean) {
              double _doubleValue = mean.doubleValue();
              double _multiply = ((-0.5) * _doubleValue);
              double _doubleValue_1 = variance.doubleValue();
              return (_multiply / _doubleValue_1);
            }
          }
        }
        '''
        )
    }
    
    
    @Test
    def void logScaleFactorMultiVar() {
        '''
            model {
                param Real mean

                param Real variance
                
                random Real x
                
                laws {
                    logf(x, mean, variance) = {
                        -0.5 * (x.doubleValue - mean.doubleValue)**2 / variance.doubleValue
                    }
                }
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.core.ModelComponent;
        import blang.factors.LogScaleFactor;
        import blang.prototype3.Real;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Supplier<Real> mean;
          
          public final Supplier<Real> variance;
          
          public final Real x;
          
          public MyFile(final Real x, final Supplier<Real> mean, final Supplier<Real> variance) {
            this.mean = mean;
            this.variance = variance;
            this.x = x;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            components.add(new $Generated_LogScaleFactor0(x, mean, variance));
            
            return components;
          }
          
          public static class $Generated_LogScaleFactor0 implements LogScaleFactor {
            private final Real x;
            
            private final Supplier<Real> mean;
            
            private final Supplier<Real> variance;
            
            public $Generated_LogScaleFactor0(final Real x, final Supplier<Real> mean, final Supplier<Real> variance) {
              this.x = x;
              this.mean = mean;
              this.variance = variance;
            }
            
            @Override
            public double logDensity() {
              return $logDensity(x, mean.get(), variance.get());
            }
            
            private double $logDensity(final Real x, final Real mean, final Real variance) {
              double _doubleValue = x.doubleValue();
              double _doubleValue_1 = mean.doubleValue();
              double _minus = (_doubleValue - _doubleValue_1);
              double _multiply = ((-0.5) * _minus);
              double _power = Math.pow(_multiply, 2);
              double _doubleValue_2 = variance.doubleValue();
              return (_power / _doubleValue_2);
            }
          }
        }
        '''
        )
    }
}