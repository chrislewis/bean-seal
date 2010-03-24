package net.godcode.seal.core;

import net.godcode.seal.api.Value;

/**
 * SealedValueImpl
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class ValueImpl implements Value {
	
	private final String name;
	
	private final Object value;
	
	public ValueImpl(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%s=%s", getName(), getValue());
	}
	
}
