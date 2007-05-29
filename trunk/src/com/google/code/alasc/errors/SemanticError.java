package com.google.code.alasc.errors;

/**
 * Rappresenta l'errore semantico.
 * 
 * @author andrea
 *
 */

public class SemanticError extends GenericError {

	public SemanticError(int row, int column, String errorMessage) {
		super(row, column, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Semantic error at line " + beginLine + ", column " + beginColumn + ". " + errorMessage;
	}
}
