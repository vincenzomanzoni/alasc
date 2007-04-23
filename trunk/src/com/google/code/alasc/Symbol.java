package com.google.code.alasc;

public class Symbol implements Comparable<Symbol>{
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
	
	public int compareTo(Symbol s) {
		return this.variableName.compareTo(s.getSymbol());
	}
}
