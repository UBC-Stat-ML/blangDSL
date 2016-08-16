package blang.inits

import blang.inits.Arguments.ArgumentItem
import java.util.ArrayList
import java.util.List
import com.google.common.base.Splitter

class PosixParser {
  
  // TODO: add { .. } behavior
  
//  def static Arguments parse(String args) {
//    return parse(Splitter.onPattern("\\s+").splitToList(args))
//  }
  
  def static Arguments parse(String ... args) {
    val List<ArgumentItem> items = new ArrayList
    
    var List<String> currentKey = new ArrayList // root
    var List<String> currentValue = new ArrayList
    
    for (String arg : args) {
      if (arg.matches("[-][-].*")) {
        // process previous (unless it's the empty root)
        if (!currentKey.isEmpty || !currentValue.isEmpty) {
          items.add(new ArgumentItem(currentKey, currentValue))
        }
        // start next
        currentKey = readKey(arg)
        currentValue = new ArrayList
      } else {
        currentValue += arg
      }
    }
    
    // don't forget to process last one too
    if (!currentKey.isEmpty || !currentValue.isEmpty) {
      items.add(new ArgumentItem(currentKey, currentValue))
    }
    
    return Arguments.parse(items)
  }
  
  def static List<String> readKey(String string) {
    return Splitter.on(".").splitToList(string.replaceFirst("^[-][-]", ""))
  }
  
}