package it.unibg.alasc.test;

import it.unibg.alasc.errors.ErrorManager;
import it.unibg.alasc.errors.LexicalError;
import it.unibg.alasc.errors.SemanticError;
import it.unibg.alasc.errors.SyntaxError;

import java.util.List;

import junit.framework.TestCase;

/**
 * Unit test for <tt>ErrorManager</tt>.
 * 
 * @author Vincenzo Manzoni
 */
public class ErrorManagerTest extends TestCase {
	
	private ErrorManager errorManager;
	
	public ErrorManagerTest() {
		errorManager = new ErrorManager();
	}
	
	// Test: add one lexical error and make sure the manager stores it
	public void testGetLexicalErrorList() {
		
		// Create the error
		LexicalError lexicalError =new LexicalError(1, 1, "Lexical error!") ;
		
		// Add it to the manager
		errorManager.addError(lexicalError);
		List<LexicalError> list = errorManager.getLexicalErrorList();
		
		// The manager should now contains one and only one error
		assertTrue(list.size() == 1);
		assertTrue(lexicalError.equals(list.get(0)));
	}

	// Test: same as previous, with semantic error
	public void testGetSemanticErrorList() {
		SemanticError semanticError = new SemanticError(1, 1, "Semantic error!") ;
		errorManager.addError(semanticError);
		List<SemanticError> list = errorManager.getSemanticErrorList();
		assertTrue(list.size() == 1);
		assertTrue(semanticError.equals(list.get(0)));
	}
	
	// Test: same as previous, with syntax error
	public void testGetSyntaxErrorList() {
		SyntaxError syntaxError = new SyntaxError(1, 1, "Syntax error!") ;
		errorManager.addError(syntaxError);
		List<SyntaxError> list = errorManager.getSyntaxErrorList();
		assertTrue(list.size() == 1);
		assertTrue(syntaxError.equals(list.get(0)));
	}

	// Test: check if has errors is false when manager has not recorded any error, true otherwise
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
	
	// Test: check if hasLexicalErrors method returns true
	public void testHasLexicalErrors() {
		LexicalError lexicalError =new LexicalError(1, 1, "Lexical error!") ;
		
		assertFalse(errorManager.hasLexicalErrors());
		errorManager.addError(lexicalError);		
		assertTrue(errorManager.hasLexicalErrors());
	}

	// Test: check if hasSyntaxErrors method returns true
	public void testHasSyntaxErrors() {
		SyntaxError syntaxError = new SyntaxError(1, 1, "Syntax error!") ;
		
		assertFalse(errorManager.hasSyntaxErrors());
		errorManager.addError(syntaxError);
		assertTrue(errorManager.hasSyntaxErrors());
	}

	// Test: check if hasSemanticErrors method returns true
	public void testHasSemanticErrors() {
		SemanticError semanticError = new SemanticError(1, 1, "Semantic error!") ;
		
		assertFalse(errorManager.hasSemanticErrors());
		errorManager.addError(semanticError);		
		assertTrue(errorManager.hasSemanticErrors());
	}

}
