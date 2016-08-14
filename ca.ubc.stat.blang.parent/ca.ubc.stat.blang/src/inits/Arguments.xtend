package inits

import java.util.List
import java.util.Set
import java.util.Map
import java.util.HashMap
import org.eclipse.xtend.lib.annotations.Data
import java.util.ArrayList
import java.util.HashSet
import com.google.common.base.Joiner

/**
 * A tree of arguments. E.g. --node is parent of --node.child
 * 
 * Each node has a unique argument key, and optionally, an argument value, e.g. --key value.
 */
class Arguments {
  
  val List<String> argumentValue
  val Map<String, Arguments> children = new HashMap
  
  private new(List<String> argumentValue) {
    if (argumentValue === null) {
      throw new RuntimeException
    }
    this.argumentValue = argumentValue
  }
  
  def private Arguments getOrCreateDesc(List<String> path) {
    var Arguments result = this
    for (var int i = 0; i < path.size; i++) {
      val String currentChildName = path.get(i)
      if (result.childrenKeys.contains(currentChildName)) {
        result = result.child(currentChildName)
      } else {
        val Arguments child = new Arguments(new ArrayList)
        result.addChild(currentChildName, child)
        result = child
      }
    }
    return result
  }
  
  def static Arguments parse(List<ArgumentItem> items) {
    val Set<List<String>> visitedKeys = new HashSet
    val Arguments root = new Arguments(new ArrayList)
    
    for (ArgumentItem item : items) {
      if (visitedKeys.contains(item.fullyQualifiedName)) {
        throw new RuntimeException // TODO: show culpit
      }
      val Arguments node = root.getOrCreateDesc(item.fullyQualifiedName)
      if (!node.argumentValue.empty) {
        throw new RuntimeException
      }
      node.argumentValue.addAll(item.value)
    }
    return root
  }
  
  @Data
  static class ArgumentItem {
    val List<String> fullyQualifiedName // root is empty list
    val List<String> value
  }
  
  def void addChild(String name, Arguments item) {
    if (children.containsKey(name)) {
      throw new RuntimeException
    }
    children.put(name, item)
  }
  
  /**
   * throw exception if the child does not exists
   */
  def Arguments child(String string) {
    val Arguments result = children.get(string)
    if (result === null) {
      throw new RuntimeException
    }
    return result
  }
  
  def List<String> argumentValue() {
    return argumentValue
  }
  
  def Set<String> childrenKeys() {
    return children.keySet
  }
  
    override String toString() {
    val List<String> result = new ArrayList
    toString("", result)
    return "<root>" + Joiner.on("\n").join(result)
  }
  
  def private void toString(String fullyQual, List<String> result) {
    result.add(fullyQual + "\t" +  Joiner.on(" ").join(argumentValue))
    for (String key : children.keySet) {
      val String fullName = if (fullyQual == "") key else fullyQual + "." + key
      children.get(key).toString(fullName, result)
    }
  }
  
}