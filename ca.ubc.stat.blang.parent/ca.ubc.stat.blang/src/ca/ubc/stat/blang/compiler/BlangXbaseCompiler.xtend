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
     * Map of available type conversions. It works in two steps: sourceType -> targetType -> converter.
     * Converters are lambdas taking two arguments, {@link Later} and {@link ITreeAppendable}, as given to {@link #doConversion()}
     */
    public static val typeConversionMap = newHashMap(
        'blang.core.RealVar' -> newHashMap(
            'double' -> unbox('doubleValue()')),
        'double' -> newHashMap(
            'blang.core.IntVar' -> box(),
            'blang.core.RealVar' -> box()),
        'blang.core.IntVar' -> newHashMap(
            'int' -> unbox('intValue()')),
        'int' -> newHashMap(
            'blang.core.IntVar' -> box(),
            'blang.core.RealVar' -> box())
    )

    override protected doConversion(
        LightweightTypeReference left,
        LightweightTypeReference right,
        ITreeAppendable appendable,
        XExpression context,
        Later expression
    ) {
        val targetMap = typeConversionMap.get(right.identifier)
        val converter = targetMap?.get(left.identifier)
        if (converter != null) {
            converter.apply(expression, appendable)
        } else
            super.doConversion(left, right, appendable, context, expression)
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