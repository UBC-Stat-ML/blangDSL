package ca.ubc.stat.blang.compiler

import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.Later
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

class BlangXbaseCompiler extends XbaseCompiler {

    /**
     * Map of available type conversions. It works in two steps: actual -> toBeConvertedTo -> converter.
     * Converters are lambdas taking two arguments, {@link Later} and {@link ITreeAppendable}, as given to {@link #doConversion()}
     */
    public static val typeConversionMap = newHashMap(
      
        'blang.core.RealVar' 
        -> newHashMap(
            'java.lang.Double'   -> unbox('doubleValue()'), // eg: RealVar x is converted to Double via x.doubleValue() (plus standard Java autoboxing which can be skipped here since we generate Java source) 
            'double'             -> unbox('doubleValue()')),
            // Note do not add Integer/int here since we can't always convert double to int without loss of information
            
        'double' 
        -> newHashMap(
            'blang.core.RealVar' -> box()),
            // Note do not add IntVar here for same reason as above Note
            
        'blang.core.IntVar' 
        -> newHashMap(
            'Double'             -> unbox('intValue()'), // All the four here needs to be intValue() since that's the only method available on IntVar, standard Java autoboxing takes care of the rest
            'Integer'            -> unbox('intValue()'),
            'double'             -> unbox('intValue()'),
            'int'                -> unbox('intValue()')),
            
        'int' 
        -> newHashMap(
            'blang.core.IntVar' -> box(),
            'blang.core.RealVar' -> box())
            
    )

    /**
     * left:  totoBeConvertedTo
     * right: actualType
     */
    override protected doConversion(
        LightweightTypeReference toBeConvertedTo,
        LightweightTypeReference actual,
        ITreeAppendable appendable,
        XExpression context,
        Later expression
    ) {
        val targetMap = typeConversionMap.get(actual.identifier)
        val converter = targetMap?.get(toBeConvertedTo.identifier)
        if (converter != null) {
            converter.apply(expression, appendable)
        } else
            super.doConversion(toBeConvertedTo, actual, appendable, context, expression)
    }

    /**
     * Helper that returns a lambda that compiles the unboxing conversion using the {@code method}.
     */
    private static def unbox(String method) {
        [ Later expression, ITreeAppendable appendable |
            appendable.append("(");
            expression.exec(appendable);
            appendable.append(")");
            appendable.append(".");
            appendable.append(method)
        ]
    }
    
    /**
     * Helper that returns a lambda that compiles the boxing conversion to the lazy value.
     */
    private static def box() {
        [ Later expression, ITreeAppendable appendable |
            appendable.append("() -> (");
            expression.exec(appendable);
            appendable.append(")");
        ]
    }
}