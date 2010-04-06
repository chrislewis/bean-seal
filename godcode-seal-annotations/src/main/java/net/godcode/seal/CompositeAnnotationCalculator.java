package net.godcode.seal;

import net.godcode.seal.api.Calculator;
import net.godcode.seal.api.Value;
import fj.data.Option;

/**
 * CompositeAnnotationCalculator
 * 
 * $Id$
 * 
 * @author clewis Apr 6, 2010
 *
 */
public final class CompositeAnnotationCalculator implements Calculator<String> {
	
	private final Calculator<String> calculator =
		new AnnotationCalculator<String>(new CompositeDigester<Value>());
	
	public <B> Option<String> calculate(B in) {
		return calculator.calculate(in);
	}
	
}
