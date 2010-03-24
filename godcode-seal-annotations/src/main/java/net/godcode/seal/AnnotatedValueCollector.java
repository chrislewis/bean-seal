package net.godcode.seal;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import net.godcode.seal.annotations.SealedBean;
import net.godcode.seal.core.BeanDescriptorImpl;
import net.godcode.seal.core.CoreUtils;
import net.godcode.seal.core.api.BeanDescriptor;
import net.godcode.seal.core.api.Value;
import net.godcode.seal.core.api.ValueCollector;
import net.godcode.seal.core.api.ValueLocator;
import net.godcode.seal.core.api.ValueResolver;


/**
 * AnnotatedFieldCollector
 * 
 * $Id$
 * 
 * @author clewis Mar 17, 2010
 *
 */
public class AnnotatedValueCollector<T extends Value> implements ValueCollector<T> {
	
	private final ValueResolver<T> resolver;
	
	private final ValueLocator locator;
	
	public AnnotatedValueCollector(ValueResolver<T> resolver) {
		this(resolver, new AnnotatedValueLocator());
	}
	
	public AnnotatedValueCollector(ValueResolver<T> resolver, ValueLocator locator) {
		this.resolver = resolver;
		this.locator = locator;
	}
	
	public <V> BeanDescriptor<T> collect(V in) {
		if(! in.getClass().isAnnotationPresent(SealedBean.class)) {
			return CoreUtils.emptyDescriptor();
		} else {
			Map<String, T> values = new TreeMap<String, T>();
			for(Field f : locator.locate(in)) {
				values.put(f.getName(), resolver.resolve(f, in));
			}
			
			SealedBean sb = in.getClass().getAnnotation(SealedBean.class);
			return new BeanDescriptorImpl<T>(sb.secret(), values);
		}
	}

}
