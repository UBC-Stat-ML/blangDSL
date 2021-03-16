package blang.core;

import java.util.Random;

public interface RealDistribution 
{
  double sample(Random random);
  double logDensity(double point);
}
