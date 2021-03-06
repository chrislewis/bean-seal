package net.godcode.seal;

import java.lang.reflect.Field;

import net.godcode.seal.AnnotationValueResolver;
import net.godcode.seal.api.Value;
import net.godcode.seal.test.Beans;

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

	private AnnotationValueResolver resolver = new AnnotationValueResolver();
	
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
