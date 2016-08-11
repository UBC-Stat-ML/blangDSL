package ca.ubc.stat.blang.tests.types

import blang.core.Model
import java.util.function.Supplier

public abstract class Normal implements Model {
    
    def public Normal(Real y, Supplier<Real> mean, Supplier<Real> variance) {
        
    }
}