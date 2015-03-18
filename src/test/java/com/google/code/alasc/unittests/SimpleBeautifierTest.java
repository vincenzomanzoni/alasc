package com.google.code.alasc.unittests;

import it.unibg.alasc.SimpleBeautifier;
import junit.framework.TestCase;

/**
 * Test di unit� della classe <tt>SimpleBeautifier</tt>.
 * 
 * @author Vincenzo Manzoni
 */
public class SimpleBeautifierTest extends TestCase {
	private SimpleBeautifier simpleBeautifier;
	
	/**
	 * Inizializza l'istanza di <tt>SimpleBeautifier</tt> che verr� utilizzata
	 * dai test.
	 */
	public SimpleBeautifierTest() {		
		simpleBeautifier = new SimpleBeautifier(2); // 2 tab iniziali
	}
	
	/**
	 * Verifica che il beautifier abbellisca correttamente un codice 
	 * ActionScript molto semplice.
	 */
	public void testBeautifySimpleCode() {
		String code = "goForward(100);rotateRight(90);";
		String beautifiedCode = simpleBeautifier.beautify(code);
		String expected = "\t\tgoForward(100);" +
				"\n" +
				"\t\trotateRight(90);";
		assertTrue(beautifiedCode.equals(expected));
	}
	
	/**
	 * Verifica che il beautifier abbellisca correttamente un codice 
	 * ActionScript in cui � presente un blocco (in particolare, un
	 * blocco for).
	 */
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
