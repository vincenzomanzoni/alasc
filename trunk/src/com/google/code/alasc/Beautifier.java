package com.google.code.alasc;

public abstract class Beautifier {
	protected int tabs;
	
	public Beautifier(int tabs) {
		this.tabs = tabs;
	}
	
	public abstract String beautify(String code);
	
}
