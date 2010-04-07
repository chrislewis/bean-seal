package net.godcode.seal;

import net.godcode.seal.test.Beans;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import fj.data.Option;

/**
 * CompositeAnnotationCalculatorTest
 * 
 * $Id$
 * 
 * @author clewis Apr 7, 2010
 *
 */
public class CompositeAnnotationCalculatorTest {
	
	/** We know how to construct the digest, so we'll use this for assertions. */
	private static final String CUST_DIGEST = 
		DigestUtils.shaHex(
				Beans.SECRET + ":" + Beans.CUSTOMER.getAccount().getAccountNo()
				+ ":" + Beans.CUSTOMER.getCustomerNo());
	
	private CompositeAnnotationCalculator calculator = new CompositeAnnotationCalculator();
	
	@Test
	public void test_known_unsealed_bean_yields_none() {
		Option<String> digest = calculator.calculate(Beans.ACCOUNT);
		Assert.assertTrue(digest.isNone());
	}
	
	@Test
	public void test_known_sealed_bean_yields_expected_digest() {
		Option<String> digest = calculator.calculate(Beans.CUSTOMER);
		Assert.assertTrue(digest.isSome());
		Assert.assertEquals(CUST_DIGEST, digest.some());
	}
	
}
