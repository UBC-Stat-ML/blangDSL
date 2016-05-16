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
      _builder_1.append("import blang.core.ModelComponent;");
      _builder_1.newLine();
      _builder_1.append("import java.util.Collection;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyFile implements Model {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Collection<ModelComponent> components() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("java.util.ArrayList<blang.core.ModelComponent> components = new java.util.ArrayList();");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return components;");
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
      _builder_1.append("import blang.core.ModelComponent;");
      _builder_1.newLine();
      _builder_1.append("import blang.prototype.Real;");
      _builder_1.newLine();
      _builder_1.append("import java.util.Collection;");
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
      _builder_1.append("this.mu = mu");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.y = y");
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
      _builder_1.append("java.util.ArrayList<blang.core.ModelComponent> components = new java.util.ArrayList();");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return components;");
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
