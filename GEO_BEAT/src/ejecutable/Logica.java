package ejecutable;

import principal.Central;
import processing.core.PApplet;

public class Logica {

	private PApplet app;
	
	private Central central;

	public Logica(PApplet app) {
		this.app = app;
		
		central = new Central(app);
	}

	public void draw() {
		central.draw();
	}
}
