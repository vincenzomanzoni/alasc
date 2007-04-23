package com.google.code.alasc;

/**
 * La classe implementa un semplice beautifier del codice.
 * 
 * @author Vincenzo Manzoni (vincenzo.manzoni@gmail.com)
 *
 */
public class SimpleBeautifier extends Beautifier {

	/**
	 * Costruttore che accetta come argomento il numero di tab iniziali.
	 * @param tabs Il numero di tab iniziali.
	 */
	public SimpleBeautifier(int tabs) {
		super(tabs);
	}

	/**
	 * Metodo che esegue il beautify del codice.
	 * @param code Il codice da "abbellire".
	 * @return Il codice "abbellito".
	 */
	public String beautify(String code) {
		StringBuffer buffer = new StringBuffer();
		
		/* La variabile booleana serve per gestire i ; all'interno
		delle parentesi tonde del for */
		boolean inFor = false;
		
		// Stringa da scrivere successivamente
		StringBuffer toWrite = new StringBuffer();
		
		int codeLength = code.length();
		char readChar;
		buffer.append(addTabs());
		
		for(int i = 0; i < codeLength; i++) {
			// Carattere della stringa da processare
			readChar = code.charAt(i);
			
			if ( (i+3) <= codeLength ) {
				if (code.substring(i, i+3).equals("for")) {
					inFor = true;
				}
			}
			
			if (readChar == ';' && inFor == true) {
				buffer.append(readChar);
			}
			
			if (readChar == ';' && inFor == false) {
				buffer.append(readChar);
				
				toWrite.append('\n');
				toWrite.append(addTabs());
			}
			
			if (readChar != ';' && readChar != '{' && readChar != '}') {
				if(toWrite.length() > 0) {
					buffer.append(toWrite.toString());
					toWrite = new StringBuffer();
				}
				buffer.append(readChar);
			}
			
			if (inFor == true && readChar == '{') {
				inFor = false;
			}
			
			if(readChar == '{') {
				buffer.append(readChar);
				
				toWrite.append('\n');
				this.tabs++;
				toWrite.append(addTabs());
			}
			
			if (readChar == '}') {
				buffer.append('\n');
				this.tabs--;
				buffer.append(addTabs());
				buffer.append(readChar);
	
				toWrite = new StringBuffer();
				toWrite.append('\n');
				toWrite.append(addTabs());
			}
			
		}
		return buffer.toString();
	}
	
	/**
	 * Aggiunge le tabulazioni ad inizio riga.
	 * @return La stringa composta da caratteri di tabulazione.
	 */
	private String addTabs() {
		String tabs = "";
		for(int i = 0; i < this.tabs; i++) {
			tabs += "\t";
		}
		return tabs;
	}

}
