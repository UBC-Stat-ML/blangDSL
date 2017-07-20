import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponents;
import ca.ubc.stat.blang.StaticJavaUtils;

@SuppressWarnings("all")
public class MyFile implements Model {
  public static class Builder implements ModelBuilder {
    public MyFile build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      // Build the instance after boxing params
      return new MyFile(
      );
    }
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
  public MyFile() {
    
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public ModelComponents components() {
    ModelComponents components = new ModelComponents();
    
    
    return components;
  }
}
