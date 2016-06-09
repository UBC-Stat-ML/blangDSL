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
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
        }
        '''
        )
    }

    
    @Test
    def void randomVars() {
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
    def void paramVars() {
        '''
            model {
                param Real mu
                param Real variance
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.prototype3.Real;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Supplier<Real> mu;
          
          public final Supplier<Real> variance;
          
          public MyFile(final Supplier<Real> mu, final Supplier<Real> variance) {
            this.mu = mu;
            this.variance = variance;
          }
        }
        ''' 
        )
    }

    
    @Test
    def void mixedVars() {
        '''
            model {
                param Real mu
                param Real variance
                random Real y
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        import blang.prototype3.Real;
        import java.util.function.Supplier;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          public final Real y;
          
          public final Supplier<Real> mu;
          
          public final Supplier<Real> variance;
          
          public MyFile(final Real y, final Supplier<Real> mu, final Supplier<Real> variance) {
            this.y = y;
            this.mu = mu;
            this.variance = variance;
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
                const double LOG2PI = log(2 * PI)
            }
        '''.assertCompilesTo(
        '''
        import blang.core.Model;
        
        @SuppressWarnings("all")
        public class MyFile implements Model {
          final static double LOG2PI = Math.log((2 * Math.PI));
        }
        ''' 
        )
    }
    
}