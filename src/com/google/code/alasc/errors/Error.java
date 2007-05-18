package com.google.code.alasc.errors;

/** Rappresenta un errore generico che pu˜ essere localizzato
 * nel codice
 * 
 * @author andrea
 *
 */

public class Error {
	protected int beginLine;
	protected int beginColumn;
	protected String errorMessage;
	

	
	public Error(int beginLine, int beginColumn, String errorMessage) {
		super();
		this.beginLine = beginLine;
		this.beginColumn = beginColumn;
		this.errorMessage = errorMessage;
	}



	/**
	 * @return the beginColumn
	 */
	public int getBeginColumn() {
		return beginColumn;
	}



	/**
	 * @return the beginLine
	 */
	public int getBeginLine() {
		return beginLine;
	}



	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}



	public String toString() {
		return "Error on " + beginLine + ":" + beginColumn + " " + errorMessage;
	}
		
}
