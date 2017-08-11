package ca.ubc.stat.blang.tests.generate

import ca.ubc.stat.blang.tests.BlangDslInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import ca.ubc.stat.blang.tests.TestSupport

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class AutoBoxDeboxTest {
  
    @Inject
    extension TestSupport support
    
    @Test
    def void boxDebox() {
        '''
            import java.util.function.Function
            model {                
                laws {
                    logf() { 
                      val Function<Double,Double> d2d = null
                      val Function<Integer,Integer> i2i = null
                      val RealVar rv = null
                      val IntVar iv = null
                      val List<Object> list = null
                      
                      d2d.apply(rv) // test 1: realvar -> Double
                      d2d.apply(iv) // test 2: intvar -> Double
                      i2i.apply(iv) // test 3: intvar -> Integer
                      
                      Math.log(rv)  // test 4: realvar -> double
                      Math.log(iv)  // test 5: intvar  -> double
                      
                      list.get(iv)  // test 6: intvar  -> int
                      
                      val RealVar v0 = 0.0 // test 7: double -> realvar
                      
                      val RealVar v1 = new Double(0.0) // test 8: Double -> realvar
                      
                      val IntVar v2 = 0 // test 9: int -> intvar
                      val RealVar v3 = 0 // test 10: Integer -> realvar
                      
                      val IntVar v4 = new Integer(0) // test 11: Integer -> intvar
                      val RealVar v4 = new Integer(0) // test 12: Integer -> realvar
                      
                      return Double.NaN 
                    }
                }
            }
        '''.check
    }
    
}