package instrumentos;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Cruz extends MasterGeometry {

	private PApplet app;

	private PVector acel;

	// private float r;
	private float escala;
	private float velMax;
	private float maxForce;

	private float prof;

	public Cruz(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		escala = 4;

		prof = -2500;

		velMax = 5;
		maxForce = 0.1f;

		vel = new PVector(app.random(-5, 5), app.random(-5, 5), app.random(-5, 5));
		acel = new PVector();
	}

	@Override
	public void draw() {
		// r += 0.005f;
		app.pushMatrix();
		app.translate(pos.x, pos.y, pos.z);
		app.fill(360);
		app.stroke(360, 100);
		app.rotateX((r * 2) + theta);
		app.rotateY((r * 2) + theta);
		app.rotateZ((r * 2) + theta);
		app.pushMatrix();
		app.translate(500, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		construirCruz();
		app.popMatrix();
		app.popMatrix();
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	private void construirCruz() {
		app.beginShape(PConstants.QUADS);

		app.vertex(tam / 3, -tam / 3, tam / 3);
		app.vertex(tam, -tam / 3, tam / 3);
		app.vertex(tam, tam / 3, tam / 3);
		app.vertex(tam / 3, tam / 3, tam / 3);

		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam, -tam / 3, tam / 3);
		app.vertex(-tam, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, tam / 3);

		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, -tam, tam / 3);
		app.vertex(tam / 3, -tam, tam / 3);
		app.vertex(tam / 3, -tam / 3, tam / 3);

		app.vertex(-tam / 3, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam, tam / 3);
		app.vertex(tam / 3, tam, tam / 3);
		app.vertex(tam / 3, tam / 3, tam / 3);

		//////////////////////////////////////////////

		app.vertex(tam / 3, -tam / 3, -tam / 3);
		app.vertex(tam, -tam / 3, -tam / 3);
		app.vertex(tam, tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam / 3);

		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam, -tam / 3, -tam / 3);
		app.vertex(-tam, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam / 3);

		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam / 3, -tam, -tam / 3);
		app.vertex(tam / 3, -tam, -tam / 3);
		app.vertex(tam / 3, -tam / 3, -tam / 3);

		app.vertex(-tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam, -tam / 3);
		app.vertex(tam / 3, tam, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam / 3);

		//////////////////////////////////////////////

		app.vertex(tam / 3, -tam / 3, tam / 3);
		app.vertex(tam / 3, tam / 3, tam / 3);
		app.vertex(tam / 3, tam / 3, tam);
		app.vertex(tam / 3, -tam / 3, tam);

		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, tam);
		app.vertex(-tam / 3, -tam / 3, tam);

		app.vertex(tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, -tam / 3, tam);
		app.vertex(tam / 3, -tam / 3, tam);

		app.vertex(tam / 3, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, tam);
		app.vertex(tam / 3, tam / 3, tam);

		app.vertex(tam / 3, -tam / 3, tam);
		app.vertex(tam / 3, tam / 3, tam);
		app.vertex(-tam / 3, tam / 3, tam);
		app.vertex(-tam / 3, -tam / 3, tam);

		//////////////////////////////////////////////

		app.vertex(tam / 3, -tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam);
		app.vertex(tam / 3, -tam / 3, -tam);

		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam);
		app.vertex(-tam / 3, -tam / 3, -tam);

		app.vertex(tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam / 3, -tam / 3, -tam);
		app.vertex(tam / 3, -tam / 3, -tam);

		app.vertex(tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam);
		app.vertex(tam / 3, tam / 3, -tam);

		app.vertex(tam / 3, -tam / 3, -tam);
		app.vertex(tam / 3, tam / 3, -tam);
		app.vertex(-tam / 3, tam / 3, -tam);
		app.vertex(-tam / 3, -tam / 3, -tam);

		//////////////////////////////////////////////

		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam / 3, -tam, -tam / 3);
		app.vertex(-tam / 3, -tam, tam / 3);

		app.vertex(-tam / 3, -tam, tam / 3);
		app.vertex(-tam / 3, -tam, -tam / 3);
		app.vertex(tam / 3, -tam, -tam / 3);
		app.vertex(tam / 3, -tam, tam / 3);

		app.vertex(tam / 3, -tam, tam / 3);
		app.vertex(tam / 3, -tam, -tam / 3);
		app.vertex(tam / 3, -tam / 3, -tam / 3);
		app.vertex(tam / 3, -tam / 3, tam / 3);

		//////////////////////////////////////////////

		app.vertex(-tam / 3, tam / 3, tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam, -tam / 3);
		app.vertex(-tam / 3, tam, tam / 3);

		app.vertex(-tam / 3, tam, tam / 3);
		app.vertex(-tam / 3, tam, -tam / 3);
		app.vertex(tam / 3, tam, -tam / 3);
		app.vertex(tam / 3, tam, tam / 3);

		app.vertex(tam / 3, tam, tam / 3);
		app.vertex(tam / 3, tam, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, tam / 3);

		//////////////////////////////////////////////

		app.vertex(tam / 3, -tam / 3, tam / 3);
		app.vertex(tam / 3, -tam / 3, -tam / 3);
		app.vertex(tam, -tam / 3, -tam / 3);
		app.vertex(tam, -tam / 3, tam / 3);

		app.vertex(tam, -tam / 3, tam / 3);
		app.vertex(tam, -tam / 3, -tam / 3);
		app.vertex(tam, tam / 3, -tam / 3);
		app.vertex(tam, tam / 3, tam / 3);

		app.vertex(tam, tam / 3, tam / 3);
		app.vertex(tam, tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, -tam / 3);
		app.vertex(tam / 3, tam / 3, tam / 3);

		////////////////////////////////////////////////

		app.vertex(-tam / 3, -tam / 3, tam / 3);
		app.vertex(-tam / 3, -tam / 3, -tam / 3);
		app.vertex(-tam, -tam / 3, -tam / 3);
		app.vertex(-tam, -tam / 3, tam / 3);

		app.vertex(-tam, -tam / 3, tam / 3);
		app.vertex(-tam, -tam / 3, -tam / 3);
		app.vertex(-tam, tam / 3, -tam / 3);
		app.vertex(-tam, tam / 3, tam / 3);

		app.vertex(-tam, tam / 3, tam / 3);
		app.vertex(-tam, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, -tam / 3);
		app.vertex(-tam / 3, tam / 3, tam / 3);

		///////////////////////////////////////////////

		app.endShape();
	}

	@Override
	public void puntos() {
		// TODO Auto-generated method stub

	}

}
