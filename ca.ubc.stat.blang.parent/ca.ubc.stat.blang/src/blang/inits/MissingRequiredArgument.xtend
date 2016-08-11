package blang.inits

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

class MissingRequiredArgument extends Exception {
  
  @Accessors(PUBLIC_GETTER)
  val List<TypedArgument> missingArguments
  
  public new(List<TypedArgument> missingArguments) {
    this.missingArguments = missingArguments
  }
  
    public new(TypedArgument missingArgument) {
    this.missingArguments = #[missingArgument]
  }
  
  
//  private new() {
//    
//  }
//  
//  private new(String message) {
//    
//  }
}