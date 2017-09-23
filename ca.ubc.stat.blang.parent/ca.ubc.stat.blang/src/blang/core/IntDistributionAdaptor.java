package blang.core;

import java.util.Random;

public class IntDistributionAdaptor implements IntDistribution
{
  private final Distribution<IntVar> enclosed;
  private final WritableIntVar realization;
  
  public IntDistributionAdaptor(Distribution<IntVar> enclosed)
  {
    this.enclosed = enclosed;
    this.realization = (WritableIntVar) enclosed.realization();
  }

  @Override
  public int sample(Random random)
  {
    enclosed.sample(random);
    return realization.intValue();
  }

  @Override
  public double logDensity(int point)
  {
    realization.set(point);
    return enclosed.logDensity();
  }
  
  public static class WritableIntVarImpl implements WritableIntVar
  {
    private int value = 0;
    @Override
    public int intValue()
    {
      return value;
    }

    @Override
    public void set(int value)
    {
      this.value = value;
    }
    
  }
}
