package com.google.code.alasc.errors;

/** 
 * Rappresenta un errore generico che può avvenire surante la 
 * compilazione del listato Logo.
 * 
 * @author Andrea Rota
 */

public class GenericError {
	protected int beginLine;
	protected int beginColumn;
	protected String errorMessage;
	
	/**
	 * Costruisce un'istanza della classe a partire da parametri che 
	 * descrivono l'errore.
	 * 
	 * @param beginLine La riga in cui si presenta l'errore.
	 * @param beginColumn La colonna in cui si presenta l'errore.
	 * @param errorMessage Il messaggio d'errore.
	 */
	public GenericError(int beginLine, int beginColumn, String errorMessage) {
		super();
		this.beginLine = beginLine;
		this.beginColumn = beginColumn;
		this.errorMessage = errorMessage;
	}

	/**
	 * Restituisce la colonna in cui si presenta l'errore.
	 * @return La colonna.
	 */
	public int getBeginColumn() {
		return beginColumn;
	}

	/**
	 * Restituisce la riga in cui si presenta l'errore.
	 * @return La linea.
	 */
	public int getBeginLine() {
		return beginLine;
	}
	
	/**
	 * Restituisce il messaggio di errore.
	 * @return Il messaggio.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	public String toString() {
		return "Error on " + beginLine + ":" + beginColumn + " " + errorMessage;
	}
		
}
