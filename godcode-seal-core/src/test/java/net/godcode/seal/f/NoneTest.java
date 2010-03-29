package net.godcode.seal.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * OptionTest
 * 
 * $Id$
 * 
 * @author clewis Mar 28, 2010
 *
 */
public class NoneTest {
	
	@Test
	public void test_none_singleton() {
		Option<String> optS = Option.none();
		Option<String> optS2 = Option.none();
		
		Assert.assertSame(Option.none(), optS);
		Assert.assertSame(Option.none(), optS2);
		Assert.assertSame(optS, optS2);
	}
	
	@Test
	public void test_none_good_access() {
		Option<String> s = Option.none();
		Assert.assertEquals("safe", s.getOr("safe"));
	}
	
	@Test
	public void test_none_is_none() {
		Assert.assertTrue(Option.none().isNone());
	}
	
	@Test
	public void test_none_is_not_some() {
		Assert.assertFalse(Option.none().isSome());
	}
	
	@Test
	public void test_iteration() {
		boolean flag = false;
		for(Object _s : Option.none()) flag = true;
		Assert.assertFalse(flag);
	}
	
}
