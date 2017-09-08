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
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

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
   * 0..<3
   */
  private static Iterable<Integer> $generated__0(final Random rand) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, 3, true);
    return _doubleDotLessThan;
  }
  
  /**
   * Auxiliary method generated to translate:
   * 0..<3
   */
  private static Iterable<Integer> $generated__1(final int i, final Random rand) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, 3, true);
    return _doubleDotLessThan;
  }
  
  /**
   * Auxiliary method generated to translate:
   * { rand.nextInt(4) > 1 + 2 }
   */
  private static boolean $generated__2(final Random rand) {
    int _nextInt = rand.nextInt(4);
    return (_nextInt > (1 + 2));
  }
  
  public static class $generated__2_class implements SupportFactor.Support {
    public boolean isInSupport() {
      return $generated__2(rand);
    }
    
    public String toString() {
      return "{ rand.nextInt(4) > 1 + 2 }";
    }
    
    private Random rand;
    
    public $generated__2_class(final Random rand) {
      this.rand = rand;
    }
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
    
    for (int i : $generated__0(rand)) {
      for (int j : $generated__1(i, rand)) {
        { // Code generated by: (rand) { rand.nextInt(4) > 1 + 2 }
          // Construction and addition of the factor/model:
          components.add(
            new SupportFactor(new $generated__2_class(rand))
            );
        }
      }
    }
    
    return components;
  }
}
