package com.google.code.alasc;

public class Controller {

	String fileInput;
	String fileOutput;
	// Se passo out.as come file in uscita, avr˜ out.ts tabella dei simboli e out.err
	String fileOutputPrefix;
	
	boolean symbolTableEnabled;
	
	public Controller(String fileInput){
		this(fileInput, fileInput, false);
	}
	
	public Controller(String fileInput, boolean symbolTableEnabled){
		this(fileInput, fileInput, symbolTableEnabled);
	}
	
	public Controller(String fileInput, String fileOutput) {
		this(fileInput, fileOutput, false);
	}
	
	
	public Controller(String fileInput, String fileOutput, boolean symbolTableEnabled) {
		super();
		this.fileInput = fileInput;
		this.fileOutput = fileOutput;
		this.symbolTableEnabled = symbolTableEnabled;
		
		//TODO: fare il calcolo del prefisso
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
