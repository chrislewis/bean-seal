package net.godcode.seal.api;

import net.godcode.seal.f.Option;

/**
 * SealedFieldCollector
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public interface ValueCollector<A extends Value> {
	
	public <B> Option<BeanDescriptor<A>> collect(B obj);
	
}
