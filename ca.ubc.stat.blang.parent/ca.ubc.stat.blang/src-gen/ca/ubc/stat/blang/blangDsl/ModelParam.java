/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.ModelParam#getName <em>Name</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.ModelParam#getDeps <em>Deps</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.ModelParam#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getModelParam()
 * @model
 * @generated
 */
public interface ModelParam extends ModelComponent
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
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getModelParam_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.ModelParam#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Deps</b></em>' containment reference list.
   * The list contents are of type {@link ca.ubc.stat.blang.blangDsl.Dependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deps</em>' containment reference list.
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getModelParam_Deps()
   * @model containment="true"
   * @generated
   */
  EList<Dependency> getDeps();

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Distribution)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getModelParam_Right()
   * @model containment="true"
   * @generated
   */
  Distribution getRight();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.ModelParam#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Distribution value);

} // ModelParam