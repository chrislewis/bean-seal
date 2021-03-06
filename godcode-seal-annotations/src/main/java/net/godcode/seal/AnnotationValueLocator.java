package net.godcode.seal;

import static fj.data.Array.array;

import java.lang.reflect.Field;
import java.util.Collection;

import net.godcode.seal.annotations.Sealed;
import net.godcode.seal.api.ValueLocator;

/**
 * AnnotationValueLocator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
class AnnotationValueLocator implements ValueLocator {
	
	public <V> Collection<Field> locate(V in) {
		return array(in.getClass().getDeclaredFields())
			.filter(Classes.<Field>hasAnnotation(Sealed.class))
			.toCollection();
	}
	
}
