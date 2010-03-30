package net.godcode.seal;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import net.godcode.seal.annotations.SealedBean;
import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Value;
import net.godcode.seal.api.ValueCollector;
import net.godcode.seal.api.ValueLocator;
import net.godcode.seal.api.ValueResolver;
import fj.data.Option;


/**
 * AnnotatedFieldCollector
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public class AnnotationValueCollector<A extends Value> implements ValueCollector<A> {
	
	private final ValueResolver<A> resolver;
	
	private final ValueLocator locator;
	
	public AnnotationValueCollector(ValueResolver<A> resolver) {
		this(resolver, new AnnotationValueLocator());
	}
	
	public AnnotationValueCollector(ValueResolver<A> resolver, ValueLocator locator) {
		this.resolver = resolver;
		this.locator = locator;
	}
	
	public <B> Option<BeanDescriptor<A>> collect(final B in) {
		if(! in.getClass().isAnnotationPresent(SealedBean.class)) {
			return Option.none();
		} else {
			Map<String, A> values = new TreeMap<String, A>();
			for(Field f : locator.locate(in)) {
				values.put(f.getName(), resolver.resolve(f, in));
			}
			
			SealedBean sb = in.getClass().getAnnotation(SealedBean.class);
			BeanDescriptor<A> d = new BeanDescriptorImpl<A>(sb.secret(), values);
			return Option.some(d);
		}
	}

}
