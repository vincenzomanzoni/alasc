package it.unibg.alasc.errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe per che gestisce i vari tipi di errori che possono occorrere
 * durante la compilazione.
 * 
 * @author Andrea Rota
 *
 */
public class ErrorManager {
	
	private List<LexicalError> lexicalErrorList;
	private List<SemanticError> semanticErrorList;
	private List<SyntaxError> syntaxErrorList;
	
	/**
	 * Crea un'istanza della classe.
	 */
	public ErrorManager() {
		lexicalErrorList = new ArrayList<LexicalError>();
		semanticErrorList = new ArrayList<SemanticError>();
		syntaxErrorList = new ArrayList<SyntaxError>();
	}
	
	/**
	 * Aggiunge un errore lessicale.
	 * @param e L'errore lessicale da aggiungere.
	 */
	public void addError(LexicalError e) {
		lexicalErrorList.add(e);
	}	

	/**
	 * Aggiunge un errore sintattico.
	 * @param e L'errore sintattico da aggiungere.
	 */
	public void addError(SyntaxError e) {
		syntaxErrorList.add(e);
	}	
	
	/**
	 * Aggiunge un errore semantico.
	 * @param e L'errore semantico.
	 */
	public void addError(SemanticError e) {
		semanticErrorList.add(e);
	}	
	
	/**
	 * Restituisce l'insieme degli errori che sono accorsi durante la 
	 * compilazione.
	 * 
	 * @return La lista di errori; prima quelli lessicali, poi 
	 * quelli sintattici ed infine quelli semantici. All'interno di ogni 
	 * categoria, sono ordinati in ordine cronologico.
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
	 * Restituisce la lista degli errori lessicali.
	 * 
	 * @return La lista degli errori lessicali.
	 */
	public List<LexicalError> getLexicalErrorList() {
		return lexicalErrorList;
	}

	/**
	 * Restituisce la lista degli errori sintattici.
	 * 
	 * @return La lista degli errori sintattici.
	 */
	public List<SemanticError> getSemanticErrorList() {
		return semanticErrorList;
	}

	/**
	 * Restituisce la lista degli errori semantici.
	 * 
	 * @return La lista degli errori semantici.
	 */
	public List<SyntaxError> getSyntaxErrorList() {
		return syntaxErrorList;
	}
	
	/**
	 * Verifica se ci sono stati errori di qualunque tipo. 
	 * 
	 * @return <tt>true</tt> se si sono verificati errori di qualunque tipo,
	 * <tt>false</tt> altrimenti.
	 */
	public boolean hasErrors(){
		return 	!lexicalErrorList.isEmpty() ||
				!semanticErrorList.isEmpty() ||
				!syntaxErrorList.isEmpty();
	}
	
	/**
	 * Verifica se ci sono stati errori lessicali.
	 * 
	 * @return <tt>true</tt> se si sono verificati errori lesicali, 
	 * <tt>false</tt> altrimenti.
	 */
	public boolean hasLexicalErrors(){
		return 	!lexicalErrorList.isEmpty();
	}
	
	/**
	 * Verifica se ci sono stati errori sintattici.
	 * 
	 * @return <tt>true</tt> se si sono verificati errori sintattici, 
	 * <tt>false</tt> altrimenti.
	 */
	public boolean hasSyntaxErrors(){
		return 	!syntaxErrorList.isEmpty();
	}
	
	/**
	 * Verifica se ci sono stati errori semantici.
	 * 
	 * @return <tt>true</tt> se si sono verificati errori semantici, 
	 * <tt>false</tt> altrimenti.
	 */
	public boolean hasSemanticErrors(){
		return 	!semanticErrorList.isEmpty();
	}
}
