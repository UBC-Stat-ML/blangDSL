package blang.inits

import java.util.List

/**
 * Abstract out following behaviors:
 * - one arg constructor consuming contents
 * - no arg constructor, followed by fill in by setters/fields
 * - constructor with annotations
 * - interface with annotated list of implementations (with or without default)
 * - List<T>
 * - Map<T> 
 */
interface InitializationStrategy<T> {
  
  
  
  // list of name+type+default+description
  // TypedArgument = type+default+description
  // def Map<String,TypedArgument> childrenSpecification(List<String> contents, List<String> offered)
  
  
//  def InitResult init(List<String> contents, Map<String,Object> children)
  
//  def T init(
//    ParsedArguments parsed, 
//    Class<T> typeToInitialize, 
//    Initializer initializer,
//    List<TypedArgument> registeredArguments
//  ) throws MissingRequiredArgument
}