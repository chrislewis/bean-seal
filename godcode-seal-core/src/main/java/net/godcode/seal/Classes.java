package net.godcode.seal;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

import fj.F;

/**
 * Package-private functions until stable.
 * 
 * $Id$
 * 
 * @author clewis Mar 29, 2010
 *
 */
class Classes {
	
	private Classes() {}
	
	public static <A extends AccessibleObject> F<A, Boolean> hasAnnotation(final Class<? extends Annotation> a) {
		return new F<A, Boolean>() {
			public Boolean f(A ao) {
				return ao.isAnnotationPresent(a);
			}
		};
	}
	
}
