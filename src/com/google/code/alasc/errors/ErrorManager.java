package com.google.code.alasc.errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe per l'oggetto che gestisce le segnalazioni d'errore.
 * 
 * @author andrea
 *
 */
public class ErrorManager {
	
	List<LexicalError> lexicalErrorList;
	List<SemanticError> semanticErrorList;
	List<SyntaxError> syntaxErrorList;
	
	public ErrorManager() {
		lexicalErrorList = new ArrayList<LexicalError>();
		semanticErrorList = new ArrayList<SemanticError>();
		syntaxErrorList = new ArrayList<SyntaxError>();
	}
	
	/**
	 * 
	 * @param e errore da aggiungere
	 */
	//TODO Sistemare sta merda!
	public void addError(LexicalError e) {
		lexicalErrorList.add(e);
	}	

	public void addError(SyntaxError e) {
		syntaxErrorList.add(e);
	}	
	public void addError(SemanticError e) {
		semanticErrorList.add(e);
	}	
	
	/**
	 * @return una lista di errori registrati. L'ordinamento � errori lessicali
	 * errori sintattici ed errori semantici, successivamente cronologico.
	 */
	public List<GenericError> getAllErrors(){
		List<GenericError> listaErrori = new ArrayList<GenericError>();
		
		if(!lexicalErrorList.isEmpty()){
			listaErrori.addAll(lexicalErrorList);
		} else if(!syntaxErrorList.isEmpty()){
			listaErrori.addAll(syntaxErrorList);
		} else if(!semanticErrorList.isEmpty()){
			listaErrori.addAll(semanticErrorList);
		}
		
		return listaErrori;
	}

	/**
	 * @return the lexicalErrorList
	 */
	public List<LexicalError> getLexicalErrorList() {
		return lexicalErrorList;
	}

	/**
	 * @return the semanticErrorList
	 */
	public List<SemanticError> getSemanticErrorList() {
		return semanticErrorList;
	}

	/**
	 * @return the syntaxErrorList
	 */
	public List<SyntaxError> getSyntaxErrorList() {
		return syntaxErrorList;
	}
	
	public boolean hasErrors(){
		return 	!lexicalErrorList.isEmpty() ||
				!semanticErrorList.isEmpty() ||
				!syntaxErrorList.isEmpty();
	}
	
	public boolean hasLexicalErrors(){
		return 	!lexicalErrorList.isEmpty();
	}
	
	public boolean hasSyntaxErrors(){
		return 	!syntaxErrorList.isEmpty();
	}
	
	public boolean hasSemanticErrors(){
		return 	!semanticErrorList.isEmpty();
	}
}
