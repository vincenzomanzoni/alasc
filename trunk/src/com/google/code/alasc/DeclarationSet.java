package com.google.code.alasc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class DeclarationSet {
	
	private HashSet<Declaration> declarations;
	private ArrayList<Declaration> history;
	private Random random = new Random();
	
	private String nextUniqueVariableName(String varName) {
		String uvn = Integer.toString(Math.abs(random.nextInt()), 36);
		return varName+uvn;
	}
	
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
		
		// TO-DO CERCARE SE E' LA PRIMA
		String uniqueName = variableName;
		
		for(Declaration s: history){
			if(s.getVariableName().equals(variableName)){
				// Se il nome per la variabile è già stato usato, se ne genera uno unico
				uniqueName = nextUniqueVariableName(variableName);
				break;
			}
		}
		
		Declaration declaration = new Declaration(variableName, uniqueName, level, beginLine, beginColumn);
		
		boolean success = history.add(declaration);
		return success && declarations.add(declaration);
	}
	
	/**
	 * Rappresenta il cuore del meccanismo di risoluzione dello scope: la funzione
	 * restituisce per un dato nome di variabile e un dato livello di blocco, la
	 * dichiarazione del simbolo a cui riferirsi.
	 * 
	 * In questa implementazione si è scelto di risalire lungo i blocchi alla ricerca
	 * della prima dichiarazione. In caso questa non sia trovata viene ritornato null.
	 * 
	 * La risolvibilità di una variabile può essere controllata con il metodo isReachable.
	 * 
	 * @param varName
	 * @param level
	 * @return
	 */
	public Declaration resolveScope(String varName, int level){
		
		if (declarations == null){
			return null;
		}
		
		if (declarations.isEmpty()) {
				return null;
		}
		
		
		Declaration candidata = null;
		
		if(isReachable(varName, level)) {	
			// SHORTCIRCUIT LOGIC EVALUATION I LOVE U!
			for(Declaration s: declarations){
				if(s.getVariableName().equals(varName) &&
						s.getBlocco() <= level &&
						(candidata == null ||
						candidata.getBlocco()<s.getBlocco())){
					candidata = s;
				}
			}
		}
		
		return candidata;
	}
	
	/**
	 * Elimina tutti dall'insieme delle variabili dichiarate quelle appartenenti al blocco indicato dal parametro level
	 * 
	 * @param level indica la profondit� del blocco di cui fare pruning
	 */
	public void pruneAllDeclarationsIn(int level){
		ArrayList<Declaration> daEliminare = new ArrayList<Declaration>();
		
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
		Declaration toCompare = new Declaration(variableName, variableName, level, 0, 0);
		
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
