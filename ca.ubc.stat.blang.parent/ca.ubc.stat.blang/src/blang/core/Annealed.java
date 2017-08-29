package blang.core;

/**
 * A Factor equipped with an annealed parameter called exponent which 
 * ranges between 0 (maximum annealing corresponding to an easy distribution)
 * and 1 (no annealing, corresponding to the target distribution).
 */
public interface Annealed extends Factor
{
  void setExponent(double value);
  double getExponent();
  
  public static void check(double value) 
  {
    if (value < 0.0 || value > 1.0)
      throw new RuntimeException("Annealing exponent must be between 0 and 1 inclusive.");
  }
}
