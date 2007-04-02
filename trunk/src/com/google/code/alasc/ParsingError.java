package com.google.code.alasc;

public class ParsingError {
	private int row;
	private int column;
	private String errorMessage;
	
	public ParsingError(int row, int column, String errorMessage) {
		super();
		this.row = row;
		this.column = column;
		this.errorMessage = errorMessage;
	}
	
	public int getColumn() {
		return column;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public int getRow() {
		return row;
	}
	
	public String toString() {
		return row + ":" + column + " " + errorMessage;
	}
		
}
