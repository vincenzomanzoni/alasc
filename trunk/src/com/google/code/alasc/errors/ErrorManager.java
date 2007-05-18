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
	public void addError(Error e) {
		if(e instanceof LexicalError)
			lexicalErrorList.add((LexicalError)e);
		
		if(e instanceof SyntaxError)
			syntaxErrorList.add((SyntaxError)e);
		
		if(e instanceof SemanticError)
			lexicalErrorList.add((LexicalError)e);
		
	}
	
	/**
	 * @return una lista di errori registrati. L'ordinamento è errori lessicali
	 * errori sintattici ed errori semantici, successivamente cronologico.
	 */
	public List<Error> getAllErrors(){
		List<Error> listaErrori = new ArrayList<Error>();
		
		listaErrori.addAll(lexicalErrorList);
		listaErrori.addAll(syntaxErrorList);
		listaErrori.addAll(semanticErrorList);
		
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
	
}
