package net.godcode.seal;

import java.util.SortedMap;

import net.godcode.seal.core.DiscreteDigester;
import net.godcode.seal.core.api.Calculator;
import net.godcode.seal.core.api.Value;

/**
 * DiscreteAnnotationCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 24, 2010
 *
 */
public class DiscreteAnnotationCalculator implements Calculator<SortedMap<String, String>> {
	
	private final Calculator<SortedMap<String, String>> calculator =
		new AnnotationCalculator<Value, SortedMap<String, String>>(
				new DiscreteDigester<Value>());
	
	public <B> SortedMap<String, String> calculate(B in) {
		return calculator.calculate(in);
	}
	
}
