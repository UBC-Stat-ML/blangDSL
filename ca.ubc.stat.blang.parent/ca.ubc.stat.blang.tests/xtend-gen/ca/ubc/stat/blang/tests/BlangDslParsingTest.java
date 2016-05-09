/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.tests;

import ca.ubc.stat.blang.blangDsl.BlangModel;
import ca.ubc.stat.blang.tests.BlangDslInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BlangDslInjectorProvider.class)
@SuppressWarnings("all")
public class BlangDslParsingTest {
  @Inject
  @Extension
  private ParseHelper<BlangModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void emptyModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final BlangModel model = this._parseHelper.parse(_builder);
      Assert.assertNotNull(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void emptyFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("x");
      _builder.newLine();
      final BlangModel model = this._parseHelper.parse(_builder);
      Assert.assertNotNull(model);
      Resource _eResource = model.eResource();
      this._validationTestHelper.assertError(_eResource, EcorePackage.Literals.EOBJECT, Diagnostic.SYNTAX_DIAGNOSTIC);
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
      final BlangModel model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
