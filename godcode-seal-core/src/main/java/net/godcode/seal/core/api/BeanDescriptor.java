package net.godcode.seal.core.api;

import java.util.Map;

/**
 * SealedValue
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
