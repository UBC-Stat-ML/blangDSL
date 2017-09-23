package blang.core;


@FunctionalInterface
public interface LogScaleFactor extends Factor
{
  /**
   * @return The log of the density for the current
   *  assignment of parameters and realization.
   */
  public double logDensity();
}
