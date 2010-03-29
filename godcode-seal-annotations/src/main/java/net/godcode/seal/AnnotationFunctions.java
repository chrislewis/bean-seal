package net.godcode.seal;

import java.lang.reflect.Field;

import net.godcode.seal.annotations.Sealed;

import fj.F;

/**
 * AnnotationFunctions
 * 
 * $Id$
 * 
 * @author clewis Mar 29, 2010
 *
 */
public class AnnotationFunctions {
	
	public static final F<Field, Boolean> isFieldSealed = new F<Field, Boolean>() {
		public Boolean f(Field f) {
			return f.isAnnotationPresent(Sealed.class);
		}
	};
	
}
