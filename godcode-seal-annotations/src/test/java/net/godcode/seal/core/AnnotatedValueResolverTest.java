package net.godcode.seal.core;

import java.lang.reflect.Field;

import net.godcode.seal.AnnotatedValueResolver;
import net.godcode.seal.core.api.Value;
import net.godcode.seal.core.test.Beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * AnnotatedValueResolverTest
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotatedValueResolverTest {

	private AnnotatedValueResolver resolver = new AnnotatedValueResolver();
	
	private Field withPath;
	
	private Field noPath;
	
	@Before
	public void before() throws SecurityException, NoSuchFieldException {
		noPath = Beans.Customer.class.getDeclaredField("customerNo");
		withPath = Beans.Customer.class.getDeclaredField("account");
	}
	
	@Test
	public void test_field_without_path_annotation() {
		Value v = resolver.resolve(noPath, Beans.CUSTOMER);
		Assert.assertEquals(Beans.CUSTOMER.getCustomerNo(), v.getValue());
	}
	
	@Test
	public void test_field_with_path_annotation() {
		Value v = resolver.resolve(withPath, Beans.CUSTOMER);
		Assert.assertEquals(Beans.CUSTOMER.getAccount().getAccountNo(), v.getValue());
	}
	
}
