package net.godcode.seal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sealed
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sealed {
	
	String path() default "";
	
}