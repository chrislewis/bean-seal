package net.godcode.seal;

import java.util.Map;

import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Value;

/**
 * BeanDescriptorImpl
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public final class BeanDescriptorImpl<T extends Value> implements BeanDescriptor<T> {
	
	private final String secret;
	
	private final Map<String, T> values;
	
	public BeanDescriptorImpl(String secret, Map<String, T> values) {
		this.secret = secret;
		this.values = values;
	}
	
	public String getSecret() {
		return secret;
	}

	public Map<String, T> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return String.format("secret=%s, values=%s", secret, values);
	}
	
}
