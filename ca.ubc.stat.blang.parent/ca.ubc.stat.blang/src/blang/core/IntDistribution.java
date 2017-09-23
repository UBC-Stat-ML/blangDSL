package blang.core;

import java.util.Random;

public interface IntDistribution
{
  int sample(Random random);
  double logDensity(int point);
}
