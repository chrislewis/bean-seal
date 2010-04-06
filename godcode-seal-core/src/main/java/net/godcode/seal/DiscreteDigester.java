package net.godcode.seal;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Digester;
import net.godcode.seal.api.Value;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * A DiscreteDigester generates a SortedMap of property names to their digests,
 * given a BeanDescriptor<A>.
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public final class DiscreteDigester<A extends Value> implements Digester<A, SortedMap<String, String>> {

	public SortedMap<String, String> digest(BeanDescriptor<A> descriptor) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		for(Value sv : descriptor.getValues().values()) {
			String hash = DigestUtils.shaHex(descriptor.getSecret() + sv.getValue());
			map.put(sv.getName(), hash);
		}
		return Collections.unmodifiableSortedMap(map);
	}
	
}
