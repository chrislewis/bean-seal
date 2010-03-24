package net.godcode.seal.core;

import java.lang.reflect.Field;
import java.util.List;

import net.godcode.seal.core.test.Beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * AnnotatedValueLocatorTest
 * 
 * $Id$
 * 
 * @author clewis Mar 23, 2010
 *
 */
public class AnnotatedValueLocatorTest {
	
	private AnnotatedValueLocator locator = new AnnotatedValueLocator();
	
	@Test
	public void test_that_locator_skips_unannotated_fields() {
		List<Field> fields = locator.locate(Beans.ACCOUNT);
		Assert.assertTrue(fields.size() == 0);
	}
	
	@Test
	public void test_that_locator_locates_annotated_fields() {
		List<Field> fields = locator.locate(Beans.CUSTOMER);
		Assert.assertTrue(fields.size() == 2);
	}
	
}
