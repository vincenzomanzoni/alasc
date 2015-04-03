package it.unibg.alasc.test;

import it.unibg.alasc.Declaration;
import junit.framework.TestCase;

/**
 * Test di unit� della classe <tt>Declaration</tt>.
 * 
 * @author Vincenzo Manzoni
 */
public class DeclarationTest extends TestCase {

	/**
	 * Verifica che due istanze di Declaration con lo stesso nome e la stessa
	 * profondit� siano giudicate uguali.
	 */
	public void testEquals() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 0, 1, 1);
		assertTrue(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration nome differente e la stessa
	 * profondit� siano giudicate diverse.
	 */
	public void testNotEqualsVariableName() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 0, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration con lo stesso nome e diversa
	 * profondit� siano giudicate diverse.
	 */
	public void testNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration nome differente e diversa
	 * profondit� siano giudicate diverse.
	 */
	public void testNotEqualsVariableNameNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}

}
