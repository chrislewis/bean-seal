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
public final class BeanDescriptorImpl<A extends Value> implements BeanDescriptor<A> {
	
	private final String secret;
	
	private final Map<String, A> values;
	
	public BeanDescriptorImpl(String secret, Map<String, A> values) {
		this.secret = secret;
		this.values = values;
	}
	
	public String getSecret() {
		return secret;
	}

	public Map<String, A> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return String.format("secret=%s, values=%s", secret, values);
	}
	
}
