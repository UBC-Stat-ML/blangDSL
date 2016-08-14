package blang.inits

import java.util.List
import java.lang.reflect.TypeVariable
import java.lang.reflect.Type
import java.lang.reflect.ParameterizedType

class Tests {
  
  static class Proto {
    var List<String> myList
    def test() { myList.size }
  }
  
  def static void main(String [] args) {
    val Class<?> myC = Proto
    val Type field = myC.declaredFields.get(0).genericType
    println((field as ParameterizedType).actualTypeArguments.get(0))
    println((field as ParameterizedType).rawType.class)
  }
}