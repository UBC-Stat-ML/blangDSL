package blang.inits

import org.eclipse.xtend.lib.annotations.Data
import java.util.List
import com.google.common.base.Joiner
import java.util.Collections
import java.util.ArrayList

@Data
class QualifiedName {
  val List<String> items
  val static final String SEPARATOR = "."
  
  
  
  override String toString() {
    return Joiner.on(SEPARATOR).join(items)
  }
  
  def +(String subItem) {
    val List<String> newItems = new ArrayList
    newItems.addAll(this.items)
    newItems += subItem
    return new QualifiedName(newItems)
  }
  
  def static QualifiedName empty() {
    return new QualifiedName(Collections.EMPTY_LIST)
  }
}