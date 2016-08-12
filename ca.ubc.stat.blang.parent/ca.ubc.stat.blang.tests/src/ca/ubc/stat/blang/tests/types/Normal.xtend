package ca.ubc.stat.blang.tests.types

import blang.core.Model
import blang.core.Param
import java.util.function.Supplier

public abstract class Normal implements Model {
    
    new(Real y, @Param Supplier<Real> mean, @Param Supplier<Real> variance) {
        
    }
}