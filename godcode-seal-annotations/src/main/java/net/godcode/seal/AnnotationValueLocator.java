package net.godcode.seal;

import static net.godcode.seal.AnnotationFunctions.isFieldSealed;

import java.lang.reflect.Field;
import java.util.Collection;

import net.godcode.seal.api.ValueLocator;
import fj.data.Array;

/**
 * ValueLocator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotationValueLocator implements ValueLocator {
	
	public <V> Collection<Field> locate(V in) {
		return Array.array(in.getClass().getDeclaredFields())
			.filter(isFieldSealed).toCollection();
	}
	
}
