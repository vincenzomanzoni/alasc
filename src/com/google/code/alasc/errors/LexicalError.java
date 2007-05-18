package com.google.code.alasc.errors;

/**
 * Rappresenta l'errore lessicale.
 * 
 * @author andrea
 *
 */

public class LexicalError extends Error {

	public LexicalError(int row, int column, String errorMessage) {
		super(row, column, errorMessage);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Lexical error on " + beginLine + ":" + beginColumn + " " + errorMessage;
	}

}
