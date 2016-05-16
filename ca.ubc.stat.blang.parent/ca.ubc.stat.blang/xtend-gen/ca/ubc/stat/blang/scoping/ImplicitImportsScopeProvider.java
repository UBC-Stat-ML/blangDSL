package ca.ubc.stat.blang.scoping;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

@SuppressWarnings("restriction")
public class ImplicitImportsScopeProvider extends XImportSectionNamespaceScopeProvider {
  @Override
  public List<ImportNormalizer> getImplicitImports(final boolean ignoreCase) {
    List<ImportNormalizer> _implicitImports = super.getImplicitImports(ignoreCase);
    final ArrayList<ImportNormalizer> normalizers = new ArrayList<ImportNormalizer>(_implicitImports);
    QualifiedName _create = QualifiedName.create("blang.prototype2");
    ImportNormalizer _doCreateImportNormalizer = this.doCreateImportNormalizer(_create, true, false);
    normalizers.add(_doCreateImportNormalizer);
    QualifiedName _create_1 = QualifiedName.create("blang.prototype3");
    ImportNormalizer _doCreateImportNormalizer_1 = this.doCreateImportNormalizer(_create_1, true, false);
    normalizers.add(_doCreateImportNormalizer_1);
    return normalizers;
  }
}
