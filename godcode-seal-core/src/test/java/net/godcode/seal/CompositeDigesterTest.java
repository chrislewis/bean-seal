package net.godcode.seal;

import java.util.Map;
import java.util.TreeMap;

import net.godcode.seal.api.Value;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * CompositeDigesterTest
 * 
 * $Id$
 * 
 * @author clewis Apr 6, 2010
 *
 */
public class CompositeDigesterTest {
	
	private CompositeDigester<Value> digester = new CompositeDigester<Value>();
	
	private BeanDescriptorImpl<Value> descriptor;
	
	@Before
	public void before() {
		Map<String, Value> values = new TreeMap<String, Value>();
		values.put("firstName", new ValueImpl("firstName", "Chris"));
		values.put("lastName", new ValueImpl("lastName", "Lewis"));
		descriptor = new BeanDescriptorImpl<Value>("secret", values);
	}
	
	@Test
	public void test_known_value_sum_matches_composite_digest() {
		Assert.assertEquals(
				DigestUtils.shaHex("secret:Chris:Lewis"), // we know the summing algorithm
				digester.digest(descriptor));
	}
	
	@Test
	public void test_mismatched_value_sum_matches_composite_digest() {
		Assert.assertFalse(
				DigestUtils.shaHex("scrt:Chris:Lewis").equals(
						digester.digest(descriptor)));
	}
	
}
