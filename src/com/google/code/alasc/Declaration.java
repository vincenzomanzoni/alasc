package com.google.code.alasc;



public class Declaration{
	private String variableName;
	private String uniqueName;
	private int blocco;
	private int beginLine, beginColumn;
	private boolean isUsed;
	
	public Declaration(String variableName, String uniqueName, int blocco, int beginLine, int beginColumn) {
		super();
		this.variableName = variableName;
		this.uniqueName = uniqueName;
		this.blocco = blocco;
		this.beginLine = beginLine;
		this.beginColumn = beginColumn;
		this.isUsed = false;
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
		return "(" + beginLine + ":" + beginColumn + " " + variableName + " depth: " + blocco +
		" used: " + isUsed + ")";
	}
	
	public void setAsUsed() {
		this.isUsed = true;
	}

	/**
	 * @return the uniqueName
	 */
	public String getUniqueName() {
		return uniqueName;
	}
	
}
