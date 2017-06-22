package blang.core;

import java.util.Random;

@FunctionalInterface
public interface ForwardSimulator
{
  public void generate(Random random);
}
