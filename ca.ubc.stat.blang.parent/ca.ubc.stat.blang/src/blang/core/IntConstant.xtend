package blang.core

class IntConstant implements IntVar {
  
  val int value
  
  new(int value) { this.value = value }
  
  override int intValue() {
    return value
  }
  
  override String toString() {
    return Integer.toString(value)
  }
}