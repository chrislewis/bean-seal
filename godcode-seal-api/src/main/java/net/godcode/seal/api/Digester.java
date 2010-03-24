package net.godcode.seal.api;

/**
 * Digester
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public interface Digester<A extends Value, B> {

	public B digest(BeanDescriptor<A> descriptor);
	
}
