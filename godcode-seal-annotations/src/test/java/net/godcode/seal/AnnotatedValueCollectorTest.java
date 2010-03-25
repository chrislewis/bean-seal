package net.godcode.seal;

import java.util.Map;

import net.godcode.seal.CoreUtils;
import net.godcode.seal.annotations.SealedBean;
import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Value;
import net.godcode.seal.test.Beans.Account;
import net.godcode.seal.test.Beans.Customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * AnnotatedValueCollectorTest
 * 
 * $Id$
 * 
 * @author clewis Mar 19, 2010
 *
 */
public class AnnotatedValueCollectorTest {
	 
	private AnnotationValueCollector<Value> collector = new AnnotationValueCollector<Value>(new AnnotationValueResolver());
	
	private Account account;
	
	private Customer customer;
	
	@SealedBean(secret = "shh!")
	private class BeanWithSecret {}
	
	@Before
	public void before() {
		account = new Account("1234", "Personal Account");
		customer = new Customer("Chris", "Lewis", "1", account);
	}
	
	@Test
	public void test_unannotated_classes_yield_empty() {
		Assert.assertEquals(CoreUtils.emptyDescriptor(), collector.collect(account));
	}
	
	@Test
	public void test_sealed_bean_with_specified_secret() {
		Assert.assertEquals("shh!", collector.collect(new BeanWithSecret()).getSecret());
	}
	
	@Test
	public void test_sealed_bean_yields_sealed_values() {
		BeanDescriptor<Value> d = collector.collect(customer);
		Assert.assertTrue(d.getValues().containsKey("customerNo"));
		Assert.assertTrue(d.getValues().containsKey("account"));
	}
	
	@Test
	public void test_sealed_bean_value_mappings() {
		BeanDescriptor<Value> d = collector.collect(customer);		
		Map<String, Value> values = d.getValues();
		Assert.assertEquals(customer.getCustomerNo(), values.get("customerNo").getValue());
		Assert.assertEquals(customer.getAccount().getAccountNo(), values.get("account").getValue());
	}
	
}
