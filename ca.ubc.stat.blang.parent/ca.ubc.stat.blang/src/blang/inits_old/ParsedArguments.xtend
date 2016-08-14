package blang.inits

import java.util.List
import java.util.Optional

// TODO: make this a class
interface ParsedArguments {
  def QualifiedName prefix()
  
  /**
   * null if the key --prefix() is not defined
   * empty list if the key --prefix() is defined as a switch (with no arguments)
   * otherwise, holds the strings between --prefix() and next --item
   */
  def Optional<List<String>> contents() 
  
  def ParsedArguments withContentsConsumed()
  def ParsedArguments child(String childName)
}