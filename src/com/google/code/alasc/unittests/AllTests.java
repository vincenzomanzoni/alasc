package com.google.code.alasc.unittests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Suite di test d'unità.
 * 
 * @author Vincenzo Manzoni
 *
 */
public class AllTests {

	/**
	 * Crea e restituisce una suite di test.
	 * @return La suite di test.
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.google.code.alasc.unittest");
		//$JUnit-BEGIN$
		suite.addTestSuite(ErrorManagerTest.class);
		suite.addTestSuite(DeclarationTest.class);
		//$JUnit-END$
		return suite;
	}

}
