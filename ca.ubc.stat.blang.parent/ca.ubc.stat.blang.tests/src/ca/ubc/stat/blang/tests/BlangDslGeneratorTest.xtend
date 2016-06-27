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
    def void supportFactorMultiParam() {
        '''
            model {
                param Real mean

                param Real variance
                
                laws {
                    indicator(mean, variance) = { mean.doubleValue > 0.5 && variance.doubleValue > 0 }
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
          public final Supplier<Real> mean;
          
          public final Supplier<Real> variance;
          
          public MyFile(final Supplier<Real> mean, final Supplier<Real> variance) {
            this.mean = mean;
            this.variance = variance;
          }
          
          public Collection<ModelComponent> components() {
            ArrayList<ModelComponent> components = new ArrayList();
            
            components.add(new SupportFactor(new $Generated_SetupSupport0(mean, variance)));
            
            return components;
          }
          
          public static class $Generated_SetupSupport0 implements SupportFactor.Support {
            private final Supplier<Real> mean;
            
            private final Supplier<Real> variance;
            
            public $Generated_SetupSupport0(final Supplier<Real> mean, final Supplier<Real> variance) {
              this.mean = mean;
              this.variance = variance;
            }
            
            @Override
            public boolean inSupport() {
              return $inSupport(mean.get(), variance.get());
            }
            
            private boolean $inSupport(final Real mean, final Real variance) {
              boolean _and = false;
              double _doubleValue = mean.doubleValue();
              boolean _greaterThan = (_doubleValue > 0.5);
              if (!_greaterThan) {
                _and = false;
              } else {
                double _doubleValue_1 = variance.doubleValue();
                boolean _greaterThan_1 = (_doubleValue_1 > 0);
                _and = _greaterThan_1;
              }
              return _and;
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
