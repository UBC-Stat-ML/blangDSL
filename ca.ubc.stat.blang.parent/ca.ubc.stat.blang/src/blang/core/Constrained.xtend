package blang.core

class Constrained implements Factor {
  public val Object object
  
  new(@DeboxedName("object") Object object) {
    this.object = object
  }
}