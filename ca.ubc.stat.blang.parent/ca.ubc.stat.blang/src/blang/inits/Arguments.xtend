package blang.inits

import java.util.List
import java.util.Set
import java.util.Map
import java.util.HashMap
import org.eclipse.xtend.lib.annotations.Data
import java.util.ArrayList
import java.util.HashSet
import com.google.common.base.Joiner
import java.util.Optional
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A tree of arguments. E.g. --node is parent of --node.child
 * 
 * Each node has a unique argument key, and optionally, an argument value, e.g. --key value.
 */
class Arguments {
  /**
   * The optional is non-null if and only if the switch --name appears in the command line.
   * Note that the node might still be needed in the tree when it does not occur, e.g. if the 
   * node has descendants that do appear in the command line.
   */
  var Optional<List<String>> argumentValue
  val Map<String, Arguments> children = new HashMap
  
  @Accessors(PUBLIC_GETTER)
  val QualifiedName qName
  
  private new(Optional<List<String>> argumentValue, QualifiedName qName) {
    this.argumentValue = argumentValue
    this.qName = qName
  }
  
  def Arguments consumeValue() {
    val Arguments result = new Arguments(Optional.empty, qName)
    result.children.putAll(this.children)
    return result
  }
  
  def private Arguments getOrCreateDesc(List<String> path) {
    var Arguments result = this
    for (var int i = 0; i < path.size; i++) {
      val String currentChildName = path.get(i)
      if (result.childrenKeys.contains(currentChildName)) {
        result = result.child(currentChildName)
      } else {
        val Arguments child = new Arguments(Optional.empty, result.qName.child(currentChildName))
        result.addChild(currentChildName, child)
        result = child
      }
    }
    return result
  }
  
  def static Arguments parse(List<ArgumentItem> items) {
    val Set<List<String>> visitedKeys = new HashSet
    val Arguments root = new Arguments(Optional.empty, QualifiedName.root())
    
    for (ArgumentItem item : items) {
      if (visitedKeys.contains(item.fullyQualifiedName)) {
        throw new RuntimeException // TODO: show culpit
      }
      val Arguments node = root.getOrCreateDesc(item.fullyQualifiedName)
      if (node.argumentValue.present) {
        throw new RuntimeException
      }
      node.argumentValue = Optional.of(item.value)
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
  
  def Arguments child(String string) {
    val Arguments result = children.get(string)
    if (result === null) {
      return new Arguments(Optional.empty, qName.child(string))
    } else {
      return result
    }
  }
  
  /**
   * We say the tree is null the corresponding switch did not occur, nor
   * any of its descendent
   */
  def boolean isNull() {
    return children.empty && !argumentValue.present
  }
  
  /**
   * null if the key was not inserted, i.e. the switch did not occur
   */
  def Optional<List<String>> argumentValue() {
    return argumentValue
  }
  
  def Set<String> childrenKeys() {
    return children.keySet
  }
  
  override String toString() {
    val List<String> result = new ArrayList
    toString(result)
    return Joiner.on(" ").join(result)
  }
  
  def private void toString(List<String> result) {
    if (argumentValue.present) {
      result.add((if (qName.isRoot()) "" else "--" + qName + " ") + Joiner.on(" ").join(argumentValue.get))
    }
    for (String key : children.keySet) {
      children.get(key).toString(result)
    }
  }
  
}