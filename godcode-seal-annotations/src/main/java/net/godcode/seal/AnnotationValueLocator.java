package net.godcode.seal;

import static fj.data.Array.array;
import static net.godcode.seal.Classes.isFieldSealed;

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
			.filter(isFieldSealed(Sealed.class)).toCollection();
	}
	
}
