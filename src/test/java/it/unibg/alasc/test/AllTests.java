package it.unibg.alasc.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Suite test
 * 
 * @author Vincenzo Manzoni
 *
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test suite for Alasc");
		
		suite.addTestSuite(ErrorManagerTest.class);
		suite.addTestSuite(DeclarationTest.class);
		suite.addTestSuite(SimpleBeautifierTest.class);
		
		return suite;
	}

}
