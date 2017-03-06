package ca.ubc.stat.blang.tests

import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import java.io.File
import com.google.common.io.Files
import com.google.common.base.Charsets
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result
import org.junit.Assert

class TestSupport {
  
  @Inject CompilationTestHelper helper 
  
  var static firstTime = true
  
  def void check(CharSequence source) {
    // try to find the reference, if not, empty string
    val String key = ("" + source.toString.hashCode + ".java").replace("-", "")
    val String ref = reference(key)
    // save the actual
    val String[] actualCallBack = newArrayOfSize(1)
    helper.compile(source) [Result r | 
      actualCallBack.set(0, r.getSingleGeneratedCode())
    ]
    val actual = actualCallBack.get(0)
    val boolean generated = actual != null
    if (generated) {
      saveActual(key, actual)
    }
    Assert.assertEquals(ref, actual)
    Assert.assertTrue("Nothing was generated but the expectation was :\n"+ref, generated)
  }
  
  def saveActual(String key, String value) {
    val File actuals = getActuals()
    if (!actuals.exists) {
      actuals.mkdir
    }
    val File actual = new File(actuals, key)
    Files.write(value, actual, Charsets.UTF_8)
  }
  
  def getActuals() {
    val File actuals = new File(ACTUALS_FOLDER_NAME)
    if (firstTime && actuals.exists) {
      for (File f : actuals.listFiles) {
        f.delete
      }
    }
    firstTime = false
    return actuals
  }
  
  def reference(String key) {
    val File references = new File(REFERENCES_FOLDER_NAME)
    if (!references.exists) {
      return ""
    }
    val File reference = new File(references, key)
    if (!reference.exists) {
      return ""
    }
    return Files.toString(reference, Charsets.UTF_8);
  }
  
  val static REFERENCES_FOLDER_NAME = "references"
  val static ACTUALS_FOLDER_NAME = "actuals"
}