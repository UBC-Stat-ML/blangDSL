/*
 * generated by Xtext 2.9.1
 */
package ca.ubc.stat.blang.ui.tests;

import ca.ubc.stat.blang.ui.internal.BlangActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class BlangDslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return BlangActivator.getInstance().getInjector("ca.ubc.stat.blang.BlangDsl");
	}

}
