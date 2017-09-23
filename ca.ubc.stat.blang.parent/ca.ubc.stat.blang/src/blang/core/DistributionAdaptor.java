package blang.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistributionAdaptor<T> implements Distribution<T>
{
  private final ForwardSimulator forwardSimulator;
  private final List<LogScaleFactor> factors;
  private final T realization;
  
  public DistributionAdaptor(UnivariateModel<T> model)
  {
    this.realization = model.realization();
    this.factors = new ArrayList<>();
    extractFactors(model, this.factors);
    this.forwardSimulator = model instanceof ForwardSimulator ? (ForwardSimulator) model : null;
  }

  private static void extractFactors(ModelComponent component, List<LogScaleFactor> result)
  {
    if (component instanceof Model)
      for (ModelComponent subComponent : ((Model) component).components())
        extractFactors(subComponent, result);
    if (component instanceof LogScaleFactor)
      result.add((LogScaleFactor) component);
  }

  @Override
  public void sample(Random random)
  {
    if (forwardSimulator == null)
      throw new RuntimeException("Operation not implemented.");
    forwardSimulator.generate(random);
  }

  @Override
  public double logDensity()
  {
    double sum = 0.0;
    for (LogScaleFactor factor : factors)
      sum += factor.logDensity();
    return sum;
  }

  @Override
  public T realization()
  {
    return realization; 
  }
}
