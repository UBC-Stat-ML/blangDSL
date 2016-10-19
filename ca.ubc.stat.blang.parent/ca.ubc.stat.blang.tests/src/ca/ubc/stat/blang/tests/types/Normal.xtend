package ca.ubc.stat.blang.tests.types

import blang.core.Model
import blang.core.Param
import blang.core.RealVar
import java.util.function.Supplier

public abstract class Normal implements Model {
    
    new(RealVar y, @Param Supplier<RealVar> mean, @Param Supplier<RealVar> variance) {
        
    }
}