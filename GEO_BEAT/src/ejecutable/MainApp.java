package ejecutable;

import de.voidplus.myo.*;

import peasy.PeasyCam;
import processing.core.PApplet;

public class MainApp extends PApplet {

	private Logica logica;
	private Myo myo;
	private PeasyCam cam;

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
		// cam = new PeasyCam(this, 500);
		colorMode(HSB, 360, 100, 100);
		myo = new Myo(this, true);
		logica = new Logica(this, myo);
		background(0);
	}

	@Override
	public void draw() {
		// background(0);
		// lights();
		logica.draw();
	}
}
