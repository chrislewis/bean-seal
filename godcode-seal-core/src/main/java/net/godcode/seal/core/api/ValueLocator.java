package net.godcode.seal.core.api;

import java.lang.reflect.Field;
import java.util.List;

/**
 * ValueLocator
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public interface ValueLocator {
	
	public <A> List<Field> locate(A in);
	
}
