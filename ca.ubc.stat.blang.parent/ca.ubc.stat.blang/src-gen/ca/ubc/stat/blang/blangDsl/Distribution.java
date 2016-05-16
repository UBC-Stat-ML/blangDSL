/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.Distribution#getClazz <em>Clazz</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.Distribution#getParam <em>Param</em>}</li>
 * </ul>
 *
 * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getDistribution()
 * @model
 * @generated
 */
public interface Distribution extends EObject
{
  /**
   * Returns the value of the '<em><b>Clazz</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clazz</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clazz</em>' containment reference.
   * @see #setClazz(JvmTypeReference)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getDistribution_Clazz()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getClazz();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.Distribution#getClazz <em>Clazz</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clazz</em>' containment reference.
   * @see #getClazz()
   * @generated
   */
  void setClazz(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference list.
   * The list contents are of type {@link ca.ubc.stat.blang.blangDsl.Param}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference list.
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getDistribution_Param()
   * @model containment="true"
   * @generated
   */
  EList<Param> getParam();

} // Distribution
