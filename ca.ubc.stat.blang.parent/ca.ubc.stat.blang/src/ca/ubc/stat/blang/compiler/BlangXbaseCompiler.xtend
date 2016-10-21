package ca.ubc.stat.blang.compiler

import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.compiler.Later
import blang.core.RealVar

class BlangXbaseCompiler extends XbaseCompiler {

    override protected doConversion(
        LightweightTypeReference left,
        LightweightTypeReference right,
        ITreeAppendable appendable,
        XExpression context,
        Later expression
    ) {
        if (right.isType(RealVar) && left.isType(double)) {
            // this code is lifted from {@link org.eclipse.xtext.xbase.compiler.TypeConvertingCompiler#convertWrapperToPrimitive}
            val XExpression normalized = normalizeBlockExpression(context);
            if (normalized instanceof XAbstractFeatureCall &&
                !(context.eContainer() instanceof XAbstractFeatureCall)) {
                // Avoid javac bug
                // https://bugs.eclipse.org/bugs/show_bug.cgi?id=410797
                // TODO make that dependent on the compiler version (javac 1.7 fixed that bug)
                val XAbstractFeatureCall featureCall = normalized as XAbstractFeatureCall;
                if (featureCall.isStatic()) {
                    val JvmIdentifiableElement feature = featureCall.getFeature();
                    if (feature instanceof JvmOperation) {
                        if (!(feature as JvmOperation).getTypeParameters().isEmpty()) {
                            appendable.append("(double)");
                            expression.exec(appendable);
                            return;
                        }
                    }
                }
            }
            appendable.append("(");
            expression.exec(appendable);
            appendable.append(")");
            appendable.append(".");
            appendable.append("doubleValue()");
        }
        else super.doConversion(left, right, appendable, context, expression)
    }
    
}