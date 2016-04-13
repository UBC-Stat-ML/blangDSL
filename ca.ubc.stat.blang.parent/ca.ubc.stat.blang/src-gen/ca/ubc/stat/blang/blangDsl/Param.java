/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.Param#getName <em>Name</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.Param#getDistr <em>Distr</em>}</li>
 * </ul>
 *
 * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getParam_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.Param#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Distr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Distr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Distr</em>' containment reference.
   * @see #setDistr(JvmTypeReference)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getParam_Distr()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getDistr();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.Param#getDistr <em>Distr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Distr</em>' containment reference.
   * @see #getDistr()
   * @generated
   */
  void setDistr(JvmTypeReference value);

} // Param
