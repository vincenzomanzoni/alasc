package it.unibg.alasc.errors;

import it.unibg.alasc.Token;

public class SemanticException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	// Public property to emulate JavaCC exceptions
	public Token currentToken;

	public SemanticException(Token token, String message) {
		super(message);
		this.currentToken = token;
	}	

}
