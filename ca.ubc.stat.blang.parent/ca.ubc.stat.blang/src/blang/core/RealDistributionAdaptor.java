package blang.core;

import java.util.Random;

public class RealDistributionAdaptor implements RealDistribution
{
  private final Distribution<RealVar> enclosed;
  private final WritableRealVar realization;
  
  public RealDistributionAdaptor(Distribution<RealVar> enclosed)
  {
    this.enclosed = enclosed;
    this.realization = (WritableRealVar) enclosed.realization();
  }

  @Override
  public double sample(Random random)
  {
    enclosed.sample(random);
    return realization.doubleValue();
  }

  @Override
  public double logDensity(double point)
  {
    realization.set(point);
    return enclosed.logDensity();
  }
  
  public static class WritableRealVarImpl implements WritableRealVar
  {
    private double value = Double.NaN;
    @Override
    public double doubleValue()
    {
      return value;
    }

    @Override
    public void set(double value)
    {
      this.value = value;
    }
    
  }
}
