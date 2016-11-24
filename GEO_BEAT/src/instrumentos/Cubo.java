package instrumentos;

import processing.core.PApplet;
import processing.core.PVector;

public class Cubo extends MasterGeometry {

	private PApplet app;

	private PVector acel;

	// private float r;
	private float escala;
	private float velMax;
	private float maxForce;

	private float prof;

	public Cubo(PApplet app, PVector pos, float tam, float theta) {
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
		app.fill(360);
		app.stroke(360, 100);
		app.rotateX((r * -3) + theta);
		// app.rotateY((r * -3) + theta);
		app.rotateZ((r * -3) + theta);
		puntos();
		app.pushMatrix();
		app.translate(250, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		app.box(tam);
		app.popMatrix();
		app.popMatrix();
		// mover();
		// orbita();
	}

	@Override
	public void puntos() {
		for (int i = 0; i < 250; i++) {
			app.point(i, 0);
		}
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

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

}
