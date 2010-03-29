package net.godcode.seal.api;

/**
 * A Digester executes a recipe for creating a unique digest of a sealed object.
 * The ingredients for this task come from a {@link BeanDescriptor}. How a
 * digest is calculated and how it is represented are dictated by the
 * given implemenation. 
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public interface Digester<A extends Value, B> {

	public B digest(BeanDescriptor<A> descriptor);
	
}
