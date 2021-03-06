package blang.core

/**
 * Various work-around for stuff not covered by the auto-boxing / de-boxing
 */
class BlangExtensions {
  
  //// Without these, the rule for + for String gets in the way 
  
  def static double +(RealVar v1, RealVar v2) {
    return v1.doubleValue + v2.doubleValue
  }
  
  def static int +(IntVar v1, IntVar v2) {
    return v1.intValue + v2.intValue
  }
  
  def static double +(RealVar v1, IntVar v2) {
    return v1.doubleValue + v2.intValue
  }
  
  def static double +(IntVar v1, RealVar v2) {
    return v1.intValue + v2.doubleValue
  }
  
  def static double +(RealVar v1, Number n) {
    return v1.doubleValue + n
  }
  
  def static int +(IntVar v1, Integer n) {
    return v1.intValue + n
  }
  
  def static int +(IntVar v1, int n) {
    return v1.intValue + n
  }
  
  //// These are not covered by the unbox/boxing either
  
  def static boolean ==(RealVar v1, RealVar v2) {
    return v1.doubleValue === v2.doubleValue
  }
  
  def static boolean ==(RealVar v1, Number v2) {
    return v1.doubleValue === v2.doubleValue
  }
  
  def static boolean ==(Number v1, RealVar v2) {
    return v1.doubleValue === v2.doubleValue
  }
  
  def static boolean ==(IntVar v1, IntVar v2) {
    return v1.intValue === v2.intValue
  }
  
  def static boolean ==(IntVar v1, Number v2) {
    return v1.intValue === v2.intValue
  }
  
  def static boolean ==(Number v1, IntVar v2) {
    return v1.intValue === v2.intValue
  }
  
  //
  
  def static boolean !=(RealVar v1, RealVar v2) {
    return v1.doubleValue !== v2.doubleValue
  }
  
  def static boolean !=(RealVar v1, Number v2) {
    return v1.doubleValue !== v2.doubleValue
  }
  
  def static boolean !=(Number v1, RealVar v2) {
    return v1.doubleValue !== v2.doubleValue
  }
  
  def static boolean !=(IntVar v1, IntVar v2) {
    return v1.intValue !== v2.intValue
  }
  
  def static boolean !=(IntVar v1, Number v2) {
    return v1.intValue !== v2.intValue
  }
  
  def static boolean !=(Number v1, IntVar v2) {
    return v1.intValue !== v2.intValue
  }
  

  
}