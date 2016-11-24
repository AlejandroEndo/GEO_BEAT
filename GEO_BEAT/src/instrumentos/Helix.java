package instrumentos;

import processing.core.PApplet;
import processing.core.PVector;

public class Helix extends MasterGeometry {

	private PApplet app;

	private PVector acel;

	private PVector vertices[];
	private PVector verticesDos[];

	// private float r;
	private float escala;
	private float velMax;
	private float maxForce;
	private float prof;

	private int pts;
	private int segments;
	private float latheAngle;
	private float angle;
	private float radius;

	public Helix(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		// helix values
		pts = 6;
		segments = 12;
		latheAngle = 12;
		angle = 0;
		radius = 30;

		// general values
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
		app.fill(360, 100);
		// app.rotateX((r * 2) + theta);
		app.rotateY((r * 2) + theta);
		app.rotateZ((r * 2) + theta);
		puntos();
		app.pushMatrix();
		app.translate(500, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		helixDraw();
		app.popMatrix();
		app.popMatrix();

	}

	private void helixDraw() {
		vertices = new PVector[pts + 1];
		verticesDos = new PVector[pts + 1];

		for (int i = 0; i <= pts; i++) {
			vertices[i] = new PVector();
			verticesDos[i] = new PVector();
			vertices[i].x = (tam - 10) + PApplet.sin(PApplet.radians(angle)) * radius;
			vertices[i].z = PApplet.cos(PApplet.radians(angle)) * radius - segments / 2;
			angle += 360.0 / pts;
		}

		// draw toroid
		latheAngle = 0;
		for (int i = 0; i <= segments; i++) {
			app.beginShape(PApplet.QUAD_STRIP);
			for (int j = 0; j <= pts; j++) {
				if (i > 0) {
					app.vertex(verticesDos[j].x, verticesDos[j].y, verticesDos[j].z);
				}
				verticesDos[j].x = PApplet.cos(PApplet.radians(latheAngle)) * vertices[j].x;
				verticesDos[j].y = PApplet.sin(PApplet.radians(latheAngle)) * vertices[j].x;
				verticesDos[j].z = vertices[j].z;
				// optional helix offset
				// vertices[j].z+=helixOffset;
				app.vertex(verticesDos[j].x, verticesDos[j].y, verticesDos[j].z);
			}
			// create extra rotation for helix
			latheAngle += 720.0 / segments;
			app.endShape();
		}

	}

	@Override
	public void puntos() {
		app.strokeWeight(grosor);
		for (int i = 0; i < 500; i++) {
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