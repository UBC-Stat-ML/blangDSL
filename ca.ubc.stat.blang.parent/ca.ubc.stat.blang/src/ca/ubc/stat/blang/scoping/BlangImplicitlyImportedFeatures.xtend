package ca.ubc.stat.blang.scoping

import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures
import java.util.List
import blang.core.BlangExtensions

class BlangImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
  
  override List<Class<?>> getExtensionClasses() {
    val result = super.extensionClasses
    result.add(BlangExtensions)
    return result
  }
  
}