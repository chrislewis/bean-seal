package net.godcode.seal.core;

import java.util.SortedMap;
import java.util.TreeMap;

import net.godcode.seal.core.api.BeanDescriptor;
import net.godcode.seal.core.api.Digester;
import net.godcode.seal.core.api.Value;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * A PropertyDigester generates a SortedMap or property names to their digests,
 * given a BeanDescriptor.
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class PropertyDigester<A extends Value> implements Digester<A, SortedMap<String, String>> {

	public SortedMap<String, String> digest(BeanDescriptor<A> descriptor) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		for(Value sv : descriptor.getValues().values()) {
			String hash = DigestUtils.shaHex(descriptor.getSecret() + sv.getValue());
			map.put(sv.getName(), hash);
		}
		return map;
	}
	
}
