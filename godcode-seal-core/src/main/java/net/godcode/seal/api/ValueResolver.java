package net.godcode.seal.api;

import java.lang.reflect.Field;

/**
 * ValueResolver
 * 
 * $Id$
 * 
 * @author clewis Mar 22, 2010
 *
 */
public interface ValueResolver<A extends Value> {
	
	public <B> A resolve(Field field, B source);
	
}