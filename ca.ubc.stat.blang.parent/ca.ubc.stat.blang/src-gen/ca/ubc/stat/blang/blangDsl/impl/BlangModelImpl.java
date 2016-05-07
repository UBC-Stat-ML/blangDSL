/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl.impl;

import ca.ubc.stat.blang.blangDsl.BlangDslPackage;
import ca.ubc.stat.blang.blangDsl.BlangModel;
import ca.ubc.stat.blang.blangDsl.Vars;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blang Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.BlangModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.BlangModelImpl#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.BlangModelImpl#getVars <em>Vars</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.BlangModelImpl#getLaws <em>Laws</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlangModelImpl extends MinimalEObjectImpl.Container implements BlangModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getImportSection() <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportSection()
   * @generated
   * @ordered
   */
  protected XImportSection importSection;

  /**
   * The cached value of the '{@link #getVars() <em>Vars</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVars()
   * @generated
   * @ordered
   */
  protected Vars vars;

  /**
   * The default value of the '{@link #getLaws() <em>Laws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLaws()
   * @generated
   * @ordered
   */
  protected static final String LAWS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLaws() <em>Laws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLaws()
   * @generated
   * @ordered
   */
  protected String laws = LAWS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BlangModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return BlangDslPackage.Literals.BLANG_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XImportSection getImportSection()
  {
    return importSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImportSection(XImportSection newImportSection, NotificationChain msgs)
  {
    XImportSection oldImportSection = importSection;
    importSection = newImportSection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__IMPORT_SECTION, oldImportSection, newImportSection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportSection(XImportSection newImportSection)
  {
    if (newImportSection != importSection)
    {
      NotificationChain msgs = null;
      if (importSection != null)
        msgs = ((InternalEObject)importSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BlangDslPackage.BLANG_MODEL__IMPORT_SECTION, null, msgs);
      if (newImportSection != null)
        msgs = ((InternalEObject)newImportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BlangDslPackage.BLANG_MODEL__IMPORT_SECTION, null, msgs);
      msgs = basicSetImportSection(newImportSection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__IMPORT_SECTION, newImportSection, newImportSection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vars getVars()
  {
    return vars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVars(Vars newVars, NotificationChain msgs)
  {
    Vars oldVars = vars;
    vars = newVars;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__VARS, oldVars, newVars);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVars(Vars newVars)
  {
    if (newVars != vars)
    {
      NotificationChain msgs = null;
      if (vars != null)
        msgs = ((InternalEObject)vars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BlangDslPackage.BLANG_MODEL__VARS, null, msgs);
      if (newVars != null)
        msgs = ((InternalEObject)newVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BlangDslPackage.BLANG_MODEL__VARS, null, msgs);
      msgs = basicSetVars(newVars, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__VARS, newVars, newVars));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLaws()
  {
    return laws;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLaws(String newLaws)
  {
    String oldLaws = laws;
    laws = newLaws;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BlangDslPackage.BLANG_MODEL__LAWS, oldLaws, laws));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case BlangDslPackage.BLANG_MODEL__IMPORT_SECTION:
        return basicSetImportSection(null, msgs);
      case BlangDslPackage.BLANG_MODEL__VARS:
        return basicSetVars(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case BlangDslPackage.BLANG_MODEL__NAME:
        return getName();
      case BlangDslPackage.BLANG_MODEL__IMPORT_SECTION:
        return getImportSection();
      case BlangDslPackage.BLANG_MODEL__VARS:
        return getVars();
      case BlangDslPackage.BLANG_MODEL__LAWS:
        return getLaws();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case BlangDslPackage.BLANG_MODEL__NAME:
        setName((String)newValue);
        return;
      case BlangDslPackage.BLANG_MODEL__IMPORT_SECTION:
        setImportSection((XImportSection)newValue);
        return;
      case BlangDslPackage.BLANG_MODEL__VARS:
        setVars((Vars)newValue);
        return;
      case BlangDslPackage.BLANG_MODEL__LAWS:
        setLaws((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case BlangDslPackage.BLANG_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case BlangDslPackage.BLANG_MODEL__IMPORT_SECTION:
        setImportSection((XImportSection)null);
        return;
      case BlangDslPackage.BLANG_MODEL__VARS:
        setVars((Vars)null);
        return;
      case BlangDslPackage.BLANG_MODEL__LAWS:
        setLaws(LAWS_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case BlangDslPackage.BLANG_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case BlangDslPackage.BLANG_MODEL__IMPORT_SECTION:
        return importSection != null;
      case BlangDslPackage.BLANG_MODEL__VARS:
        return vars != null;
      case BlangDslPackage.BLANG_MODEL__LAWS:
        return LAWS_EDEFAULT == null ? laws != null : !LAWS_EDEFAULT.equals(laws);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", laws: ");
    result.append(laws);
    result.append(')');
    return result.toString();
  }

} //BlangModelImpl
