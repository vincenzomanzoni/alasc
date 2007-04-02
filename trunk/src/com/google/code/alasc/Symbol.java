package com.google.code.alasc;

public class Symbol {
	private String variableName;
	
	public Symbol(String variableName) {
		this.variableName = variableName;
	}
	
	public String getSymbol() {
		return variableName;
	}
	
	public String toString() {
		return getSymbol();
	}
}
