package net.godcode.seal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

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
	
	public static F<Field, Boolean> isFieldSealed(final Class<? extends Annotation> a) {
		return new F<Field, Boolean>() {
			public Boolean f(Field f) {
				return f.isAnnotationPresent(a);
			}
		};
	}
	
}
