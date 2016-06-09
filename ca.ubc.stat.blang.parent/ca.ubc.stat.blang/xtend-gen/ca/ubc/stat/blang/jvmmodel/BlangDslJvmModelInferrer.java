/**
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.jvmmodel;

import blang.core.Model;
import ca.ubc.stat.blang.blangDsl.BlangModel;
import ca.ubc.stat.blang.blangDsl.ConstParam;
import ca.ubc.stat.blang.blangDsl.Dependency;
import ca.ubc.stat.blang.blangDsl.Distribution;
import ca.ubc.stat.blang.blangDsl.Laws;
import ca.ubc.stat.blang.blangDsl.LazyParam;
import ca.ubc.stat.blang.blangDsl.ModelComponent;
import ca.ubc.stat.blang.blangDsl.Param;
import ca.ubc.stat.blang.blangDsl.Random;
import ca.ubc.stat.blang.blangDsl.Vars;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class BlangDslJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  /**
   * The dispatch method {@code infer} is called for each instance of the
   * given element's type that is contained in a resource.
   * 
   * @param element
   *            the model to create one or more
   *            {@link JvmDeclaredType declared
   *            types} from.
   * @param acceptor
   *            each created
   *            {@link JvmDeclaredType type}
   *            without a container should be passed to the acceptor in order
   *            get attached to the current resource. The acceptor's
   *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
   *            accept(..)} method takes the constructed empty type for the
   *            pre-indexing phase. This one is further initialized in the
   *            indexing phase using the closure you pass to the returned
   *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
   *            initializeLater(..)}.
   * @param isPreIndexingPhase
   *            whether the method is called in a pre-indexing phase, i.e.
   *            when the global index is not yet fully updated. You must not
   *            rely on linking using the index if isPreIndexingPhase is
   *            <code>true</code>.
   */
  protected void _infer(final BlangModel model, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    Resource _eResource = model.eResource();
    URI _uRI = _eResource.getURI();
    URI _trimFileExtension = _uRI.trimFileExtension();
    final String className = _trimFileExtension.lastSegment();
    JvmGenericType _class = this._jvmTypesBuilder.toClass(model, className);
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      String _name = model.getName();
      boolean _notEquals = (!Objects.equal(_name, null));
      if (_notEquals) {
        String _name_1 = model.getName();
        it.setPackageName(_name_1);
      }
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Model.class);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      Vars _vars = model.getVars();
      boolean _notEquals_1 = (!Objects.equal(_vars, null));
      if (_notEquals_1) {
        Vars _vars_1 = model.getVars();
        EList<Random> _randomVars = _vars_1.getRandomVars();
        for (final Random varDecl : _randomVars) {
          EList<JvmMember> _members = it.getMembers();
          String _name_2 = varDecl.getName();
          JvmTypeReference _type = varDecl.getType();
          final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
            it_1.setVisibility(JvmVisibility.PUBLIC);
            it_1.setFinal(true);
          };
          JvmField _field = this._jvmTypesBuilder.toField(varDecl, _name_2, _type, _function_1);
          this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
        }
      }
      boolean _and = false;
      Vars _vars_2 = model.getVars();
      EList<Random> _randomVars_1 = null;
      if (_vars_2!=null) {
        _randomVars_1=_vars_2.getRandomVars();
      }
      boolean _notEquals_2 = (!Objects.equal(_randomVars_1, null));
      if (!_notEquals_2) {
        _and = false;
      } else {
        Vars _vars_3 = model.getVars();
        EList<Random> _randomVars_2 = _vars_3.getRandomVars();
        boolean _isEmpty = _randomVars_2.isEmpty();
        boolean _not = (!_isEmpty);
        _and = _not;
      }
      if (_and) {
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmConstructor> _function_2 = (JvmConstructor it_1) -> {
          it_1.setVisibility(JvmVisibility.PUBLIC);
          Vars _vars_4 = model.getVars();
          EList<Random> _randomVars_3 = null;
          if (_vars_4!=null) {
            _randomVars_3=_vars_4.getRandomVars();
          }
          for (final Random varDecl_1 : _randomVars_3) {
            EList<JvmFormalParameter> _parameters = it_1.getParameters();
            String _name_3 = varDecl_1.getName();
            JvmTypeReference _type_1 = varDecl_1.getType();
            JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(varDecl_1, _name_3, _type_1);
            this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          }
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              {
                Vars _vars = model.getVars();
                EList<Random> _randomVars = null;
                if (_vars!=null) {
                  _randomVars=_vars.getRandomVars();
                }
                for(final Random varDecl : _randomVars) {
                  _builder.append("this.");
                  String _name = varDecl.getName();
                  _builder.append(_name, "");
                  _builder.append(" = ");
                  String _name_1 = varDecl.getName();
                  _builder.append(_name_1, "");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(model, _function_2);
        this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_1, _constructor);
      }
      boolean _and_1 = false;
      Laws _laws = model.getLaws();
      EList<ModelComponent> _modelComponents = null;
      if (_laws!=null) {
        _modelComponents=_laws.getModelComponents();
      }
      boolean _notEquals_3 = (!Objects.equal(_modelComponents, null));
      if (!_notEquals_3) {
        _and_1 = false;
      } else {
        Laws _laws_1 = model.getLaws();
        EList<ModelComponent> _modelComponents_1 = _laws_1.getModelComponents();
        boolean _isEmpty_1 = _modelComponents_1.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _and_1 = _not_1;
      }
      if (_and_1) {
        EList<JvmMember> _members_2 = it.getMembers();
        JvmTypeReference _typeRef_1 = this._typeReferenceBuilder.typeRef(blang.core.ModelComponent.class);
        JvmTypeReference _typeRef_2 = this._typeReferenceBuilder.typeRef(Collection.class, _typeRef_1);
        final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
          it_1.setVisibility(JvmVisibility.PUBLIC);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              JvmTypeReference _typeRef = BlangDslJvmModelInferrer.this._typeReferenceBuilder.typeRef(blang.core.ModelComponent.class);
              JvmTypeReference _typeRef_1 = BlangDslJvmModelInferrer.this._typeReferenceBuilder.typeRef(ArrayList.class, _typeRef);
              _builder.append(_typeRef_1, "");
              _builder.append(" components = new ");
              JvmTypeReference _typeRef_2 = BlangDslJvmModelInferrer.this._typeReferenceBuilder.typeRef(ArrayList.class);
              _builder.append(_typeRef_2, "");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
              {
                Laws _laws = model.getLaws();
                EList<ModelComponent> _modelComponents = _laws.getModelComponents();
                int _size = _modelComponents.size();
                ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                for(final Integer i : _doubleDotLessThan) {
                  _builder.append("components.add(");
                  Laws _laws_1 = model.getLaws();
                  EList<ModelComponent> _modelComponents_1 = _laws_1.getModelComponents();
                  ModelComponent _get = _modelComponents_1.get((i).intValue());
                  CharSequence _generateModelComponentInit = BlangDslJvmModelInferrer.this.generateModelComponentInit(_get, (i).intValue());
                  _builder.append(_generateModelComponentInit, "");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.newLine();
              _builder.append("return components;");
              _builder.newLine();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(model, "components", _typeRef_2, _function_3);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
        Laws _laws_2 = model.getLaws();
        EList<ModelComponent> _modelComponents_2 = _laws_2.getModelComponents();
        int _size = _modelComponents_2.size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
        for (final Integer componentCounter : _doubleDotLessThan) {
          {
            Laws _laws_3 = model.getLaws();
            EList<ModelComponent> _modelComponents_3 = _laws_3.getModelComponents();
            ModelComponent component = _modelComponents_3.get((componentCounter).intValue());
            Distribution _right = component.getRight();
            EList<Param> _param = _right.getParam();
            int _size_1 = _param.size();
            ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
            for (final Integer paramCounter : _doubleDotLessThan_1) {
              EList<JvmMember> _members_3 = it.getMembers();
              JvmGenericType _generateModelComponentParamSupplier = this.generateModelComponentParamSupplier(component, (componentCounter).intValue(), (paramCounter).intValue());
              this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_3, _generateModelComponentParamSupplier);
            }
          }
        }
      }
    };
    acceptor.<JvmGenericType>accept(_class, _function);
  }
  
  public CharSequence generateModelComponentInit(final ModelComponent component, final int modelCounter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    Distribution _right = component.getRight();
    JvmTypeReference _clazz = _right.getClazz();
    JvmType _type = _clazz.getType();
    String _identifier = _type.getIdentifier();
    _builder.append(_identifier, "");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    String _name = component.getName();
    _builder.append(_name, "    ");
    {
      Distribution _right_1 = component.getRight();
      EList<Param> _param = _right_1.getParam();
      int _size = _param.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("new $Generated_SupplierSubModel");
        _builder.append(modelCounter, "    ");
        _builder.append("Param");
        _builder.append(i, "    ");
        _builder.append("(");
        {
          EList<Dependency> _deps = component.getDeps();
          int _size_1 = _deps.size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
          boolean _hasElements = false;
          for(final Integer j : _doubleDotLessThan_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "    ");
            }
            EList<Dependency> _deps_1 = component.getDeps();
            Dependency _get = _deps_1.get((j).intValue());
            String _init = _get.getInit();
            _builder.append(_init, "    ");
          }
        }
        _builder.append(")");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public JvmGenericType generateModelComponentParamSupplier(final ModelComponent component, final int modelCounter, final int paramCounter) {
    try {
      JvmGenericType _xblockexpression = null;
      {
        Distribution _right = component.getRight();
        JvmTypeReference _clazz = _right.getClazz();
        final JvmType dist = _clazz.getType();
        String _identifier = dist.getIdentifier();
        final Class<?> distClass = Class.forName(_identifier);
        final Constructor<?>[] distCtors = distClass.getConstructors();
        Constructor<?> _get = null;
        if (distCtors!=null) {
          _get=distCtors[0];
        }
        final Constructor<?> distCtor = _get;
        Type[] _genericParameterTypes = distCtor.getGenericParameterTypes();
        final Type paramType = _genericParameterTypes[(paramCounter + 1)];
        final Type[] paramTypeArgs = ((ParameterizedType) paramType).getActualTypeArguments();
        Distribution _right_1 = component.getRight();
        EList<Param> _param = _right_1.getParam();
        final Param param = _param.get(paramCounter);
        Type _get_1 = paramTypeArgs[0];
        String _typeName = _get_1.getTypeName();
        JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(_typeName);
        final JvmTypeReference paramSupplierTypeRef = this._typeReferenceBuilder.typeRef(Supplier.class, _typeRef);
        final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, paramSupplierTypeRef);
          it.setStatic(true);
          EList<Dependency> _deps = component.getDeps();
          for (final Dependency dep : _deps) {
            EList<JvmMember> _members = it.getMembers();
            String _name = dep.getName();
            JvmTypeReference _type = dep.getType();
            final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
              it_1.setFinal(true);
            };
            JvmField _field = this._jvmTypesBuilder.toField(param, _name, _type, _function_1);
            this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
          }
          EList<JvmMember> _members_1 = it.getMembers();
          final Procedure1<JvmConstructor> _function_2 = (JvmConstructor it_1) -> {
            it_1.setVisibility(JvmVisibility.PUBLIC);
            EList<Dependency> _deps_1 = component.getDeps();
            for (final Dependency dep_1 : _deps_1) {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              String _name_1 = dep_1.getName();
              JvmTypeReference _type_1 = dep_1.getType();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(param, _name_1, _type_1);
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            }
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                {
                  EList<Dependency> _deps = component.getDeps();
                  for(final Dependency dep : _deps) {
                    _builder.append("this.");
                    String _name = dep.getName();
                    _builder.append(_name, "");
                    _builder.append(" = ");
                    String _name_1 = dep.getName();
                    _builder.append(_name_1, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            };
            this._jvmTypesBuilder.setBody(it_1, _client);
          };
          JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(param, _function_2);
          this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_1, _constructor);
          EList<JvmMember> _members_2 = it.getMembers();
          Type _get_2 = paramTypeArgs[0];
          String _typeName_1 = _get_2.getTypeName();
          JvmTypeReference _typeRef_1 = this._typeReferenceBuilder.typeRef(_typeName_1);
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
            EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
            JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef("java.lang.Override");
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
            boolean _matched = false;
            if (!_matched) {
              if (param instanceof ConstParam) {
                _matched=true;
                StringConcatenationClient _client = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    _builder.append("return ");
                    String _id = ((ConstParam)param).getId();
                    _builder.append(_id, "");
                    _builder.append(";");
                  }
                };
                this._jvmTypesBuilder.setBody(it_1, _client);
              }
            }
            if (!_matched) {
              if (param instanceof LazyParam) {
                _matched=true;
                XExpression _expr = ((LazyParam)param).getExpr();
                this._jvmTypesBuilder.setBody(it_1, _expr);
              }
            }
          };
          JvmOperation _method = this._jvmTypesBuilder.toMethod(param, "get", _typeRef_1, _function_3);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
        };
        _xblockexpression = this._jvmTypesBuilder.toClass(param, ((("$Generated_SupplierSubModel" + Integer.valueOf(modelCounter)) + "Param") + Integer.valueOf(paramCounter)), _function);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void infer(final EObject model, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (model instanceof BlangModel) {
      _infer((BlangModel)model, acceptor, isPreIndexingPhase);
      return;
    } else if (model != null) {
      _infer(model, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, acceptor, isPreIndexingPhase).toString());
    }
  }
}
