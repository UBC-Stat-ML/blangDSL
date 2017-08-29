package blang.core;

public class AnnealedLogScaleFactor implements Annealed, LogScaleFactor
{
  
  private final LogScaleFactor enclosed;
  private double exponent = 1.0;
  
  public AnnealedLogScaleFactor(LogScaleFactor enclosed)
  {
    if (enclosed instanceof Annealed) 
      throw new RuntimeException("Trying to anneal a factor which is already annealed.");
    this.enclosed = enclosed;
  }

  @Override
  public void setExponent(double value)
  {
    Annealed.check(value);
    this.exponent = value;
  }

  public double getExponent()
  {
    return exponent;
  }

  @Override
  public double logDensity()
  {
    return exponent * enclosed.logDensity();
  }

}
