package blang.core;




/**
 * A class which is not necessarily a factor itself, but that contains 
 * components which themselves may be Factors or Models 
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
@FunctionalInterface
public interface Model extends ModelComponent
{
  public ModelComponents components();
}
