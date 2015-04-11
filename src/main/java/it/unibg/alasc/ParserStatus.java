package it.unibg.alasc;

/**
 * 
 * Exit status for parsing process
 * 
 * @author Andrea Rota
 *
 */
public enum ParserStatus {
	COMPILED,
	TEMPLATEERRORS,
	LEXICALERRORS,
	SYNTAXERRORS,
	SEMANTICERRORS;
}
