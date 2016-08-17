package blang.inits

import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import java.util.ArrayList
import com.google.common.base.Joiner

@Data
class QualifiedName {
  val List<String> path
  
  val static String SEPARATOR = '.'
  val static String ROOT_STRING = "<root>"
  
  def static QualifiedName root() {
    return new QualifiedName(new ArrayList)
  }
  
  def QualifiedName child(String name) {
    val List<String> newPath = new ArrayList(path)
    newPath += name
    return new QualifiedName(newPath)
  }
  
  override String toString() {
    return 
      if (path.isEmpty) {
        ROOT_STRING
      } else {
        Joiner.on(SEPARATOR).join(path)
      }
  }
  
  def isRoot() {
    return path.isEmpty
  }
  
}