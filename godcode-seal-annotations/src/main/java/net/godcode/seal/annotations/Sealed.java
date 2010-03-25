package net.godcode.seal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for class fields signifying that their value should be
 * considered sealed.
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sealed {
	
	/**
	 * The relative property path indicating the actual value to seal.
	 * Properties with no path will be converted via direct toString
	 * invocation. When a path is present, it will be considered a property
	 * on the value represented by the field, and on which toString will
	 * be invoked.
	 */
	String path() default "";
	
}