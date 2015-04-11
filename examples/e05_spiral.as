package 
{
	import flash.display.Sprite;
	import flash.display.Shape;
	import flash.events.Event;

	public class e05_spiral extends Sprite 
	{
		private var shape : Shape;
		private var penX : Number;
		private var penY : Number;
		private var theta : Number;
		private var color : Number;
		private var isPenDown : Boolean;

		public function e05_spiral():void 
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
			var COLOR : Number;
			var STEP : Number;
			COLOR = 10000000;
			STEP = 10;
			for (var $7jjbi3 : Number = 0; $7jjbi3 < (10) ; $7jjbi3++) {
				setColor(COLOR);
				goForward(STEP);
				rotateRight(90);
				STEP = STEP * 3;
				STEP = STEP / 2;
				COLOR = COLOR + 50000;
			}
		}
	}
}