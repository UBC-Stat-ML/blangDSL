import blang.core.DeboxedName;
import blang.core.LogScaleFactor;
import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponent;
import blang.core.Param;
import blang.core.RealVar;
import blang.inits.Arg;
import ca.ubc.stat.blang.StaticJavaUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

@SuppressWarnings("all")
public class MyFile implements Model {
  public static class Builder implements ModelBuilder {
    @Arg
    public RealVar mean;
    
    @Arg
    public RealVar variance;
    
    public MyFile build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      final RealVar __mean = mean;
      final RealVar __variance = variance;
      // Build the instance after boxing params
      return new MyFile(
        () -> __mean, 
        () -> __variance
      );
    }
  }
  
  @Param
  private final Supplier<RealVar> $generated__mean;
  
  public RealVar getMean() {
    return $generated__mean.get();
  }
  
  @Param
  private final Supplier<RealVar> $generated__variance;
  
  public RealVar getVariance() {
    return $generated__variance.get();
  }
  
  /**
   * Utility main method for posterior inference on this model
   */
  public static void main(final String[] arguments) {
    StaticJavaUtils.callRunner(Builder.class, arguments);
  }
  
  /**
   * Auxiliary method generated to translate:
   * { -0.5 * mean.doubleValue / variance.doubleValue }
   */
  private static Double $generated__0(final RealVar variance, final RealVar mean) {
    double _doubleValue = mean.doubleValue();
    double _multiply = ((-0.5) * _doubleValue);
    double _doubleValue_1 = variance.doubleValue();
    return Double.valueOf((_multiply / _doubleValue_1));
  }
  
  /**
   * Auxiliary method generated to translate:
   * { -0.5 * mean.doubleValue / variance.doubleValue }
   */
  private static LogScaleFactor $generated__0_lazy(final Supplier<RealVar> $generated__variance, final Supplier<RealVar> $generated__mean) {
    return () -> $generated__0($generated__variance.get(), $generated__mean.get());
  }
  
  /**
   * Note: the generated code has the following properties used at runtime:
   *   - all arguments are annotated with a BlangVariable annotation
   *   - params additionally have a Param annotation
   *   - the order of the arguments is as follows:
   *     - first, all the random variables in the order they occur in the blang file
   *     - second, all the params in the order they occur in the blang file
   * 
   */
  public MyFile(@Param @DeboxedName("mean") final Supplier<RealVar> $generated__mean, @Param @DeboxedName("variance") final Supplier<RealVar> $generated__variance) {
    this.$generated__mean = $generated__mean;
    this.$generated__variance = $generated__variance;
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public Collection<ModelComponent> components() {
    ArrayList<ModelComponent> components = new ArrayList();
    
    { // Code generated by: (variance, mean) { -0.5 * mean.doubleValue / variance.doubleValue }
      // Construction and addition of the factor/model:
      components.add(
        $generated__0_lazy($generated__variance, $generated__mean)
      );
    }
    
    return components;
  }
}
