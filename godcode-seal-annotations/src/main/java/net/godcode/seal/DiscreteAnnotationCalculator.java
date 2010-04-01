package net.godcode.seal;

import java.util.SortedMap;

import net.godcode.seal.api.Calculator;
import net.godcode.seal.api.Value;
import fj.data.Option;

/**
 * DiscreteAnnotationCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 24, 2010
 *
 */
public final class DiscreteAnnotationCalculator implements Calculator<SortedMap<String, String>> {
	
	private final Calculator<SortedMap<String, String>> calculator =
		new AnnotationCalculator<SortedMap<String, String>>(
			new DiscreteDigester<Value>());
	
	public <B> Option<SortedMap<String, String>> calculate(B in) {
		return calculator.calculate(in);
	}
	
}
