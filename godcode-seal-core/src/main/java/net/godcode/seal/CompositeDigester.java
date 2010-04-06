package net.godcode.seal;

import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.Value;

import org.apache.commons.codec.digest.DigestUtils;

import fj.F2;
import fj.data.Array;

/**
 * CompositeDigester
 * 
 * $Id$
 * 
 * @author clewis Apr 6, 2010
 *
 */
public class CompositeDigester<A extends Value> implements Digester<A, String> {

	public String digest(BeanDescriptor<A> descriptor) {
		String sum = Array.iterableArray(descriptor.getValues().values())
		.foldLeft(new F2<String, A, String>() {
			public String f(String r, A a) {
				return ":" + a.getValue().toString();
			}
		}, descriptor.getSecret());
		return DigestUtils.shaHex(sum);
	}

}
