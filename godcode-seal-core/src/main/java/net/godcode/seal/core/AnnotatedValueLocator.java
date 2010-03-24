package net.godcode.seal.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.godcode.seal.annotations.Sealed;
import net.godcode.seal.api.ValueLocator;

/**
 * ValueLocator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotatedValueLocator implements ValueLocator {
	
	public <V> List<Field> locate(V in) {
		List<Field> fields = new ArrayList<Field>();
		for(Field f : in.getClass().getDeclaredFields()) {
			if(f.isAnnotationPresent(Sealed.class)) {
				fields.add(f);
			}
		}
		return fields;
	}
	
}
