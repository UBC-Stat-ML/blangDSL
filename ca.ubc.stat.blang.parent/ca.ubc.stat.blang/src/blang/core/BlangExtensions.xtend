package blang.core

class BlangExtensions {
  
    def static double +(RealVar v1, RealVar v2) {
    return v1.doubleValue + v2.doubleValue
  }
  
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
  
}