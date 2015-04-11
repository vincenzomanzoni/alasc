package it.unibg.alasc.errors;

/**
 * Rappresenta l'errore sintattico.
 * 
 * @author andrea
 *
 */

public class SyntaxError extends GenericError {

	public SyntaxError(int row, int column, String errorMessage) {
		super(row, column, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Syntax error: " + errorMessage;
	}
}
