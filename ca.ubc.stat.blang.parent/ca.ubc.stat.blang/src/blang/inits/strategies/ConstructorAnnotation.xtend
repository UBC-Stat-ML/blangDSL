package blang.inits.strategies

import blang.inits.ArgumentSpecification
import blang.inits.ConstructorArg
import blang.inits.Default
import blang.inits.InitResult
import blang.inits.InstantiationStrategy
import blang.inits.Instantiator.InstantiationContext
import java.lang.reflect.Constructor
import java.lang.reflect.Parameter
import java.lang.reflect.Type
import java.util.LinkedHashMap
import java.util.Map
import java.util.Optional
import java.util.Set
import java.lang.reflect.Method
import org.eclipse.xtend.lib.annotations.Data
import blang.inits.DesignatedConstructor
import java.util.List
import java.util.ArrayList
import blang.inits.Input

class ConstructorAnnotation implements InstantiationStrategy {
  
  override String formatDescription(InstantiationContext context) {
    val BuilderArgumentsSpecification spec = new BuilderArgumentsSpecification(context)
    if (spec.hasInput) {
      return spec.inputAnnotation.get.formatDescription
    } else {
      return ""
    }
  }
  
  override LinkedHashMap<String, ArgumentSpecification> childrenSpecifications(
    InstantiationContext context, 
    Set<String> providedChildrenKeys
  ) {
    return new BuilderArgumentsSpecification(context).arguments
  }
  
  static class BuilderArgumentsSpecification {
    val LinkedHashMap<String, ArgumentSpecification> arguments = new LinkedHashMap
    
    // orders the keys as well as potentially a slot for the input
    val List<String> orderedKeys = new ArrayList
    val static final String INPUT_SLOT = "INPUT_SLOT"
    
    val Builder builder
    
    var Optional<Input> inputAnnotation = Optional.empty 
    
    def boolean hasInput() {
      return inputAnnotation.present
    }
    
    new (InstantiationContext context) {
      builder = getConstructor(context)
      for (Parameter p : builder.parameters) {
        val ConstructorArg [] args = p.getAnnotationsByType(ConstructorArg)
        val Input [] inputs = p.getAnnotationsByType(Input)
        if (args.size === 1 && inputs.size === 1) {
          throw new RuntimeException("These two annotations cannot be used at same time @" + ConstructorArg.simpleName + " and @" + Input.simpleName)
        } else if (args.size === 1) {
          val ConstructorArg arg = args.get(0)
          val Type childType = p.parameterizedType
          val ArgumentSpecification spec = new ArgumentSpecification(childType, FeatureAnnotation::readDefault(p.getAnnotationsByType(Default)), arg.description)
          val String name = arg.value
          arguments.put(name, spec)
          orderedKeys.add(name)
        } else if (inputs.size === 1) {
          if (hasInput) {
            throw new RuntimeException("At most one input can be associated with @" + Input.simpleName)
          } 
          orderedKeys.add(INPUT_SLOT)
          inputAnnotation = Optional.of(inputs.get(0))
        } else {
          throw new RuntimeException("Each argument of the designated constructor should have exactly one annotation @" + ConstructorArg.simpleName
            + " or, for at most one of the slots, an annotation @" + Input.simpleName)
        }
      }
    }
  
    def size() {
      return orderedKeys.size
    }
  
  }

  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val BuilderArgumentsSpecification spec = new BuilderArgumentsSpecification(context)
    val Object [] sortedArguments = newArrayOfSize(spec.size)
    var int i = 0
    for (String key : spec.orderedKeys) {
      if (key === BuilderArgumentsSpecification.INPUT_SLOT) {
        sortedArguments.set(i++, context.argumentValue.get)
      } else {
        sortedArguments.set(i++, instantiatedChildren.get(key))
      }
    }
    return InitResult.success(spec.builder.build(sortedArguments))
  }
  
  static interface Builder {
    def Object build(Object ... arguments)
    def Iterable<Parameter> parameters()
  }
  
  @Data
  static class ConstructorBuilder implements Builder {
    val Constructor<?> constructor
    override Object build(Object... arguments) {
      return constructor.newInstance(arguments)
    }
    override Iterable<Parameter> parameters() {
      return constructor.parameters
    }
  }
  
  @Data
  static class FactoryMethod implements Builder {
    val Method staticBuilder
    override Object build(Object... arguments) {
      return staticBuilder.invoke(null, arguments)
    }
    override Iterable<Parameter> parameters() {
      return staticBuilder.parameters
    }
    
  }
  
  def static Builder getConstructor(InstantiationContext context) {
    var Optional<Builder> found = Optional.empty
    for (Constructor<?> c : context.rawType.constructors) {
      if (!c.getAnnotationsByType(DesignatedConstructor).empty) {
        if (found.present) {
          throw new RuntimeException("Not more than one constructor/static factory should be marked with @" + DesignatedConstructor.simpleName)
        }
        found = Optional.of(new ConstructorBuilder(c))
      }
    }
    for (Method m : context.rawType.methods) {
      if (!m.getAnnotationsByType(DesignatedConstructor).empty) {
        if (found.present) {
          throw new RuntimeException("Not more than one constructor/static factory should be marked with @" + DesignatedConstructor.simpleName)
        }
        found = Optional.of(new FactoryMethod(m))
      } 
    }
    if (!found.present)
    {
      // defaults to zero-arg constructor
      val Constructor<?> zeroArg = context.rawType.getConstructor()
      if (zeroArg !== null) {
        found = Optional.of(new ConstructorBuilder(zeroArg))
      }
    }
    if (found.present) {
      return found.get
    } else {
      throw new RuntimeException("One of the constructors should be marked with @" + DesignatedConstructor.simpleName)
    }
  }
  
  override boolean acceptsInput(InstantiationContext context) {
    return new BuilderArgumentsSpecification(context).hasInput
  }
  
}