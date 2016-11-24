package instrumentos;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class MasterGeometry {

	protected PApplet app;

	protected PVector pos;
	protected PVector vel;

	protected float tam;
	protected float theta;
	protected float r;
	protected float grosor;

	public MasterGeometry(PApplet app, PVector pos, float tam, float theta) {
		this.app = app;
		this.pos = pos;
		this.tam = tam;
		this.theta = theta;

		pos = new PVector();

	}

	public abstract void draw();

	public abstract void puntos();

	public PVector getPos() {
		return pos;
	}

	public float getTam() {
		return tam;
	}

	public void setTam(float tam) {
		this.tam = tam;
	}

	public void setVel(PVector vel) {
		this.vel = vel;
	}

	public PVector getVel() {
		return vel;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getGrosor() {
		return grosor;
	}

	public void setGrosor(float grosor) {
		this.grosor = grosor;
	}

}
