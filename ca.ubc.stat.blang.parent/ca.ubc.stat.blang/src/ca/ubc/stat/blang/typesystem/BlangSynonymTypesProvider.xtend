package ca.ubc.stat.blang.typesystem

import blang.core.RealVar
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags
import ca.ubc.stat.blang.compiler.BlangXbaseCompiler

class BlangSynonymTypesProvider extends SynonymTypesProvider {
    
    override protected boolean collectCustomSynonymTypes(LightweightTypeReference type, Acceptor acceptor) {
        val synonyms = BlangXbaseCompiler.typeConversionMap.get(type.identifier)
        if (synonyms != null) {
            return synonyms.keySet.fold(true,
                [rc, synonym | announceModelType(type.owner, synonym, acceptor)]
            )
        }
        super.collectCustomSynonymTypes(type, acceptor)
    }
    
    protected def boolean announceModelType(
        ITypeReferenceOwner owner,
        String targetName,
        Acceptor acceptor
    ) {
        val typeRefs = owner.services.typeReferences
        val synonym = typeRefs.findDeclaredType(targetName, owner.contextResourceSet)

        if (synonym !== null)
            announceSynonym(
                new ParameterizedTypeReference(owner, synonym),
                ConformanceFlags.DEMAND_CONVERSION,
                acceptor
            )
        else
            true
    }
}