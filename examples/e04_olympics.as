package 
{
	import flash.display.Sprite;
	import flash.display.Shape;
	import flash.events.Event;

	public class e04_olympics extends Sprite 
	{
		private var shape : Shape;
		private var penX : Number;
		private var penY : Number;
		private var theta : Number;
		private var color : Number;
		private var isPenDown : Boolean;

		public function e04_olympics():void 
		{
			if (this.stage) {
				this.init(); 
			} else {
				this.addEventListener(Event.ADDED_TO_STAGE, init);
			}
		}

		private function init(e:Event = null):void 
		{
			this.removeEventListener(Event.ADDED_TO_STAGE, init);
			this.setupPen();
			this.draw();
		}

		private function setupPen():void
		{
			this.penX = 200; //this.width/2;
			this.penY = 200; //this.height/2;
			this.theta = Math.PI/2;
			this.color = 0;
			this.isPenDown = true;
			this.shape = new Shape();
			this.addChild(this.shape);
		}

		private function goForward(l : Number) : void {

			this.shape.graphics.lineStyle(1, this.color, 100);

			var newPenX:Number = this.penX + l * Math.cos(this.theta);
			var newPenY:Number = this.penY - l * Math.sin(this.theta);

			if (this.isPenDown) {
				this.shape.graphics.moveTo(this.penX, this.penY);
				this.shape.graphics.lineTo(newPenX, newPenY);
			}

			this.penX = newPenX;
			this.penY = newPenY;

		}

		private function goBackward(l : Number) : void {
			goForward(-l);
		}

		private function rotateLeft(relativeDegree : Number) : void {	
			this.theta = (this.theta + relativeDegree * Math.PI/180) % (2 * Math.PI);
		}

		private function rotateRight(relativeDegree : Number) : void {	
			rotateLeft(-relativeDegree);
		}

		private function penUp() : void  {
			this.isPenDown = false;
		}

		private function penDown() : void {
			this.isPenDown = true;
		}

		private function setColor(c : Number) : void {
			this.color = c % 16777215;
		}

		private function clearScreen() : void {
			this.shape.graphics.clear();
		}

		private function draw():void
		{
			setColor(255);
			for (var $yw0arp : Number = 0; $yw0arp < (360) ; $yw0arp++) {
				goForward(1);
				rotateRight(1);
			}
			penUp();
			rotateRight(90);
			goForward(120);
			rotateLeft(90);
			penDown();
			setColor(0);
			for (var $blfs7d : Number = 0; $blfs7d < (360) ; $blfs7d++) {
				goForward(1);
				rotateRight(1);
			}
			penUp();
			rotateRight(90);
			goForward(120);
			rotateLeft(90);
			penDown();
			setColor(16711680);
			for (var $wda9ex : Number = 0; $wda9ex < (360) ; $wda9ex++) {
				goForward(1);
				rotateRight(1);
			}
			penUp();
			rotateRight(90);
			goBackward(182);
			rotateLeft(90);
			goBackward(58);
			penDown();
			setColor(15520566);
			for (var $z00i71 : Number = 0; $z00i71 < (360) ; $z00i71++) {
				goForward(1);
				rotateRight(1);
			}
			penUp();
			rotateRight(90);
			goForward(120);
			rotateLeft(90);
			penDown();
			setColor(65280);
			for (var $ii9ge2 : Number = 0; $ii9ge2 < (360) ; $ii9ge2++) {
				goForward(1);
				rotateRight(1);
			}
		}
	}
}