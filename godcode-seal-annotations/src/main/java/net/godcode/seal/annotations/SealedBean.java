package net.godcode.seal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation indicating a class whose instances should be considered sealed.
 * 
 * $Id$
 * 
 * @author clewis Mar 19, 2010
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SealedBean {
	
	/**
	 * A secret to be treated as a part of the contained sealed values when
	 * creating a digest for an instance of the type.
	 */
	String secret() default "";
	
}
