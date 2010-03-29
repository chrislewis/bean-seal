package net.godcode.seal.api;

import net.godcode.seal.f.Option;


/**
 * SealCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public interface Calculator<A> {
	
	public <B> Option<A> calculate(B in);
	
}
