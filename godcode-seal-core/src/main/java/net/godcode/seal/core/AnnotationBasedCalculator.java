package net.godcode.seal.core;

import java.util.SortedMap;

import net.godcode.seal.api.Calculator;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.ValueCollector;

/**
 * AnnotationBasedCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotationBasedCalculator implements Calculator<SortedMap<String, String>> {
	
	private final ValueCollector<ValueImpl> collector = 
		new AnnotatedValueCollector<ValueImpl>(new AnnotatedValueResolver(), new AnnotatedValueLocator());
	
	private final Digester<ValueImpl, SortedMap<String, String>> digester =
		new PropertyDigester<ValueImpl>();
	
	public <U> SortedMap<String, String> calculate(U in) {
		return digester.digest(collector.collect(in));
	}
}
