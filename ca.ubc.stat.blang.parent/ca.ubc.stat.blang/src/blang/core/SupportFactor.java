package blang.core;

/**
 * 
 * It is useful to differentiate support factor from standard factor for at least two reasons:
 *  - construct annealed versions of the log density, and, 
 *  - in some cases, speed up likelihood evaluation, by evaluating support constraints first 
 *    as negative infinity is an absorbing state.
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
public final class SupportFactor implements Annealed, LogScaleFactor
{
  private final Support support;
  private double exponent = 1.0;
  
  public SupportFactor(Support support)
  {
    this.support = support;
  }
  
  public boolean isInSupport()
  {
    return support.isInSupport();
  }

  @Override
  public double logDensity()
  {
    return isInSupport() ? 0.0 : (0.5 + 0.5 * exponent) * Double.NEGATIVE_INFINITY;
  }
  
  @FunctionalInterface
  public static interface Support
  {
    public boolean isInSupport();
  }

  @Override
  public void setExponent(double value)
  {
    Annealed.check(value);
    this.exponent = value;
  }

  @Override
  public double getExponent()
  {
    return exponent;
  }
}
