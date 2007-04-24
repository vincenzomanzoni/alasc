class Disegno {
	
	var penna : Pen;
	
	function goForward(lunghezza : Number){
			
		_root.lineStyle(1,penna.color, 100);
			
		if (penna.isDown) {
			_root.moveTo(penna.x, penna.y);
			_root.lineTo(penna.x + lunghezza * Math.cos(penna.theta),
				penna.y - lunghezza * Math.sin(penna.theta));
		}
		
		penna.x = penna.x + lunghezza * Math.cos(penna.theta);
		penna.y = penna.y - lunghezza * Math.sin(penna.theta);
	}
	
	function goBackward(lunghezza : Number){
		goForward(-lunghezza);
	}
		
	function rotateLeft(delta_angolo : Number){	
		penna.theta = (penna.theta + delta_angolo * Math.PI/180) % (2 * Math.PI);
	}
	
	function rotateRight(delta_angolo : Number){	
		rotateLeft(-delta_angolo);
	}
	
	function penUp() {
		penna.isDown = false;
	}
	
	function penDown() {
		penna.isDown = true;
	}
	
	function setColor(color : Number) {
		penna.color = color % 16777215;
	}
	
	function clearScreen() {
		_root.clear();
	}
	
	function Disegno() {
		penna = new Pen();
		
		var A : Number;
		A = 2;
		goForward(10);
		rotateRight(90);
		for (var $uy0wkp : Number = 0; $uy0wkp < (10) ; $uy0wkp++) {
			goForward(5);
			rotateRight(90);
			for (var $ovhmoo : Number = 0; $ovhmoo < (10 + 20) ; $ovhmoo++) {
				goForward(100);
			}
		}
		goForward(10);
		rotateRight(90);	
	}

	static function main(mc) {
		var app : Disegno = new Disegno();
	}
}

