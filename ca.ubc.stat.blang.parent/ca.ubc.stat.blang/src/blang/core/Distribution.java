package blang.core;

import java.util.Random;

/**
 * An interface for distribution over an arbitrary type T modified in place.
 * 
 * Usage:
 * 
 * distribution.realization().SOME_METHOD_TO_MODIFY_STATE();
 * double result = distribution.logDensity();
 * 
 * or
 * 
 * distribution.sample(random);
 * T result = distribution.realization();
 */
public interface Distribution<T> 
{
  public void sample(Random random);
  public double logDensity();
  public T realization();
}
