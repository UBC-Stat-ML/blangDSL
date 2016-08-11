package blang.inits

import java.util.Optional

interface ParsedArguments {
  def QualifiedName prefix()
  def Optional<String> contents() // "" if just a switch, nothing if the key is not specified
  def ParsedArguments withContentsConsumed()
  def ParsedArguments child(String childName)
  def ParsedArguments fromDefaultString(String defaultString)
}