package net.godcode.seal.f;

import static fj.data.Option.some;
import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.Value;
import fj.F;
import fj.data.Option;

/**
 * Functions
 * 
 * $Id$
 * 
 * @author clewis Mar 29, 2010
 *
 */
public class Functions {
	
	public static <A extends Value, B> F<BeanDescriptor<A>, Option<B>> digest(final Digester<A, B> digester) {
		return new F<BeanDescriptor<A>, Option<B>>() {
			public Option<B> f(BeanDescriptor<A> d) {
				return some(digester.digest(d));
			}
		};
	}
	
}
