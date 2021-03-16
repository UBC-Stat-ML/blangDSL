package blang.core

class RealConstant implements RealVar { 
  
  val double value
  
  new (double value) { this.value = value }
  
  override double doubleValue() {
    return value
  }
  
  override String toString() {
    return Double.toString(value)
  }
}