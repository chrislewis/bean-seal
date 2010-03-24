package net.godcode.seal.core;

import net.godcode.seal.api.Calculator;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.Value;
import net.godcode.seal.api.ValueCollector;

/**
 * SealCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 * 
 */
public class ConfigurableCalculator<A extends Value, B> implements Calculator<B> {
	
	private final ValueCollector<A> collector;
	
	private final Digester<A, B> digester;
	 
	public ConfigurableCalculator(ValueCollector<A> collector,
			Digester<A, B> digester) {
		this.collector = collector;
		this.digester = digester;
	}

	public <R> B calculate(R in) {
		return digester.digest(collector.collect(in));
	}

}
