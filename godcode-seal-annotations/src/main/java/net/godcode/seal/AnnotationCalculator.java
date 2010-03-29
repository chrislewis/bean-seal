package net.godcode.seal;

import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Calculator;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.Value;
import net.godcode.seal.api.ValueCollector;
import fj.F;
import fj.data.Option;

/**
 * AnnotationBasedCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotationCalculator<A> implements Calculator<A> {
	
	private final ValueCollector<Value> collector = 
		new AnnotationValueCollector<Value>(new AnnotationValueResolver(), new AnnotationValueLocator());
	
	private final Digester<Value, A> digester;
	
	public AnnotationCalculator(Digester<Value, A> digester) {
		this.digester = digester;
	}
	
	public <U> Option<A> calculate(U in) {
		Option<BeanDescriptor<Value>> desc = collector.collect(in);
		return desc.bind(new F<BeanDescriptor<Value>, Option<A>>() {
			public Option<A> f(BeanDescriptor<Value> d) {
				return Option.some(digester.digest(d));
			}
		});
	}
}
