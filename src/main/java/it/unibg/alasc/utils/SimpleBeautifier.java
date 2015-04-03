package it.unibg.alasc.utils;


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
			
			/* Verifico se la prossima istruzione � un ciclo for.
			E' necessario questo controllo per evitare di mandare a capo i ;
			all'interno delle parentesi tonde.*/
			if ( (i+3) <= codeLength ) {
				if (code.substring(i, i+3).equals("for")) {
					inFor = true;
				}
			}
			
			/* Se � dentro non � dentro alle parentesi tonde di un for, vado a capo 
			e aggiungo i caratteri di tabulazione.*/
			if (readChar == ';' && inFor == false) {
				buffer.append(';');
				
				toWrite.append('\n');
				toWrite.append(addTabs());
			}
			else
			// Se il ; � dentro alle parentesi tonde di un for, non vado a capo
			if (readChar == ';' && inFor == true) {
				buffer.append(';');
			}
			
			// Tutti gli altri caratteri, li scrivo 
			if (readChar != ';' && readChar != '{' && readChar != '}') {
				if(toWrite.length() > 0) {
					buffer.append(toWrite.toString());
					toWrite = new StringBuffer();
				}
				buffer.append(readChar);
			}
			
			// Sono fuori dalle parentesi tonde del ciclo for
			if (inFor == true && readChar == '{') {
				inFor = false;
			}
			
			// Nuovo blocco -> aumento la tabulazione
			if(readChar == '{') {
				buffer.append('{');
				
				toWrite.append('\n');
				this.tabs++;
				toWrite.append(addTabs());
			}
			else 
			// Chiusura blocco -> riduco la tabulazione
			if (readChar == '}') {
				buffer.append('\n');
				this.tabs--;
				buffer.append(addTabs());
				buffer.append('}');
	
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
