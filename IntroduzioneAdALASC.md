# Introduzione #

L'acronimo ALASC significa _A Logo (to) ActionScript Compiler_. Esso è il risultato di un corso universitario di **Progetto di linguaggi formali e compilatori**.

# Dettagli #

Gli obiettivi del progetto sono:
  * Creare un compilatore che traduca un programma scritto con un sottoinsieme del linguaggio Logo in uno script in ActionScript, che una volta compilato in SWF disegni la stessa figura;
  * Sperimentare l'uso del compilatore di compilatori JavaCC.

## L'applicazione di test ##
Sotto si può osservare il diagramma della nostra applicazione di test, la quale prima usa ALASC per compilare un programma Logo in linguaggio ActionScript, quindi il compilatore [MTASC](http://code.google.com/p/alasc/wiki/UsareMTASC) per generare il file SWF, il quale è visibile all'interno di un browser web che abbia installato il plugin Flash.

![http://alasc.googlecode.com/files/diagramm.png](http://alasc.googlecode.com/files/diagramm.png)