package net.godcode.seal.core.api;


/**
 * SealCalculator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public interface Calculator<A> {
	
	public <B> A calculate(B in);
	
}