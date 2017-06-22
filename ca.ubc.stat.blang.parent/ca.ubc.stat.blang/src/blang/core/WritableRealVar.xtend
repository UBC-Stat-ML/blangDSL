package blang.core

import blang.core.RealVar


interface WritableRealVar extends RealVar {
  def void set(double value)
}
