package instrumentos;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Sphere extends MasterGeometry {

	private PApplet app;

	private PVector acel;

	// private float r;
	private float escala;
	private float velMax;
	private float maxForce;
	private float prof;

	public Sphere(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		escala = 4;

		prof = -2500;

		velMax = 5;
		maxForce = 0.1f;

		vel = new PVector(app.random(-5, 5), app.random(-5, 5), app.random(-5, 5));
		acel = new PVector();
		app.sphereDetail(10, 7);
	}

	@Override
	public void draw() {

		// r += 0.005f;
		app.pushMatrix();
		app.translate(pos.x, pos.y, pos.z);
		app.rotateX((r * -3) + theta);
		app.rotateY((r * -3) + theta);
		// app.rotateZ((r * -3) + theta);
		puntos();
		app.pushMatrix();
		app.translate(250, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		app.sphere(tam);
		app.popMatrix();
		app.popMatrix();

	}

	@Override
	public void puntos() {
		app.strokeWeight(grosor);
		for (int i = 0; i < 250; i++) {
			app.point(i, 0);
		}
//		app.strokeWeight(1);
	}

	public void setTam(float tam) {
		this.tam = tam;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}

	public PVector getPos() {
		return pos;
	}

	@Override
	public void setVel(PVector vel) {
		this.vel = vel;
	}

	@Override
	public PVector getVel() {
		return vel;
	}

}
