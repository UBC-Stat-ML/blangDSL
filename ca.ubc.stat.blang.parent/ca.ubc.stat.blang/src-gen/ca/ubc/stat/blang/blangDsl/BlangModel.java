/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blang Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.BlangModel#getName <em>Name</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.BlangModel#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.BlangModel#getVars <em>Vars</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.BlangModel#getLaws <em>Laws</em>}</li>
 * </ul>
 *
 * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getBlangModel()
 * @model
 * @generated
 */
public interface BlangModel extends EObject
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
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getBlangModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.BlangModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Section</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Section</em>' containment reference.
   * @see #setImportSection(XImportSection)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getBlangModel_ImportSection()
   * @model containment="true"
   * @generated
   */
  XImportSection getImportSection();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.BlangModel#getImportSection <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Section</em>' containment reference.
   * @see #getImportSection()
   * @generated
   */
  void setImportSection(XImportSection value);

  /**
   * Returns the value of the '<em><b>Vars</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vars</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vars</em>' containment reference.
   * @see #setVars(Vars)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getBlangModel_Vars()
   * @model containment="true"
   * @generated
   */
  Vars getVars();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.BlangModel#getVars <em>Vars</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vars</em>' containment reference.
   * @see #getVars()
   * @generated
   */
  void setVars(Vars value);

  /**
   * Returns the value of the '<em><b>Laws</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Laws</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Laws</em>' attribute.
   * @see #setLaws(String)
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#getBlangModel_Laws()
   * @model
   * @generated
   */
  String getLaws();

  /**
   * Sets the value of the '{@link ca.ubc.stat.blang.blangDsl.BlangModel#getLaws <em>Laws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Laws</em>' attribute.
   * @see #getLaws()
   * @generated
   */
  void setLaws(String value);

} // BlangModel
