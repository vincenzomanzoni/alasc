package com.google.code.alasc;

public class Declaration{
	private String variableName;
	private int blocco;
	
	public Declaration(String variableName, int blocco) {
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
		
		if(o instanceof Declaration){
			if(((Declaration) o).getVariableName().equals(variableName) && ((Declaration) o).getBlocco() == blocco){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		return variableName;
	}
}
