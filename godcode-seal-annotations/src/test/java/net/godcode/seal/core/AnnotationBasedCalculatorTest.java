package net.godcode.seal.core;

import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import net.godcode.seal.AnnotationBasedCalculator;
import net.godcode.seal.core.test.Beans;

/**
 * AnnotationBasedCalculatorTest
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotationBasedCalculatorTest {

	@Test
	public void test_known_bean_yields_correct_digest_map() {
		AnnotationBasedCalculator calc = new AnnotationBasedCalculator();
		SortedMap<String, String> map = calc.calculate(Beans.CUSTOMER);
		
		TreeMap<String, String> manual = new TreeMap<String, String>();
		manual.put("accountNo", DigestUtils.shaHex(Beans.SECRET + Beans.ACCOUNT.getAccountNo()));
		manual.put("customerNo", DigestUtils.shaHex(Beans.SECRET + Beans.CUSTOMER.getCustomerNo()));
		
		Assert.assertEquals(map, manual);
	}
	
}
