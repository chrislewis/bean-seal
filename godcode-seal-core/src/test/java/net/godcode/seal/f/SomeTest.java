package net.godcode.seal.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * SomeTest
 * 
 * $Id$
 * 
 * @author clewis Mar 28, 2010
 *
 */
public class SomeTest {
	
	@Test
	public void test_some_getOr_yields_own_value() {
		Assert.assertEquals("foo", Option.some("foo").getOr("bar"));
	}
	
	@Test
	public void test_some_is_not_none() {
		Assert.assertFalse(Option.some("").isNone());
	}
	
	@Test
	public void test_some_is_some() {
		Assert.assertTrue(Option.some(1).isSome());
	}
	
	@Test
	public void test_iteration() {
		int count = 0;
		for(Integer _s : Option.some(42)) count++;
		Assert.assertEquals(1, count);
		
		for(Integer _s : Option.some(42)) count++;
		Assert.assertEquals(2, count);
	}
	
}
