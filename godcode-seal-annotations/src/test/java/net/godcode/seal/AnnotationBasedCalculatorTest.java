package net.godcode.seal;

import java.util.SortedMap;
import java.util.TreeMap;

import net.godcode.seal.api.Value;
import net.godcode.seal.test.Beans;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

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
		AnnotationCalculator<SortedMap<String, String>> calc = new AnnotationCalculator<SortedMap<String, String>>(new DiscreteDigester<Value>());
		SortedMap<String, String> map = calc.calculate(Beans.CUSTOMER).some();
		
		TreeMap<String, String> manual = new TreeMap<String, String>();
		manual.put("accountNo", DigestUtils.shaHex(Beans.SECRET + Beans.ACCOUNT.getAccountNo()));
		manual.put("customerNo", DigestUtils.shaHex(Beans.SECRET + Beans.CUSTOMER.getCustomerNo()));
		
		Assert.assertEquals(map, manual);
	}
	
}
