package net.godcode.seal;

import java.util.Map;

import net.godcode.seal.annotations.SealedBean;
import net.godcode.seal.api.BeanDescriptor;
import net.godcode.seal.api.Value;
import net.godcode.seal.test.Beans.Account;
import net.godcode.seal.test.Beans.Customer;
import net.godcode.seal.test.Beans.SealedEmptyAccount;

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
	public void test_unannotated_class_yield_empty() {
		Assert.assertTrue(collector.collect(account).isNone());
	}
	
	@Test
	public void test_annotated_but_empty_class_yield_empty_values_in_descriptor() {
		System.out
				.println("AnnotatedValueCollectorTest.test_annotated_but_empty_class_yield_empty_values_in_descriptor() " + collector.collect(new SealedEmptyAccount("123", "personal")));
		BeanDescriptor<Value> d = collector.collect(new SealedEmptyAccount("123", "personal")).some();
		Assert.assertTrue(d.getValues().isEmpty());
		Assert.assertNotNull(d.getSecret());
		Assert.assertFalse("".equals(d.getSecret()));
	}
	
	@Test
	public void test_sealed_bean_with_specified_secret() {
		Assert.assertEquals("shh!", collector.collect(new BeanWithSecret()).some().getSecret());
	}
	
	@Test
	public void test_sealed_bean_yields_sealed_values() {
		BeanDescriptor<Value> d = collector.collect(customer).some();
		Assert.assertTrue(d.getValues().containsKey("customerNo"));
		Assert.assertTrue(d.getValues().containsKey("account"));
	}
	
	@Test
	public void test_sealed_bean_value_mappings() {
		
		for(BeanDescriptor<Value> d : collector.collect2(customer)) {
			System.out
					.println("AnnotatedValueCollectorTest.test_sealed_bean_value_mappings() --- " + d);
		}
		
		BeanDescriptor<Value> d = collector.collect(customer).some();		
		Map<String, Value> values = d.getValues();
		Assert.assertEquals(customer.getCustomerNo(), values.get("customerNo").getValue());
		Assert.assertEquals(customer.getAccount().getAccountNo(), values.get("account").getValue());
	}
	
}
