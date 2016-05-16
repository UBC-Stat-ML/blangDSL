package ca.ubc.stat.blang.scoping

import java.util.ArrayList
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.ImportNormalizer

@SuppressWarnings("restriction")
class ImplicitImportsScopeProvider extends org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider {
	override getImplicitImports(boolean ignoreCase) {
		val normalizers = new ArrayList<ImportNormalizer>(super.getImplicitImports(ignoreCase));
        normalizers.add(doCreateImportNormalizer(QualifiedName.create("blang.prototype2"), true, false))
        normalizers.add(doCreateImportNormalizer(QualifiedName.create("blang.prototype3"), true, false))
		return normalizers;
	}
}