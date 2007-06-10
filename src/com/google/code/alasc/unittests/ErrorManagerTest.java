package com.google.code.alasc.unittests;

import java.util.List;

import com.google.code.alasc.errors.ErrorManager;
import com.google.code.alasc.errors.LexicalError;
import com.google.code.alasc.errors.SemanticError;
import com.google.code.alasc.errors.SyntaxError;

import junit.framework.TestCase;

/**
 * Test di unità della classe <tt>ErrorManager</tt>.
 * 
 * @author Vincenzo Manzoni
 */
public class ErrorManagerTest extends TestCase {
	ErrorManager errorManager;
	
	/**
	 * Inizializza l'istanza di <tt>ErrorManager</tt> che verrà usata
	 * da tutti i test.
	 *
	 */
	public ErrorManagerTest() {
		errorManager = new ErrorManager();
	}
	
	/**
	 * Verifica che la funzione restituisca gli errori lessicali inseriti.
	 */
	public void testGetLexicalErrorList() {		
		LexicalError lexicalError =new LexicalError(1, 1, "Lexical error!") ;
		errorManager.addError(lexicalError);
		List list = errorManager.getLexicalErrorList();
		// Verifico che la lista di errori lessicali sia lunga 1
		assertTrue(list.size() == 1);
		// Verifico che mi sia restituito l'oggetto che ho inserito
		assertTrue(lexicalError.equals(list.get(0)));
	}

	/**
	 * Verifica che la funzione restituisca gli errori semantici inseriti.
	 *
	 */
	public void testGetSemanticErrorList() {
		SemanticError semanticError = new SemanticError(1, 1, "Semantic error!") ;
		errorManager.addError(semanticError);
		List list = errorManager.getSemanticErrorList();
		// Verifico che la lista di errori semantici sia lunga 1
		assertTrue(list.size() == 1);
		// Verifico che mi sia restituito l'oggetto che ho inserito
		assertTrue(semanticError.equals(list.get(0)));
	}
	
	/**
	 * Verifica che la funzione restituisca gli errori sintattici inseriti.
	 *
	 */
	public void testGetSyntaxErrorList() {
		SyntaxError syntaxError = new SyntaxError(1, 1, "Syntax error!") ;
		errorManager.addError(syntaxError);
		List list = errorManager.getSyntaxErrorList();
		// Verifico che la lista di errori sintattici sia lunga 1
		assertTrue(list.size() == 1);
		// Verifico che mi sia restituito l'oggetto che ho inserito
		assertTrue(syntaxError.equals(list.get(0)));
	}

	/**
	 * Verifica che la funzione restituisca che si sono verificati errori 
	 * se ne è stato inserito almeno uno.
	 *
	 */
	public void testHasErrors() {
		assertFalse(errorManager.hasErrors());
		
		SyntaxError syntaxError = new SyntaxError(1, 1, "Syntax error!") ;
		errorManager.addError(syntaxError);
		
		LexicalError lexicalError =new LexicalError(1, 1, "Lexical error!") ;
		errorManager.addError(lexicalError);
		
		SemanticError semanticError = new SemanticError(1, 1, "Semantic error!") ;
		errorManager.addError(semanticError);
		
		assertTrue(errorManager.hasErrors());
	}
	
	/**
	 * Verifica che la funzione restituisca che si sono verificati errori
	 * lessicali se ne è stato inserito almeno uno.
	 *
	 */
	public void testHasLexicalErrors() {
		LexicalError lexicalError =new LexicalError(1, 1, "Lexical error!") ;
		
		assertFalse(errorManager.hasLexicalErrors());
		errorManager.addError(lexicalError);		
		assertTrue(errorManager.hasLexicalErrors());
	}

	/**
	 * Verifica che la funzione restituisca che si sono verificati errori
	 * sintattici se ne è stato inserito almeno uno.
	 *
	 */
	public void testHasSyntaxErrors() {
		SyntaxError syntaxError = new SyntaxError(1, 1, "Syntax error!") ;
		
		assertFalse(errorManager.hasSyntaxErrors());
		errorManager.addError(syntaxError);
		assertTrue(errorManager.hasSyntaxErrors());
	}

	/**
	 * Verifica che la funzione restituisca che si sono verificati errori
	 * semantici se ne è stato inserito almeno uno.
	 *
	 */
	public void testHasSemanticErrors() {
		SemanticError semanticError = new SemanticError(1, 1, "Semantic error!") ;
		
		assertFalse(errorManager.hasSemanticErrors());
		errorManager.addError(semanticError);		
		assertTrue(errorManager.hasSemanticErrors());
	}

}
