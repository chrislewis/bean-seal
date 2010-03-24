package net.godcode.seal.core.api;

import java.lang.reflect.Field;

/**
 * ValueResolver
 * 
 * $Id$
 * 
 * @author clewis Mar 22, 2010
 *
 */
public interface ValueResolver<B extends Value> {
	
	public <A> B resolve(Field field, A source);
	
}