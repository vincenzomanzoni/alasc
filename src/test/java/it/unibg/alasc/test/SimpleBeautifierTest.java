package it.unibg.alasc.test;

import it.unibg.alasc.utils.SimpleBeautifier;
import junit.framework.TestCase;

/**
 * Unit test for <tt>SimpleBeautifier</tt> class
 * 
 * @author Vincenzo Manzoni
 */
public class SimpleBeautifierTest extends TestCase {
	
	private final static int TABS = 2;
	private final SimpleBeautifier simpleBeautifier;

	public SimpleBeautifierTest() {		
		simpleBeautifier = new SimpleBeautifier(TABS);
	}
	
	// Test: verify code beautify of a simple snippet
	public void testBeautifySimpleCode() {
		String code = "goForward(100);rotateRight(90);";
		String beautifiedCode = simpleBeautifier.beautify(code);
		String expected = "\t\tgoForward(100);" +
				"\n" +
				"\t\trotateRight(90);";
		assertTrue(beautifiedCode.equals(expected));
	}
	
	// Test: verify code beautify of a snippet with a code block
	public void testBeautifyBlockCode() {
		String code = "for (var $i : Number = 0; $i < (360) ; $i++) {" +
			"goForward(1);rotateRight(1);}";
		String beautifiedCode = simpleBeautifier.beautify(code);
		String expected = "\t\tfor (var $i : Number = 0; $i < (360) ; $i++) {" +
				"\n\t\t\tgoForward(1);" +
				"\n\t\t\trotateRight(1);" +
				"\n\t\t}";
		assertTrue(beautifiedCode.equals(expected));
	}

}
