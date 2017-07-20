package blang.core;

import java.util.Collection;
import java.util.LinkedHashMap;

public class ModelComponents
{
  LinkedHashMap<ModelComponent, String> components = new LinkedHashMap<>();
  
  public void add(ModelComponent component, String description)
  {
    components.put(component, description);
  }
  
  public Collection<ModelComponent> get()
  {
    return components.keySet();
  }
  
  public String description(ModelComponent component)
  {
    return components.get(component);
  }
}
