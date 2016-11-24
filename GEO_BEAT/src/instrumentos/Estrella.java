package instrumentos;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Estrella extends MasterGeometry {

	private PApplet app;

	private PVector acel;

	private float r;
	private float escala;

	private float velMax;
	private float maxForce;

	private float prof;

	public Estrella(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		escala = 5;

		prof = -1000;

		velMax = 5;
		maxForce = 0.1f;

		vel = new PVector(app.random(-5, 5), app.random(-5, 5), app.random(-5, 5));
		acel = new PVector();
		this.tam -= 20;
	}

	public void draw() {
		r += 0.005f;
		app.pushMatrix();
		app.translate(pos.x, pos.y, pos.z);
		app.stroke(360);
		app.fill(360);
		app.rotateZ((r * 2) + theta);
		app.pushMatrix();
		app.translate(400, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		estrellaConstruir();
		app.popMatrix();
		app.popMatrix();
	}

	private void estrellaConstruir() {
		app.beginShape(PConstants.TRIANGLE);
		/////////////////////////////
		app.vertex(0, 0, tam);
		app.vertex(tam, -tam, 0);
		app.vertex(tam * 3, 0, 0);

		app.vertex(0, 0, tam);
		app.vertex(tam, tam, 0);
		app.vertex(tam * 3, 0, 0);
		/////////////////////////////
		app.vertex(0, 0, tam);
		app.vertex(0, tam * 3, 0);
		app.vertex(tam, tam, 0);

		app.vertex(0, 0, tam);
		app.vertex(0, tam * 3, 0);
		app.vertex(-tam, tam, 0);
		/////////////////////////////
		app.vertex(0, 0, tam);
		app.vertex(-tam, -tam, 0);
		app.vertex(-tam * 3, 0, 0);

		app.vertex(0, 0, tam);
		app.vertex(-tam, tam, 0);
		app.vertex(-tam * 3, 0, 0);
		/////////////////////////////
		app.vertex(0, 0, tam);
		app.vertex(0, -tam * 3, 0);
		app.vertex(tam, -tam, 0);

		app.vertex(0, 0, tam);
		app.vertex(0, -tam * 3, 0);
		app.vertex(-tam, -tam, 0);
		// -----------------------------------------------
		/////////////////////////////
		app.vertex(0, 0, -tam);
		app.vertex(tam, -tam, 0);
		app.vertex(tam * 3, 0, 0);

		app.vertex(0, 0, -tam);
		app.vertex(tam, tam, 0);
		app.vertex(tam * 3, 0, 0);
		/////////////////////////////
		app.vertex(0, 0, -tam);
		app.vertex(0, tam * 3, 0);
		app.vertex(tam, tam, 0);

		app.vertex(0, 0, -tam);
		app.vertex(0, tam * 3, 0);
		app.vertex(-tam, tam, 0);
		/////////////////////////////
		app.vertex(0, 0, -tam);
		app.vertex(-tam, -tam, 0);
		app.vertex(-tam * 3, 0, 0);

		app.vertex(0, 0, -tam);
		app.vertex(-tam, tam, 0);
		app.vertex(-tam * 3, 0, 0);
		/////////////////////////////
		app.vertex(0, 0, -tam);
		app.vertex(0, -tam * 3, 0);
		app.vertex(tam, -tam, 0);

		app.vertex(0, 0, -tam);
		app.vertex(0, -tam * 3, 0);
		app.vertex(-tam, -tam, 0);

		app.endShape();
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}
}
