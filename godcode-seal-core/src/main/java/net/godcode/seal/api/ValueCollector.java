package net.godcode.seal.api;

/**
 * SealedFieldCollector
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public interface ValueCollector<A extends Value> {
	
	public <B> BeanDescriptor<A> collect(B obj);
	
}