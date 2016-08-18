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
import java.lang.annotation.Annotation
import java.util.LinkedHashSet
import blang.inits.InitInfoName
import blang.inits.InitInfoType

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
    // orders the keys as well as the slot used by other annotations
    val List<Annotation> annotatedArguments = new ArrayList
    val Builder builder
    var Optional<Input> inputAnnotation = Optional.empty
    
    def boolean hasInput() {
      return inputAnnotation.present
    }
    
    def static Annotation findAnnotation(Parameter p) {
      var Optional<Annotation> result = Optional.empty
      for (Annotation annotation : p.annotations) {
        if (possibleAnnotations.contains(annotation.annotationType)) {
          if (result.present) {
            throw new RuntimeException // TODO: report duplicate
          }
          result = Optional.of(annotation)
        }
      }
      if (!result.present) {
        throw new RuntimeException // TODO: one needs to be there
      }
      return result.get
    }
    
    val static Set<Class<?>> possibleAnnotations = new LinkedHashSet(#[Input, ConstructorArg, InitInfoName, InitInfoType])
    
    new (InstantiationContext context) {
      builder = getConstructor(context)
      for (Parameter p : builder.parameters) {
        val Annotation currentAnnotation = findAnnotation(p) 
        annotatedArguments.add(currentAnnotation)
        switch currentAnnotation {
          ConstructorArg : {
            val Type childType = p.parameterizedType
            val ArgumentSpecification spec = new ArgumentSpecification(childType, FeatureAnnotation::readDefault(p.getAnnotationsByType(Default)), currentAnnotation.description)
            val String name = currentAnnotation.value
            arguments.put(name, spec)
          }
          Input : {
            inputAnnotation = Optional.of(currentAnnotation)
          }
          InitInfoName : {}
          InitInfoType : {}
          default :
            throw new RuntimeException // should not get here
        }
      }
    }
  
    def size() {
      return annotatedArguments.size
    }
  }

  override InitResult instantiate(InstantiationContext context, Map<String, Object> instantiatedChildren) {
    val BuilderArgumentsSpecification spec = new BuilderArgumentsSpecification(context)
    val Object [] sortedArguments = newArrayOfSize(spec.size)
    var int i = 0
    for (Annotation currentAnnotation : spec.annotatedArguments) {
      switch currentAnnotation {
        Input : 
          sortedArguments.set(i++, context.argumentValue.get)
        ConstructorArg : 
          sortedArguments.set(i++, instantiatedChildren.get(currentAnnotation.value))
        InitInfoType :
          sortedArguments.set(i++, context.requestedType)
        InitInfoName :
          sortedArguments.set(i++, context.arguments.getQName())
        default : 
          throw new RuntimeException // should not get here
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