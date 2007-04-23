package com.google.code.alasc;

/**
 * Generica classe Beautifier.
 * 
 * @author Vincenzo Manzoni (vincenzo.manzoni@gmail.com)
 */
public abstract class Beautifier {
	protected int tabs;
	
	public Beautifier(int tabs) {
		this.tabs = tabs;
	}
	
	public abstract String beautify(String code);	
}
