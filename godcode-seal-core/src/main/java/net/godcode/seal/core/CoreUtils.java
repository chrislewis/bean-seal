package net.godcode.seal.core;

import java.util.Collections;

import net.godcode.seal.core.api.BeanDescriptor;
import net.godcode.seal.core.api.Value;

/**
 * CoreUtils
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class CoreUtils {
	
	private static final BeanDescriptor EMPTY_DESCRIPTOR = new BeanDescriptorImpl("", Collections.emptyMap());
	
	private CoreUtils() {}
	
	public static <A extends Value> BeanDescriptor<A> emptyDescriptor() {
		return EMPTY_DESCRIPTOR;
	}
	
}
