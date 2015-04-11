package it.unibg.alasc.errors;

/**
 * Rappresenta l'errore lessicale.
 * 
 * @author andrea
 *
 */

public class LexicalError extends GenericError {

	public LexicalError(int row, int column, String errorMessage) {
		super(row, column, errorMessage);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return errorMessage;
	}

}
