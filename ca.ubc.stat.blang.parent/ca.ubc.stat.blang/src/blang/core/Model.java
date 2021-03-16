package blang.core;

import java.util.Collection;

/**
 * A class which is not necessarily a factor itself, but that contains 
 * components which themselves may be Factors or Models 
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
@FunctionalInterface // Use to ensure uniqueDeclaredMethod will work
public interface Model extends ModelComponent
{
  public Collection<ModelComponent> components();
}
