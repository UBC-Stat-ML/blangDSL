package inits.strategies

import java.util.List
import java.util.Optional
import inits.Instantiator.InstantiationContext

interface Parser<T> {
  def T parse(Optional<List<String>> arguments)
  def String formatDescription(InstantiationContext context)
}