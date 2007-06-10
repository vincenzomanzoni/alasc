package com.google.code.alasc;

/**
 * Enumerazione per descrivere i possibili stati in cui si pu� trovare
 * il parser alla fine della compilazione.
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
