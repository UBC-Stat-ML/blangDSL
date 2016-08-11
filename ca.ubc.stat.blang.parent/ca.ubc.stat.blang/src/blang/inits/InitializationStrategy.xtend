package blang.inits

import java.util.List

interface InitializationStrategy<T> {
  def T init(
    ParsedArguments parsed, 
    Class<T> typeToInitialize, 
    Initializer initializer,
    List<TypedArgument> registeredArguments
  ) throws MissingRequiredArgument
}