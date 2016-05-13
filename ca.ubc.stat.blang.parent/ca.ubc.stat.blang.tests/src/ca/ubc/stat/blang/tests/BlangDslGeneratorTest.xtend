package ca.ubc.stat.blang.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.TemporaryFolder

@RunWith(XtextRunner)
@InjectWith(BlangDslInjectorProvider)
class BlangDslGeneratorTest {
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper
	
	@Test
	def void randomParams() {
		'''
			model {
				random Real mu
				random Real y
			}
		'''.assertCompilesTo(
		'''
		import blang.core.Model;
		import blang.core.ModelComponent;
		import blang.prototype.Real;
		import java.util.Collection;
		
		@SuppressWarnings("all")
		public class MyFile implements Model {
		  public final Real mu;
		  
		  public final Real y;
		  
		  public Collection<ModelComponent> components() {
		    java.util.ArrayList<blang.core.ModelComponent> components = new java.util.ArrayList();
		    
		    
		    
		    return components;
		  }
		}
		'''	
		)
	}
	
}