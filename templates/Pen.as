class Pen {

	var theta : Number;
	var x : Number;
	var y : Number;
	var isDown: Boolean;
	var color : Number;
	
	function Pen() {
		// La penna e' al centro dell'immagine 800x600
		x = 400;
		y = 300;
		
		// Orientamento iniziale verso NORD
		theta = Math.PI/2;
		
		// Colore NERO
		color = 0;
		
		isDown = true;
	}
	
}