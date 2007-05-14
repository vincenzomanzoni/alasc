package com.google.code.alasc;

import java.util.ArrayList;
import java.util.HashSet;

public class DeclarationSet {
	
	private HashSet<Declaration> declarations;
	private ArrayList<Declaration> history;
	
	public DeclarationSet(){
		declarations = new HashSet<Declaration>();
		history = new ArrayList<Declaration>();
	}
	
	/**
	 * Inserisce la dichiarazione di una nuova variabile nell'insieme
	 * delle variabili dichiarate.
	 * 
	 * @param variableName nome della variabile (case sensitive)
	 * @param level profondit� del blocco in cui avviene la dichiarazione
	 * @return true se la variabile non era gi� stata dichiarata nel livello corrente
	 */
	public boolean addDeclaration(String variableName, int level, int beginLine, int beginColumn){
		Declaration declaration = new Declaration(variableName, level, beginLine, beginColumn);
		boolean success = history.add(declaration);
		return success && declarations.add(declaration);
	}
	
	/**
	 * Elimina tutti dall'insieme delle variabili dichiarate quelle appartenenti al blocco indicato dal parametro level
	 * 
	 * @param level indica la profondit� del blocco di cui fare pruning
	 */
	public void pruneAllDeclarationsIn(int level){
		ArrayList<Declaration> daEliminare = new ArrayList<Declaration>();
		
		// TODO Se cerco di eliminare il symbol al volo succede un casino...
		
		for(Declaration s: declarations){
			if(s.getBlocco()==level)
				daEliminare.add(s);
		}
		
		for(Declaration s: daEliminare){
			declarations.remove(s);
		}
		
	}
	
	/**
	 * Controlla se la variable con nome variableName pu� essere dichiarata
	 * nel blocco di profondit� level.
	 * 
	 * Il metodo controlla che non ci siano gi� dichiarazioni della variabile
	 * nello stesso blocco.
	 * 
	 * @param variableName
	 * @param level
	 * @return true se non ci sono gi� dichiarazioni della variabile nel blocco,
	 * altrimenti false.
	 */
	public boolean isDeclarable(String variableName, int level){
		Declaration toCompare = new Declaration(variableName, level, 0, 0);
		
		// TODO Scriverlo con il contains, purtroppo non ho sotto la javadoc
		
		for(Declaration s: declarations){
			if(s.equals(toCompare))
				return false;
		}
		
		return true;
	}
	
	/**
	 * Controlla che una certa variabile sia risolvibile dallo scope del blocco
	 * level.
	 * 
	 * Il metodo controlla che esista una almeno una dichiarazione della variabile
	 * variableName al livello corrente o a quelli precedenti, visibili quindi dallo
	 * scope di level.
	 * 
	 * @param variableName
	 * @param level
	 * @return true se nello scope visibile dal blocco a profondit� level la variabile
	 * variableName risulta visibile, altrimenti false.
	 */
	public boolean isReachable(String variableName, int level){
		for(Declaration s: declarations){
			if(s.getVariableName().equals(variableName))
				return true;
		}
		
		return false;
	}
	
	public void setAsUsed(String varname, int level) {
		Declaration declaration = null;
		
		for(Declaration s: declarations){
			if(s.getVariableName().equals(varname)) {
				if (declaration == null) {
					declaration = s;
				} else if (declaration.getBlocco() < s.getBlocco()) {
					declaration = s;
				}
			}	
		}
		
		if (declaration != null) {
			declaration.setAsUsed();
		}
		
	}
	
	public ArrayList<Declaration> getHistory() {
		return this.history;
	}

	// TO-DO Sistemarlo: cosa gli facciamo ritornare?
	/**
	 * @return the insieme
	 */
	public HashSet<Declaration> getDeclarations() {
		return declarations;
	}
	
	
}
