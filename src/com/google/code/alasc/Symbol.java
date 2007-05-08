package com.google.code.alasc;

public class Symbol{
	private String variableName;
	private int blocco;
	
	public Symbol(String variableName, int blocco) {
		super();
		this.variableName = variableName;
		this.blocco = blocco;
	}

	/**
	 * @return the blocco
	 */
	public int getBlocco() {
		return blocco;
	}

	/**
	 * @return the variableName
	 */
	public String getVariableName() {
		return variableName;
	}
	
	public boolean equals(Object o){
		
		if(o instanceof Object){
			if(((Symbol) o).getVariableName().equals(variableName) && ((Symbol) o).getBlocco() == blocco){
				return true;
			}
		}
		
		return false;
	}
	
	
}
