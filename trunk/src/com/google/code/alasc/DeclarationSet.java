package com.google.code.alasc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class DeclarationSet {
	
	private HashSet<Declaration> declarations;
	private ArrayList<Declaration> history;
	private Random random = new Random();
	
	/**
	 * Genera un nome unico per una data variabile, aggiungendo una parte casuale.
	 * 
	 * @param varName Il nome della variabile.
	 * @return varName Il nome della variabile seguita da un nonce.
	 */
	private String nextUniqueVariableName(String varName) {
		String uvn = Integer.toString(Math.abs(random.nextInt()), 36);
		return varName+uvn;
	}
	
	/**
	 * Costruisce un'istanza di <tt>DeclarationSet</tt>.
	 *
	 */
	public DeclarationSet(){
		declarations = new HashSet<Declaration>();
		history = new ArrayList<Declaration>();
	}
	
	/**
	 * Inserisce la dichiarazione di una nuova variabile nell'insieme
	 * delle variabili dichiarate.
	 * 
	 * @param variableName Il nome della variabile (case sensitive).
	 * @param level La profondità del blocco in cui avviene la dichiarazione.
	 * @return <tt>true</tt> se la variabile non era già stata dichiarata nel 
	 * livello corrente, <tt>false</tt> altrimenti.
	 */
	public boolean addDeclaration(String variableName, int level, int beginLine, int beginColumn){
		
		// TO-DO CERCARE SE E' LA PRIMA
		String uniqueName = variableName;
		
		for(Declaration s: history){
			if(s.getVariableName().equals(variableName)){
				// Se il nome per la variabile Ã¨ giÃ  stato usato, se ne genera uno unico
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
	 * La risolvibilità  di una variabile può essere controllata con il metodo <tt>isReachable</tt>.
	 * 
	 * @param varName Il nome della variabile.
	 * @param level La profondità del blocco.
	 * @return La dichirazione del simbolo.
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
	 * Elimina tutti dall'insieme delle variabili dichiarate quelle 
	 * appartenenti al blocco indicato dal parametro <tt>level</tt>.
	 * 
	 * @param level Indica la profondità del blocco di cui fare pruning.
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
	 * Controlla se la variable con nome variableName può essere dichiarata
	 * nel blocco di profondità <tt>level</tt>.
	 * 
	 * Il metodo controlla che non ci siano già dichiarazioni della variabile
	 * nello stesso blocco.
	 * 
	 * @param variableName Il nome della variabile.
	 * @param level La profondità del blocco.
	 * @return <tt>true</tt> se non ci sono già dichiarazioni della variabile nel blocco,
	 * altrimenti <tt>false</tt>.
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
	 * <tt>level</tt>.
	 * 
	 * Il metodo controlla che esista una almeno una dichiarazione della variabile
	 * variableName al livello corrente o a quelli precedenti, visibili quindi dallo
	 * scope di level.
	 * 
	 * @param variableName Il nome della variabile.
	 * @param level La profondità del blocco.
	 * @return <tt>true se nello scope visibile dal blocco a profondità <tt>level</tt> la variabile
	 * <tt>variableName</tt> risulta visibile, altrimenti <tt>false</tt>.
	 */
	public boolean isReachable(String variableName, int level){
		for(Declaration s: declarations){
			if(s.getVariableName().equals(variableName))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Setta una variabile <tt>varname</tt> utilizzata ad un certo livello
	 * 
	 * @param varname Il nome della variabile.
	 * @param level La profondità del blocco.
	 */
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
	
	/**
	 * Restituisce tutte le dichiarazioni avvenute all'interno del listato.
	 * @return La lista delle dichiarazioni.
	 */
	public ArrayList<Declaration> getHistory() {
		return this.history;
	}

	/**
	 * Restituisce tutte le dichiarazioni attualmente attive (not pruned)
	 * @return La lista della dichiarazioni attive.
	 */
	public HashSet<Declaration> getDeclarations() {
		return declarations;
	}
	
	
}
