/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl.impl;

import ca.ubc.stat.blang.blangDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlangDslFactoryImpl extends EFactoryImpl implements BlangDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BlangDslFactory init()
  {
    try
    {
      BlangDslFactory theBlangDslFactory = (BlangDslFactory)EPackage.Registry.INSTANCE.getEFactory(BlangDslPackage.eNS_URI);
      if (theBlangDslFactory != null)
      {
        return theBlangDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BlangDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlangDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case BlangDslPackage.BLANG_MODEL: return createBlangModel();
      case BlangDslPackage.VARS: return createVars();
      case BlangDslPackage.VAR_DECL: return createVarDecl();
      case BlangDslPackage.PARAM: return createParam();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlangModel createBlangModel()
  {
    BlangModelImpl blangModel = new BlangModelImpl();
    return blangModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vars createVars()
  {
    VarsImpl vars = new VarsImpl();
    return vars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDecl createVarDecl()
  {
    VarDeclImpl varDecl = new VarDeclImpl();
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Param createParam()
  {
    ParamImpl param = new ParamImpl();
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlangDslPackage getBlangDslPackage()
  {
    return (BlangDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BlangDslPackage getPackage()
  {
    return BlangDslPackage.eINSTANCE;
  }

} //BlangDslFactoryImpl
