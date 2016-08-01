package ca.ubc.stat.blang.scoping

import java.util.ArrayList
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider

@SuppressWarnings("restriction")
class ImplicitImportsScopeProvider extends XImportSectionNamespaceScopeProvider {
	override getImplicitImports(boolean ignoreCase) {
		val normalizers = new ArrayList<ImportNormalizer>(super.getImplicitImports(ignoreCase));
//        normalizers.add(doCreateImportNormalizer(QualifiedName.create("blang.prototype3"), true, false))
		return normalizers;
	}
}