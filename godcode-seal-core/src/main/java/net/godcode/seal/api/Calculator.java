package net.godcode.seal.api;

import fj.data.Option;


/**
 * A Calculator would presumably be composed of at least a ValueCollector and
 * a Digester. Given an arbitrary instance for which a BeanDescriptor can be
 * resolved, a calculator will return the digest of that instance in the format
 * specified by the digester.
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public interface Calculator<A> {
	
	public <B> Option<A> calculate(B in);
	
}
