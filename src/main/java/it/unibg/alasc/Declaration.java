package it.unibg.alasc;

/**
 * Classe che implementa una dichiarazione di variabile.
 */ 
public class Declaration{
	private String variableName;
	private String uniqueName;
	private int blocco;
	private int beginLine, beginColumn;
	private boolean isUsed;
	
	/**
	 * Costruisce una istanza della dichiarazione di variabile.
	 * 
	 * @param variableName Il nome della variabile.
	 * @param uniqueName   Nome univoco della variabile. Utilizzata per 
	 * simulare lo scope a livello di blocco in ActionScript.
	 * @param blocco       Profondit� del blocco in cui vi � la dichiarazione. 
	 * @param beginLine    Riga dove vi � la dichiarazione.
	 * @param beginColumn  Colonna dove vi � la dichiarazione. 
	 */
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
	 * Restituisce la profondit� del blocco in cui � dichiarata la variabile. 
	 * @return La profondit� del blocco in cui � dichiarata.
	 */
	public int getBlocco() {
		return blocco;
	}

	/**
	 * Restituisce il nome della variabile.
	 * @return Il nome della variabile.
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
	
	/**
	 * Imposta la variabile come usata.
	 */
	public void setAsUsed() {
		this.isUsed = true;
	}

	/**
	 * Restituisce il nome univoco della variabile.
	 * @return Il nome univoco.
	 */
	public String getUniqueName() {
		return uniqueName;
	}
	
}
