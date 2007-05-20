package com.google.code.alasc.test;

import java.io.StringReader;

import com.google.code.alasc.*;

public class TestScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringReader sr = new StringReader("FD 10 RT10");
		ParserTokenManager ptm = new ParserTokenManager(new SimpleCharStream(sr));
		
		Token t;
		while(true) {
			t = ptm.getNextToken();
			if (t.kind != ParserTokenManager.EOF) {
				System.out.println(t.kind + ", " + t.image);
			}
			else {
				break;
			}
		}
		
	}

}
