package net.godcode.seal.api;

import fj.data.Option;


/**
 * A service that knows how to collect and resolve the sealed values of a
 * sealed object. A ValueCollector is therefore responsible for creating a
 * {@link BeanDescriptor} of a sealed object. A collector would generally
 * employ a {@link ValueLocator} and a {@link ValueResolver} to accomplish
 * this task.
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public interface ValueCollector<A extends Value> {
	
	public <B> Option<BeanDescriptor<A>> collect(B obj);
	
}
