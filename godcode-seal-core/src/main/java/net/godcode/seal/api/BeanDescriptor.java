package net.godcode.seal.api;

import java.util.Map;

/**
 * An ADT that describes the component members (and their respective values)
 * of a sealed object. A BeanDescriptor effectively provides the ingredients
 * for creating the digest of its associated object.
 * 
 * $Id$
 * 
 * @author clewis Mar 19, 2010
 *
 */
public interface BeanDescriptor<A extends Value> {
	
	public String getSecret();

	public Map<String, A> getValues();
	
}
