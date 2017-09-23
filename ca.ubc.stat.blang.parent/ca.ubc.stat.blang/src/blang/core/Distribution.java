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
  void sample(Random random);
  double logDensity();
  T realization();
}
