import blang.core.DeboxedName;
import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponent;
import blang.core.SupportFactor;
import blang.inits.Arg;
import ca.ubc.stat.blang.StaticJavaUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@SuppressWarnings("all")
public class MyFile implements Model {
  public static class Builder implements ModelBuilder {
    @Arg
    public Random rand;
    
    public MyFile build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      final Random __rand = rand;
      // Build the instance after boxing params
      return new MyFile(
        __rand
      );
    }
  }
  
  private final Random rand;
  
  public Random getRand() {
    return rand;
  }
  
  /**
   * Utility main method for posterior inference on this model
   */
  public static void main(final String[] arguments) {
    StaticJavaUtils.callRunner(Builder.class, arguments);
  }
  
  /**
   * Auxiliary method generated to translate:
   * rand.nextBoolean() }
   */
  private static Boolean $generated__0(final Random rand) {
    return Boolean.valueOf(rand.nextBoolean());
  }
  
  /**
   * Auxiliary method generated to translate:
   * rand.nextBoolean() }
   */
  private static SupportFactor $generated__0_lazy(final Random rand) {
    return new SupportFactor(() -> $generated__0(rand));
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
  public MyFile(@DeboxedName("rand") final Random rand) {
    this.rand = rand;
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public Collection<ModelComponent> components() {
    ArrayList<ModelComponent> components = new ArrayList();
    
    { // Code generated by: (rand) rand.nextBoolean() }
      // Construction and addition of the factor/model:
      components.add(
        $generated__0_lazy(rand)
      );
    }
    
    return components;
  }
}