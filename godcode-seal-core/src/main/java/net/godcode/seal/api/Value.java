package net.godcode.seal.api;

/**
 * A Value is a simple ADT that represents a member of a sealed object, and
 * whose resolved value will be factored into the digest of the source object.
 * 
 * $Id$
 * 
 * @author clewis Mar 20, 2010
 *
 */
public interface Value {
	
	public String getName();

	public Object getValue();
	
}
