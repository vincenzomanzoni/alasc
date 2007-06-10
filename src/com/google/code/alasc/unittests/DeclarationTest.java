package com.google.code.alasc.unittests;

import com.google.code.alasc.Declaration;

import junit.framework.TestCase;

/**
 * Test di unità della classe <tt>Declaration</tt>.
 * 
 * @author Vincenzo Manzoni
 */
public class DeclarationTest extends TestCase {

	/**
	 * Verifica che due istanze di Declaration con lo stesso nome e la stessa
	 * profondità siano giudicate uguali.
	 */
	public void testEquals() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 0, 1, 1);
		assertTrue(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration nome differente e la stessa
	 * profondità siano giudicate diverse.
	 */
	public void testNotEqualsVariableName() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 0, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration con lo stesso nome e diversa
	 * profondità siano giudicate diverse.
	 */
	public void testNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("foo", "foo", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}
	
	/**
	 * Verifica che due istanze di Declaration nome differente e diversa
	 * profondità siano giudicate diverse.
	 */
	public void testNotEqualsVariableNameNotEqualsBlock() {
		Declaration d1 = new Declaration("foo", "foo", 0, 1, 1);
		Declaration d2 = new Declaration("bar", "bar", 1, 1, 1);
		assertFalse(d1.equals(d2));
	}

}
