package blang.core

class ConstrainedFactor implements Factor {
  public val Object object
  
  new(@DeboxedName("object") Object object) {
    this.object = object
  }
}