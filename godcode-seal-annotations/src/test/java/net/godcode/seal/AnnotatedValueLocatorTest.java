package net.godcode.seal;

import java.lang.reflect.Field;
import java.util.Collection;

import net.godcode.seal.test.Beans;

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
	
	private AnnotationValueLocator locator = new AnnotationValueLocator();
	
	@Test
	public void test_that_locator_skips_unannotated_fields() {
		Collection<Field> fields = locator.locate(Beans.ACCOUNT);
		Assert.assertTrue(fields.size() == 0);
	}
	
	@Test
	public void test_that_locator_locates_annotated_fields() {
		Collection<Field> fields = locator.locate(Beans.CUSTOMER);
		Assert.assertTrue(fields.size() == 2);
	}
	
}
