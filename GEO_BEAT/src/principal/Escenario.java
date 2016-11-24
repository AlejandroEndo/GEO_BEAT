package principal;

import processing.core.PApplet;
import processing.core.PConstants;

public class Escenario {

	private PApplet app;

	private float prof;

	private float tam;

	private float x;
	private float y;
	private float z;

	private float arcoProf;

	public Escenario(PApplet app, float prof) {
		this.app = app;
		this.prof = prof;

		tam = 200;
	}

	public Escenario(PApplet app, float x, float y, float z) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void draw() {
		app.fill(0, 50);
		app.stroke(360);
		app.beginShape(PConstants.QUADS);

		// fondo
		app.vertex(-tam, -tam, prof - arcoProf);
		app.vertex(app.width + tam, -tam, prof - arcoProf);
		app.vertex(app.width + tam, app.height + tam, prof - arcoProf);
		app.vertex(-tam, app.height + tam, prof - arcoProf);

		// Pared Izquierda
		app.vertex(-tam, -tam, 0);
		app.vertex(-tam, -tam, prof - 500);
		app.vertex(-tam, app.height + tam, prof - 500);
		app.vertex(-tam, app.height + tam, 0);

		// Pared Derecha
		app.vertex(app.width + tam, -tam, 0);
		app.vertex(app.width + tam, -tam, prof - 500);
		app.vertex(app.width + tam, app.height + tam, prof - 500);
		app.vertex(app.width + tam, app.height + tam, 0);

		// Techo
		app.vertex(-tam, -tam, 0);
		app.vertex(-tam, -tam, prof - 500);
		app.vertex(app.width + tam, -tam, prof - 500);
		app.vertex(app.width + tam, -tam, 0);

		// Suelo
		app.vertex(-tam, app.height + tam, 0);
		app.vertex(-tam, app.height + tam, prof - 500);
		app.vertex(app.width + tam, app.height + tam, prof - 500);
		app.vertex(app.width + tam, app.height + tam, 0);

		app.endShape();
	}

	public void electro() {
		// app.point(x+tam, y+tam, z);
		app.stroke(PApplet.map(y, app.height, 0, 0, 270), 50, 50);
		app.line(x + tam, y + 200, z - 200, x + tam, app.height + 200, z - 200);
		app.line(-200, y + 200, z - 200, -200, app.height + 200, z - 200);
		z += 10;
	}

	public float getZ() {
		return z;
	}

	public float getProf() {
		return prof;
	}

	public void setProf(float prof) {
		this.prof = prof;
	}

	public void setArcoProf(float arcoProf) {
		this.arcoProf = arcoProf;
	}

	public float getArcoProf() {
		return arcoProf;
	}

}
