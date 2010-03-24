package net.godcode.seal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SealedBean
 * 
 * $Id$
 * 
 * @author clewis Mar 19, 2010
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SealedBean {
	
	String secret() default "";
	
}
