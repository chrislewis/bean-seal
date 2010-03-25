package net.godcode.seal;

import net.godcode.seal.core.api.Calculator;
import net.godcode.seal.core.api.Digester;
import net.godcode.seal.core.api.Value;
import net.godcode.seal.core.api.ValueCollector;

/**
 * AnnotationBasedCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotationCalculator<A extends Value, B> implements Calculator<B> {
	
	private final ValueCollector<Value> collector = 
		new AnnotationValueCollector<Value>(new AnnotationValueResolver(), new AnnotationValueLocator());
	
	private final Digester<Value, B> digester;
	
	public AnnotationCalculator(Digester<Value, B> digester) {
		this.digester = digester;
	}
	
	public <U> B calculate(U in) {
		return digester.digest(collector.collect(in));
	}
}
