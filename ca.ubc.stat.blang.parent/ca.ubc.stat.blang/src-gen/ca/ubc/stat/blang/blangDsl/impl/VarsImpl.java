/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl.impl;

import ca.ubc.stat.blang.blangDsl.BlangDslPackage;
import ca.ubc.stat.blang.blangDsl.Const;
import ca.ubc.stat.blang.blangDsl.ParamVar;
import ca.ubc.stat.blang.blangDsl.Random;
import ca.ubc.stat.blang.blangDsl.Vars;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vars</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.VarsImpl#getRandomVars <em>Random Vars</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.VarsImpl#getParamVars <em>Param Vars</em>}</li>
 *   <li>{@link ca.ubc.stat.blang.blangDsl.impl.VarsImpl#getConsts <em>Consts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarsImpl extends MinimalEObjectImpl.Container implements Vars
{
  /**
   * The cached value of the '{@link #getRandomVars() <em>Random Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRandomVars()
   * @generated
   * @ordered
   */
  protected EList<Random> randomVars;

  /**
   * The cached value of the '{@link #getParamVars() <em>Param Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamVars()
   * @generated
   * @ordered
   */
  protected EList<ParamVar> paramVars;

  /**
   * The cached value of the '{@link #getConsts() <em>Consts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConsts()
   * @generated
   * @ordered
   */
  protected EList<Const> consts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VarsImpl()
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
    return BlangDslPackage.Literals.VARS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Random> getRandomVars()
  {
    if (randomVars == null)
    {
      randomVars = new EObjectContainmentEList<Random>(Random.class, this, BlangDslPackage.VARS__RANDOM_VARS);
    }
    return randomVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParamVar> getParamVars()
  {
    if (paramVars == null)
    {
      paramVars = new EObjectContainmentEList<ParamVar>(ParamVar.class, this, BlangDslPackage.VARS__PARAM_VARS);
    }
    return paramVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Const> getConsts()
  {
    if (consts == null)
    {
      consts = new EObjectContainmentEList<Const>(Const.class, this, BlangDslPackage.VARS__CONSTS);
    }
    return consts;
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
      case BlangDslPackage.VARS__RANDOM_VARS:
        return ((InternalEList<?>)getRandomVars()).basicRemove(otherEnd, msgs);
      case BlangDslPackage.VARS__PARAM_VARS:
        return ((InternalEList<?>)getParamVars()).basicRemove(otherEnd, msgs);
      case BlangDslPackage.VARS__CONSTS:
        return ((InternalEList<?>)getConsts()).basicRemove(otherEnd, msgs);
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
      case BlangDslPackage.VARS__RANDOM_VARS:
        return getRandomVars();
      case BlangDslPackage.VARS__PARAM_VARS:
        return getParamVars();
      case BlangDslPackage.VARS__CONSTS:
        return getConsts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case BlangDslPackage.VARS__RANDOM_VARS:
        getRandomVars().clear();
        getRandomVars().addAll((Collection<? extends Random>)newValue);
        return;
      case BlangDslPackage.VARS__PARAM_VARS:
        getParamVars().clear();
        getParamVars().addAll((Collection<? extends ParamVar>)newValue);
        return;
      case BlangDslPackage.VARS__CONSTS:
        getConsts().clear();
        getConsts().addAll((Collection<? extends Const>)newValue);
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
      case BlangDslPackage.VARS__RANDOM_VARS:
        getRandomVars().clear();
        return;
      case BlangDslPackage.VARS__PARAM_VARS:
        getParamVars().clear();
        return;
      case BlangDslPackage.VARS__CONSTS:
        getConsts().clear();
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
      case BlangDslPackage.VARS__RANDOM_VARS:
        return randomVars != null && !randomVars.isEmpty();
      case BlangDslPackage.VARS__PARAM_VARS:
        return paramVars != null && !paramVars.isEmpty();
      case BlangDslPackage.VARS__CONSTS:
        return consts != null && !consts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VarsImpl
