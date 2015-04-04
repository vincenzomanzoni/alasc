package it.unibg.alasc.test;

import java.io.InputStream;
import java.util.Scanner;

import org.stringtemplate.v4.ST;

import junit.framework.TestCase;

public class CodeCompositionTest extends TestCase {

	public void testInlineTemplating() {
		ST st = new ST("Hello <name>");
		st.add("name", "World");
		assertEquals("Hello World", st.render());
	}

	public void testFileTemplating() {

		InputStream templateFile = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("sample-template.st");
		Scanner scanner = null;
		String template = null;
		
		if (templateFile != null) {
			try {
				scanner = new Scanner(templateFile);
				scanner.useDelimiter("\\Z");
				template = scanner.next();
			} catch (Throwable t) {
				fail(t.getMessage());
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
		
		ST st = new ST(template);
		st.add("name", "World");
		st.add("answer", "Fine, thanks");
		assertEquals("Hello World. How are you?\nFine, thanks", st.render());

	}

}
