/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.blangDsl.impl;

import ca.ubc.stat.blang.blangDsl.BlangDslFactory;
import ca.ubc.stat.blang.blangDsl.BlangDslPackage;
import ca.ubc.stat.blang.blangDsl.BlangModel;
import ca.ubc.stat.blang.blangDsl.ConstParam;
import ca.ubc.stat.blang.blangDsl.Dependency;
import ca.ubc.stat.blang.blangDsl.Distribution;
import ca.ubc.stat.blang.blangDsl.Laws;
import ca.ubc.stat.blang.blangDsl.LazyParam;
import ca.ubc.stat.blang.blangDsl.ModelComponent;
import ca.ubc.stat.blang.blangDsl.Param;
import ca.ubc.stat.blang.blangDsl.ParamVar;
import ca.ubc.stat.blang.blangDsl.Random;
import ca.ubc.stat.blang.blangDsl.VarDecl;
import ca.ubc.stat.blang.blangDsl.Vars;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlangDslPackageImpl extends EPackageImpl implements BlangDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blangModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass randomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramVarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lawsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass distributionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constParamEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lazyParamEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see ca.ubc.stat.blang.blangDsl.BlangDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BlangDslPackageImpl()
  {
    super(eNS_URI, BlangDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link BlangDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BlangDslPackage init()
  {
    if (isInited) return (BlangDslPackage)EPackage.Registry.INSTANCE.getEPackage(BlangDslPackage.eNS_URI);

    // Obtain or create and register package
    BlangDslPackageImpl theBlangDslPackage = (BlangDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BlangDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BlangDslPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();
    XtypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theBlangDslPackage.createPackageContents();

    // Initialize created meta-data
    theBlangDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBlangDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BlangDslPackage.eNS_URI, theBlangDslPackage);
    return theBlangDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlangModel()
  {
    return blangModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBlangModel_Name()
  {
    return (EAttribute)blangModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlangModel_ImportSection()
  {
    return (EReference)blangModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlangModel_Vars()
  {
    return (EReference)blangModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlangModel_Laws()
  {
    return (EReference)blangModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVars()
  {
    return varsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVars_RandomVars()
  {
    return (EReference)varsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVars_ParamVars()
  {
    return (EReference)varsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRandom()
  {
    return randomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRandom_Type()
  {
    return (EReference)randomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRandom_Name()
  {
    return (EAttribute)randomEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParamVar()
  {
    return paramVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParamVar_Type()
  {
    return (EReference)paramVarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParamVar_Name()
  {
    return (EAttribute)paramVarEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarDecl()
  {
    return varDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarDecl_Type()
  {
    return (EReference)varDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarDecl_Name()
  {
    return (EAttribute)varDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarDecl_Right()
  {
    return (EReference)varDeclEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLaws()
  {
    return lawsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLaws_ModelComponents()
  {
    return (EReference)lawsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelComponent()
  {
    return modelComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelComponent_Name()
  {
    return (EAttribute)modelComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelComponent_Deps()
  {
    return (EReference)modelComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelComponent_Right()
  {
    return (EReference)modelComponentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependency()
  {
    return dependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependency_Type()
  {
    return (EReference)dependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependency_Name()
  {
    return (EAttribute)dependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependency_Init()
  {
    return (EAttribute)dependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDistribution()
  {
    return distributionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDistribution_Clazz()
  {
    return (EReference)distributionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDistribution_Param()
  {
    return (EReference)distributionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParam()
  {
    return paramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstParam()
  {
    return constParamEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstParam_Id()
  {
    return (EAttribute)constParamEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLazyParam()
  {
    return lazyParamEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLazyParam_Expr()
  {
    return (EReference)lazyParamEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlangDslFactory getBlangDslFactory()
  {
    return (BlangDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    blangModelEClass = createEClass(BLANG_MODEL);
    createEAttribute(blangModelEClass, BLANG_MODEL__NAME);
    createEReference(blangModelEClass, BLANG_MODEL__IMPORT_SECTION);
    createEReference(blangModelEClass, BLANG_MODEL__VARS);
    createEReference(blangModelEClass, BLANG_MODEL__LAWS);

    varsEClass = createEClass(VARS);
    createEReference(varsEClass, VARS__RANDOM_VARS);
    createEReference(varsEClass, VARS__PARAM_VARS);

    randomEClass = createEClass(RANDOM);
    createEReference(randomEClass, RANDOM__TYPE);
    createEAttribute(randomEClass, RANDOM__NAME);

    paramVarEClass = createEClass(PARAM_VAR);
    createEReference(paramVarEClass, PARAM_VAR__TYPE);
    createEAttribute(paramVarEClass, PARAM_VAR__NAME);

    varDeclEClass = createEClass(VAR_DECL);
    createEReference(varDeclEClass, VAR_DECL__TYPE);
    createEAttribute(varDeclEClass, VAR_DECL__NAME);
    createEReference(varDeclEClass, VAR_DECL__RIGHT);

    lawsEClass = createEClass(LAWS);
    createEReference(lawsEClass, LAWS__MODEL_COMPONENTS);

    modelComponentEClass = createEClass(MODEL_COMPONENT);
    createEAttribute(modelComponentEClass, MODEL_COMPONENT__NAME);
    createEReference(modelComponentEClass, MODEL_COMPONENT__DEPS);
    createEReference(modelComponentEClass, MODEL_COMPONENT__RIGHT);

    dependencyEClass = createEClass(DEPENDENCY);
    createEReference(dependencyEClass, DEPENDENCY__TYPE);
    createEAttribute(dependencyEClass, DEPENDENCY__NAME);
    createEAttribute(dependencyEClass, DEPENDENCY__INIT);

    distributionEClass = createEClass(DISTRIBUTION);
    createEReference(distributionEClass, DISTRIBUTION__CLAZZ);
    createEReference(distributionEClass, DISTRIBUTION__PARAM);

    paramEClass = createEClass(PARAM);

    constParamEClass = createEClass(CONST_PARAM);
    createEAttribute(constParamEClass, CONST_PARAM__ID);

    lazyParamEClass = createEClass(LAZY_PARAM);
    createEReference(lazyParamEClass, LAZY_PARAM__EXPR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    constParamEClass.getESuperTypes().add(this.getParam());
    lazyParamEClass.getESuperTypes().add(this.getParam());

    // Initialize classes and features; add operations and parameters
    initEClass(blangModelEClass, BlangModel.class, "BlangModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBlangModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, BlangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlangModel_ImportSection(), theXtypePackage.getXImportSection(), null, "importSection", null, 0, 1, BlangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlangModel_Vars(), this.getVars(), null, "vars", null, 0, 1, BlangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlangModel_Laws(), this.getLaws(), null, "laws", null, 0, 1, BlangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varsEClass, Vars.class, "Vars", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVars_RandomVars(), this.getRandom(), null, "randomVars", null, 0, -1, Vars.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVars_ParamVars(), this.getParamVar(), null, "paramVars", null, 0, -1, Vars.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(randomEClass, Random.class, "Random", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRandom_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, Random.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRandom_Name(), ecorePackage.getEString(), "name", null, 0, 1, Random.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramVarEClass, ParamVar.class, "ParamVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParamVar_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, ParamVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParamVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParamVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varDeclEClass, VarDecl.class, "VarDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVarDecl_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, VarDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVarDecl_Name(), ecorePackage.getEString(), "name", null, 0, 1, VarDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarDecl_Right(), theXbasePackage.getXExpression(), null, "right", null, 0, 1, VarDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lawsEClass, Laws.class, "Laws", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLaws_ModelComponents(), this.getModelComponent(), null, "modelComponents", null, 0, -1, Laws.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelComponentEClass, ModelComponent.class, "ModelComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelComponent_Deps(), this.getDependency(), null, "deps", null, 0, -1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelComponent_Right(), this.getDistribution(), null, "right", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dependencyEClass, Dependency.class, "Dependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDependency_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDependency_Name(), ecorePackage.getEString(), "name", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDependency_Init(), ecorePackage.getEString(), "init", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(distributionEClass, Distribution.class, "Distribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDistribution_Clazz(), theTypesPackage.getJvmTypeReference(), null, "clazz", null, 0, 1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDistribution_Param(), this.getParam(), null, "param", null, 0, -1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constParamEClass, ConstParam.class, "ConstParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstParam_Id(), ecorePackage.getEString(), "id", null, 0, 1, ConstParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lazyParamEClass, LazyParam.class, "LazyParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLazyParam_Expr(), theXbasePackage.getXExpression(), null, "expr", null, 0, 1, LazyParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //BlangDslPackageImpl
