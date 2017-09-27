package ca.ubc.stat.blang.scoping

import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures
import java.util.List
import blang.core.BlangExtensions
import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmType
import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.TypeReferences

class BlangImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
  
  @Inject
  private TypeReferences typeReferences
  
    /**
   * @return all JvmTypes who's static methods are put on the scope of their first argument type (i.e. extension methods).
   */
  override List<JvmType> getExtensionClasses(Resource context) {
    val List<Class<?>> classes = getExtensionClasses()
    val List<JvmType> result = getTypes(classes, context)
    result.add(typeReferences.findDeclaredType("xlinear.MatrixExtensions", context))
    result.add(typeReferences.findDeclaredType("blang.types.ExtensionUtils", context))
    return result
  }
  
  override List<Class<?>> getExtensionClasses() {
    val List<Class<?>> result = new ArrayList
    result.addAll(super.extensionClasses)
    result.add(BlangExtensions)
    return result
  }
  
  override List<JvmType> getStaticImportClasses(Resource context) {
    val List<Class<?>> classes = getStaticImportClasses()
    val List<JvmType> result = getTypes(classes, context)
    result.add(typeReferences.findDeclaredType("xlinear.MatrixOperations", context))
    result.add(typeReferences.findDeclaredType("bayonet.math.SpecialFunctions", context))
    result.add(typeReferences.findDeclaredType("org.apache.commons.math3.util.CombinatoricsUtils", context))
    result.add(typeReferences.findDeclaredType("blang.types.StaticUtils", context))
    return result
  }
  
  override List<Class<?>> getStaticImportClasses() {
    val result = new ArrayList
    result.addAll(super.extensionClasses)
    result.add(Math)
    return result
  }
  
}