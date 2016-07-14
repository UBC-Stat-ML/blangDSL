Running the code
================

- import in eclipse as ``Existing project``
    - make sure to check the box for adding subprojects
- delete .settings (might not be needed anymore)
- right click on ``ca.ubc.stat.blang.tests`` pick run as JUnit

Note: currently, bayonet is imported with a committed bin folder. 

- when grammar changes, 
    - right click on the grammar file
    - run as ``Generate XText artefacts``
    - will generate the generated files


Organization of the code
========================

- syntax : ``BlangDSL.xtext``
- all the work for generating code: ``BlangDslJvmModelInferrer``
    - ``acceptor.accept`` : creates first level Java type
    - ``isPreIndexingPhase`` : ?
    - ``it`` in this case is of type ``JvmDeclaredType``
    - ``typeRef`` : creates signature, takes care of adding imporat
        - but sometimes does not work, use ``typeRef(blang.core.SupportFactor).identifier``
    - non-terminals are subtypes of ``EObject`` (E is for EMF)
- all test cases are in: ``ca.ubc.stat.blang.tests``
- to add automatic imports: ``ImplicitImportsScopeProvider``