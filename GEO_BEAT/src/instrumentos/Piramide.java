package instrumentos;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Piramide extends MasterGeometry {

	private PApplet app;

	private PVector acel;

//	private float r;
	private float escala;
	private float velMax;
	private float maxForce;

	private float prof;

	public Piramide(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		escala = 5;

		prof = -2500;

		velMax = 5;
		maxForce = 0.1f;

		vel = new PVector(app.random(-5, 5), app.random(-5, 5), app.random(-5, 5));
		acel = new PVector();
	}

	@Override
	public void draw() {
		// System.out.println(tam);

//		r += 0.005f;
		app.pushMatrix();
		app.translate(pos.x, pos.y, pos.z);
		app.stroke(360);
		app.fill(360);
//		app.rotateX((r * -3) + theta);
		app.rotateY((r * -3) + theta);
		app.rotateZ((r * -3) + theta);
		puntos();
		app.pushMatrix();
		app.translate(250, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		app.beginShape(PConstants.TRIANGLE);

		// Caras de la piramide
		app.vertex(-tam, -tam, -tam);
		app.vertex(tam, -tam, -tam);
		app.vertex(0, 0, tam);

		app.vertex(tam, -tam, -tam);
		app.vertex(tam, tam, -tam);
		app.vertex(0, 0, tam);

		app.vertex(tam, tam, -tam);
		app.vertex(-tam, tam, -tam);
		app.vertex(0, 0, tam);

		app.vertex(-tam, tam, -tam);
		app.vertex(-tam, -tam, -tam);
		app.vertex(0, 0, tam);
		app.endShape();

		// Base de la piramide
		app.beginShape(PConstants.QUADS);
		app.vertex(-tam, -tam, -tam);
		app.vertex(tam, -tam, -tam);
		app.vertex(tam, tam, -tam);
		app.vertex(-tam, tam, -tam);
		app.endShape();
		
		app.popMatrix();
		app.popMatrix();

	}

	@Override
	public void puntos() {
		app.strokeWeight(grosor);
		for (int i = 0; i < 250; i++) {
			app.point(i, 0);
		}
//		 app.strokeWeight(1);
	}
	public float getTam() {
		return tam;
	}

	public void setTam(float tam) {
		this.tam = tam;
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
