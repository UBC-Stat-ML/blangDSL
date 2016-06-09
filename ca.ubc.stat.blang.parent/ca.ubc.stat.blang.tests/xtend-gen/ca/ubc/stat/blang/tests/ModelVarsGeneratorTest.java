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
public class ModelVarsGeneratorTest {
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void emptyVars() {
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
  public void randomVars() {
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
  public void paramVars() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("param Real mu");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("param Real variance");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import blang.core.Model;");
      _builder_1.newLine();
      _builder_1.append("import blang.prototype3.Real;");
      _builder_1.newLine();
      _builder_1.append("import java.util.function.Supplier;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Supplier<Real> mu;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Supplier<Real> variance;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public MyFile(final Supplier<Real> mu, final Supplier<Real> variance) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.mu = mu;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.variance = variance;");
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
  public void mixedVars() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("param Real mu");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("param Real variance");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("random Real y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import blang.core.Model;");
      _builder_1.newLine();
      _builder_1.append("import blang.prototype3.Real;");
      _builder_1.newLine();
      _builder_1.append("import java.util.function.Supplier;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Real y;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Supplier<Real> mu;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public final Supplier<Real> variance;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public MyFile(final Real y, final Supplier<Real> mu, final Supplier<Real> variance) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.y = y;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.mu = mu;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.variance = variance;");
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
