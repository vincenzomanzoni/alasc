package it.unibg.alasc.test;

import it.unibg.alasc.Declaration;
import junit.framework.TestCase;

/**
 * Unit test of <tt>Declaration</tt> class.
 * 
 * @author Vincenzo Manzoni
 */
public class DeclarationTest extends TestCase {

	// Test: equality of two Declarations
	public void testEquals() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 0, 1, 1);
		assertTrue(d1.equals(d2));
	}
	
	// Test: declarations are not equal when the nesting level is the same, but the name is different
	public void testNotEqualsVariableName() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 0, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	// Test: declarations are not equal when the name is the same, but the nesting level is different
	public void testNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	// Test: declarations are not equal when name and nesting level are differents
	public void testNotEqualsVariableNameNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}

}
