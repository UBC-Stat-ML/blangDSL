package ca.ubc.stat.blang.compiler

import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.XAbstractFeatureCall

class BlangXbaseCompiler extends XbaseCompiler {
    override protected internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
        val LightweightTypeReference expectedType = getLightweightExpectedType(obj);
        val actualType = getLightweightReturnType(obj) // or just getLightweightType??
        
        val wrap =
               expectedType !== null && actualType !== null &&
               expectedType.identifier != actualType.identifier &&
               expectedType.isType(double) &&
               actualType.isType(blang.core.RealVar)
               
        if (wrap) {
            super._toJavaExpression(obj as XAbstractFeatureCall, appendable)
            appendable.append(".doubleValue()")
        }
        else {
            super.internalToConvertedExpression(obj, appendable)
        }
    }
    
}