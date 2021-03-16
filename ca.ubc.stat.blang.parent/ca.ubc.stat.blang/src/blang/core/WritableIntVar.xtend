package blang.core

import blang.core.IntVar

 
interface WritableIntVar extends IntVar {
  def void set(int value)
}