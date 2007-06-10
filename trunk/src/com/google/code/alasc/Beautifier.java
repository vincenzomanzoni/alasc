package com.google.code.alasc;

/**
 * Generica classe Beautifier.
 * 
 * @author Vincenzo Manzoni (vincenzo.manzoni@gmail.com)
 */
public abstract class Beautifier {
	protected int tabs;
	
	/**
	 * Costruttore richiamato dalle classi derivate.
	 * 
	 * @param tabs Il numero di tabulazioni iniziali.
	 */
	public Beautifier(int tabs) {
		this.tabs = tabs;
	}
	
	/**
	 * Il metodo che le classi derivate dovranno implementare e che eseguirà
	 * la formattazione del codice.
	 * 
	 * @param code Il codice da formattare.
	 * @return Il codice formattato.
	 */
	public abstract String beautify(String code);	
}
