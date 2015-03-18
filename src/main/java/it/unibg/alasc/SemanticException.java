package it.unibg.alasc;

public class SemanticException extends Exception {
	
	public Token currentToken = null;
	
	public SemanticException() {
		// TODO Auto-generated constructor stub
	}

	public SemanticException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SemanticException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SemanticException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Genera una nuova SemanticException a partire dal token che l'ha generata
	 * e dalla stringa da mostrare come errore.
	 * 
	 * @param currentToken il token che genera l'errore semantico
	 * @param arg0 una stringa descrittiva dell'errore
	 */
	public SemanticException(Token currentToken, String arg0) {
		super(arg0);
		this.currentToken = currentToken;
	}
	
	

}
