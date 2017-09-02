package blang.core; // RATIONALE: this is in DSL because later on we might want to implement custom DSL-based annealing schemes

import blang.core.LogScaleFactor;

public class AnnealedFactor implements LogScaleFactor
{
  public final LogScaleFactor enclosed;
  private double exponent = 1.0;
  
  public AnnealedFactor(LogScaleFactor enclosed)
  {
    if (enclosed instanceof AnnealedFactor) 
      throw new RuntimeException("Trying to anneal a factor which is already annealed.");
    this.enclosed = enclosed;
  }

  public void setExponent(double value)
  {
    if (value < 0 || value > 1.0)
      throw new RuntimeException();
    this.exponent = value;
  }

  public double getExponent()
  {
    return exponent;
  }

  @Override
  public double logDensity()
  {
    double enclosedLogDensity = enclosed.logDensity();
    if (enclosedLogDensity == Double.NEGATIVE_INFINITY)
      return annealedMinusInfinity(exponent);  
    return exponent * enclosedLogDensity;
  }
  
  /**
   * @return -EXP if exponent is one, o.w., - (0.5 + 0.5 * exponent) * 1E100
   * 
   * RATIONALE: during annealing (exp < 1), we want to strongly discourage hard constraint 
   * violation, but setting gamma to -INF prevents us from e.g. comparing particles with 
   * different numbers of violation in cases where all particles violate some constraints. 
   * 
   * At the same time, even in early generations, if there is at least one particle with 
   * no constraint violation its probability should overwhelm all the violating ones 
   * (this is important e.g. in cases where constraint violation would otherwise break 
   * the user's likelihood evaluation code (out of bound errors on random indices, etc).
   * 
   * The penalty should also increase so that incremental weight updates in e.g. SMC Sampler
   * algorithms pick up the penalty. i.e. there will be used as:
   * 
   * pi_n(x) / pi_{n-1}(x) = exp{ # violations * [ - (0.5 + 0.5 * T2) * Double.MAX_VALUE + (0.5 + 0.5 * T1) * Double.MAX_VALUE ] }
   * 
   * where T1, T2 \in [0, 1] will be values in the typical range Ti \in 0.0001-0.1
   * 
   * We pick 1E100 rather than Double.MAX_VALUE to cover cases where say thousands or more 
   * constraints are initially violated.
   * 
   * We also want the extreme case exp = 0 to penalize constraints, e.g. if we do MCMC move 
   * in parallel tempering with some chains at temperature t = 0.
   */
  public static double annealedMinusInfinity(double exponent) 
  {
    if (exponent == 1.0)
      return Double.NEGATIVE_INFINITY;
    return - (0.5 + 0.5 * exponent) * 1E100; 
  }
}
