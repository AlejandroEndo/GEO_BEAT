package instrumentos;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Diamond extends MasterGeometry {

	private PApplet app;

	private PVector acel;

//	private float r;
	private float escala;

	private float velMax;
	private float maxForce;

	private float prof;

	public Diamond(PApplet app, PVector pos, float tam, float theta) {
		super(app, pos, tam, theta);
		this.app = app;

		escala = 5;

		prof = -2500;

		velMax = 5;
		maxForce = 0.1f;

		vel = new PVector(app.random(-5, 5), app.random(-5, 5), app.random(-5, 5));
		acel = new PVector();
		
		this.tam-=10;
	}

	@Override
	public void draw() {
		
//		r += 0.005f;
		app.pushMatrix();
		app.translate(pos.x, pos.y, pos.z);
		app.stroke(360);
		app.fill(360);
		app.rotateX((r * 2) + theta);
		app.rotateY((r * 2) + theta);
//		app.rotateZ((r * 2) + theta);
		puntos();
		app.pushMatrix();
		app.translate(500, 0);
		app.rotateX(r);
		app.rotateY(r);
		app.rotateZ(r);
		
		app.beginShape(PConstants.TRIANGLE);
		// Parte positiva Diamante
		app.vertex(-tam, -tam, 0);
		app.vertex(tam, -tam, 0);
		app.vertex(0, 0, tam * 2);

		app.vertex(tam, -tam, 0);
		app.vertex(tam, tam, 0);
		app.vertex(0, 0, tam * 2);

		app.vertex(tam, tam, 0);
		app.vertex(-tam, tam, 0);
		app.vertex(0, 0, tam * 2);

		app.vertex(-tam, tam, 0);
		app.vertex(-tam, -tam, 0);
		app.vertex(0, 0, tam * 2);

		// Parte negativa Diamante
		app.vertex(-tam, -tam, 0);
		app.vertex(tam, -tam, 0);
		app.vertex(0, 0, -tam * 2);

		app.vertex(tam, -tam, 0);
		app.vertex(tam, tam, 0);
		app.vertex(0, 0, -tam * 2);

		app.vertex(tam, tam, 0);
		app.vertex(-tam, tam, 0);
		app.vertex(0, 0, -tam * 2);

		app.vertex(-tam, tam, 0);
		app.vertex(-tam, -tam, 0);
		app.vertex(0, 0, -tam * 2);

		app.endShape();

		app.popMatrix();
		app.popMatrix();

	}

	@Override
	public void puntos() {
		app.strokeWeight(grosor);
		for (int i = 0; i < 500; i++) {
			app.point(i, 0);
		}
//		 app.strokeWeight(1);
	}
	
	public void setTam(float tam) {
		this.tam = tam;
	}

	public PVector getPos() {
		return pos;
	}
	
	public void setPos(PVector pos) {
		this.pos = pos;
	}
	
	 @Override
	 public void setVel(PVector vel) {
	 this.vel=vel;
	 }
	
	 @Override
	 public PVector getVel() {
	 return vel;
	 }

}
