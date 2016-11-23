package ejecutable;

import processing.core.PApplet;

public class MainApp extends PApplet {

	private Logica logica;
	
	public static void main(String[] args) {
		PApplet.main("ejecutable.MainApp");
	}

	@Override
	public void settings() {
		size(1200, 700, P3D);
		// fullScreen(P3D);
	}
	
	@Override
	public void setup() {
		logica = new Logica(this);
	}
	
	@Override
	public void draw() {
		background(0);
		lights();
		logica.draw();
	}
}
