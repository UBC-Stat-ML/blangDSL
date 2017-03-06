import blang.core.DeboxedName;
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
    public RealVar mu;
    
    @Arg
    public RealVar variance;
    
    public MyFile build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      final RealVar __mu = mu;
      final RealVar __variance = variance;
      // Build the instance after boxing params
      return new MyFile(
        () -> __mu, 
        () -> __variance
      );
    }
  }
  
  @Param
  private final Supplier<RealVar> $generated__mu;
  
  public RealVar getMu() {
    return $generated__mu.get();
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
   * Note: the generated code has the following properties used at runtime:
   *   - all arguments are annotated with a BlangVariable annotation
   *   - params additionally have a Param annotation
   *   - the order of the arguments is as follows:
   *     - first, all the random variables in the order they occur in the blang file
   *     - second, all the params in the order they occur in the blang file
   * 
   */
  public MyFile(@Param @DeboxedName("mu") final Supplier<RealVar> $generated__mu, @Param @DeboxedName("variance") final Supplier<RealVar> $generated__variance) {
    this.$generated__mu = $generated__mu;
    this.$generated__variance = $generated__variance;
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public Collection<ModelComponent> components() {
    ArrayList<ModelComponent> components = new ArrayList();
    
    
    return components;
  }
}
