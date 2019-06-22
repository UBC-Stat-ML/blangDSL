package ca.ubc.stat.blang.validation

import org.eclipse.xtext.validation.Check
import ca.ubc.stat.blang.blangDsl.InstantiatedDistribution
import ca.ubc.stat.blang.jvmmodel.SingleBlangModelInferrer
import ca.ubc.stat.blang.blangDsl.BlangDist
import ca.ubc.stat.blang.blangDsl.BlangDslPackage

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class BlangDslValidator extends AbstractBlangDslValidator {
  
  @Check
  def void checkNameStartsWithCapital(InstantiatedDistribution distribution) {
    if (!(distribution.typeSpec instanceof BlangDist)) { return ; }
    val typeSpec = distribution.typeSpec as BlangDist
    val expectedNumberOfArgs = SingleBlangModelInferrer::blangConstructorParameters(typeSpec).filter[param].size()
    val actual = distribution.arguments.size
    if (expectedNumberOfArgs !== actual)
      error("Incorrect number of arguments: " + actual + " provided but " + typeSpec.distributionType.name + " expects " + expectedNumberOfArgs, BlangDslPackage.Literals::INSTANTIATED_DISTRIBUTION__ARGUMENTS)
  }

}
