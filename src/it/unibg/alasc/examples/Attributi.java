package it.unibg.alasc.examples;

import java.util.HashMap;

/**
 * Classe necessaria per il passaggio di attributi.
 * @author andrea
 *
 */

public class Attributi {
	private int parziale;
	private HashMap<String, Integer> prodotti;
	
	public Attributi() {
		parziale = 0;
		prodotti = new HashMap<String, Integer>();
	}
	
	public Attributi(HashMap<String, Integer> prodotti) {
		this();
		this.prodotti = prodotti;
	}
	
	public String toString() {
		return "Parziale = " + parziale + ", " +
			prodotti.toString();
	}

	public int getParziale() {
		return parziale;
	}

	public void setParziale(int parziale) {
		this.parziale = parziale;
	}
	
	public HashMap<String, Integer> getProdotti() {
		return prodotti;
	}
	
	public void aggiornaProdotti(String nomeProdotto, int qta) {
		if (prodotti.containsKey(nomeProdotto)) {
			prodotti.put(nomeProdotto, prodotti.get(nomeProdotto) + qta); 
		} else {
			prodotti.put(nomeProdotto, qta);
		}
	}
}
