package net.godcode.seal;

import java.util.SortedMap;
import java.util.TreeMap;

import net.godcode.seal.test.Beans;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import fj.data.Option;

/**
 * DiscreteAnnotationCalculatorTest
 * 
 * $Id$
 * 
 * @author clewis Apr 7, 2010
 *
 */
public class DiscreteAnnotationCalculatorTest {
	
	private DiscreteAnnotationCalculator calculator = new DiscreteAnnotationCalculator();

	@Test
	public void test_known_unsealed_bean_yields_none() {
		Option<SortedMap<String, String>> digest = calculator.calculate(Beans.ACCOUNT);
		Assert.assertTrue(digest.isNone());
	}
	
	@Test
	public void test_known_sealed_bean_yields_expected_value() {
		Option<SortedMap<String, String>> digest = calculator.calculate(Beans.CUSTOMER);
		Assert.assertTrue(digest.isSome());
		
		TreeMap<String, String> manual = new TreeMap<String, String>();
		manual.put("accountNo", DigestUtils.shaHex(Beans.SECRET + Beans.ACCOUNT.getAccountNo()));
		manual.put("customerNo", DigestUtils.shaHex(Beans.SECRET + Beans.CUSTOMER.getCustomerNo()));
		
		Assert.assertEquals(manual, digest.some());
	}
	
}
