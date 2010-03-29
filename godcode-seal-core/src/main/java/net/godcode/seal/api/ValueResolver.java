package net.godcode.seal.api;

import java.lang.reflect.Field;

/**
 * A service that knows how to resolve the sealed value of a sealed field.
 * This may (or may not) be as simple as fetching a field's value. It may,
 * for example, consider an external configuration or an annotation that
 * further specifies how the field's value should be interpreted.
 * 
 * $Id$
 * 
 * @author clewis Mar 22, 2010
 *
 */
public interface ValueResolver<A extends Value> {
	
	public <B> A resolve(Field field, B source);
	
}