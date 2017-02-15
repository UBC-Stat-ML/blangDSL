package ca.ubc.stat.blang.scoping

import java.util.ArrayList
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.ImportNormalizer

@SuppressWarnings("restriction")
class ImplicitImportsScopeProvider extends org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider {
  
  override getImplicitImports(boolean ignoreCase) {
    val normalizers = new ArrayList<ImportNormalizer>(super.getImplicitImports(ignoreCase));
    normalizers => [
      addPack("blang", "core")
      addPack("blang", "types")
      addPack("blang", "distributions")
      addPack("blang", "mcmc")
      addPack("java",  "util")
      addPack("xlinear")
    ]
    return normalizers;
  }
  
  private def addPack(ArrayList<ImportNormalizer> list, String ... path) {
    list.add(doCreateImportNormalizer(QualifiedName.create(path), true, false))
  }
}
