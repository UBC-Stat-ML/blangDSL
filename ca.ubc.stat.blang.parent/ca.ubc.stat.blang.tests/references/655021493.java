import blang.core.DeboxedName;
import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponent;
import blang.core.RealVar;
import blang.inits.Arg;
import ca.ubc.stat.blang.StaticJavaUtils;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("all")
public class MyFile implements Model {
  public static class Builder implements ModelBuilder {
    @Arg
    public RealVar mu;
    
    @Arg
    public RealVar y;
    
    public MyFile build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      final RealVar __mu = mu;
      final RealVar __y = y;
      // Build the instance after boxing params
      return new MyFile(
        __mu, 
        __y
      );
    }
  }
  
  private final RealVar mu;
  
  public RealVar getMu() {
    return mu;
  }
  
  private final RealVar y;
  
  public RealVar getY() {
    return y;
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
  public MyFile(@DeboxedName("mu") final RealVar mu, @DeboxedName("y") final RealVar y) {
    this.mu = mu;
    this.y = y;
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
