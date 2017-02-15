package ca.ubc.stat.blang.scoping

import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures
import java.util.List
import blang.core.BlangExtensions
import java.util.ArrayList

class BlangImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
  
  override List<Class<?>> getExtensionClasses() {
    val result = new ArrayList
    result.addAll(super.extensionClasses)
    result.add(BlangExtensions)
    return result
  }
  
}