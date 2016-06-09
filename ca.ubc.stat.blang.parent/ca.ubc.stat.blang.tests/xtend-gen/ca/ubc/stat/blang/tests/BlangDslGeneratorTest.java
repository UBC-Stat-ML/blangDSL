package ca.ubc.stat.blang.tests;

import ca.ubc.stat.blang.tests.BlangDslInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.TemporaryFolder;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BlangDslInjectorProvider.class)
@SuppressWarnings("all")
public class BlangDslGeneratorTest {
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void emptyParams() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import blang.core.Model;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void randomParams() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("random Real mu");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("random Real y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import blang.core.Model;");
      _builder_1.newLine();
      _builder_1.append("import blang.prototype3.Real;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Real mu;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Real y;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public MyFile(final Real mu, final Real y) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.mu = mu;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.y = y;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void simpleNormalModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("random Real mu");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("random Real y");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("laws {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("y | Real mean = mu ~ Normal(mean, [mean.doubleValue ** 2])");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import blang.core.Model;");
      _builder_1.newLine();
      _builder_1.append("import blang.core.ModelComponent;");
      _builder_1.newLine();
      _builder_1.append("import blang.prototype3.Real;");
      _builder_1.newLine();
      _builder_1.append("import java.util.ArrayList;");
      _builder_1.newLine();
      _builder_1.append("import java.util.Collection;");
      _builder_1.newLine();
      _builder_1.append("import java.util.function.Supplier;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Real mu;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Real y;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public MyFile(final Real mu, final Real y) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.mu = mu;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.y = y;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Collection<ModelComponent> components() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("ArrayList<ModelComponent> components = new ArrayList();");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("components.add(new Normal(");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("y,");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("new $Generated_SupplierSubModel0Param0(mu),");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("new $Generated_SupplierSubModel0Param1(mu))");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append(");");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return components;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public static class $Generated_SupplierSubModel0Param0 implements Supplier<Real> {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("private final Real mean;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("public $Generated_SupplierSubModel0Param0(final Real mean) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("this.mean = mean;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("@Override");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("public Real get() {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return mean;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public static class $Generated_SupplierSubModel0Param1 implements Supplier<Real> {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("private final Real mean;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("public $Generated_SupplierSubModel0Param1(final Real mean) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("this.mean = mean;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("@Override");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("public Real get() {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("final Real _function = new Real() {");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("public double doubleValue() {");
      _builder_1.newLine();
      _builder_1.append("          ");
      _builder_1.append("double _doubleValue = $Generated_SupplierSubModel0Param1.this.mean.doubleValue();");
      _builder_1.newLine();
      _builder_1.append("          ");
      _builder_1.append("return Math.pow(_doubleValue, 2);");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return _function;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
