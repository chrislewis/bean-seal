package net.godcode.seal;

import java.lang.reflect.Field;

import net.godcode.seal.ValueImpl;
import net.godcode.seal.annotations.Sealed;
import net.godcode.seal.api.Value;
import net.godcode.seal.api.ValueResolver;

/**
 * DefaultValueResolver
 * 
 * $Id$
 * 
 * @author clewis Mar 22, 2010
 *
 */
public class AnnotationValueResolver implements ValueResolver<Value> {
	
	public <V> Value resolve(Field field, V source) {
		try {
			Object value = getFieldValue(field, source);
			
			Sealed sealed = field.getAnnotation(Sealed.class);
			if(! "".equals(sealed.path())) {
				field = getField(sealed.path(), value);
				value = getFieldValue(field, value);
			}
			
			return new ValueImpl(field.getName(), value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected <V> Field getField(String name, V obj) {
		try {
			return obj.getClass().getDeclaredField(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected <V> Object getFieldValue(Field f, V in) {
		try {
			f.setAccessible(true);
			Object value = f.get(in);
			return value == null ? "" : value;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
