package net.godcode.seal.api;

import java.lang.reflect.Field;
import java.util.List;

/**
 * A ValueLocator knows how to find all of the members on an object whose
 * values, however they are determined
 * (see {@link ValueResolver#resolve(Field, Object)}, should be considered
 * as parts of an object's digest.
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public interface ValueLocator {
	
	public <A> List<Field> locate(A in);
	
}
