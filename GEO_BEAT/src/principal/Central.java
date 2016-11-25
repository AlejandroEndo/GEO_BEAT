package principal;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Central {

	private PApplet app;

	private PVector[][] globe;

	// cantidad de divisiones figura
	private int total;
	// variable para animacion
	private float mA;
	private float mB;
	// cambio de color
	private float off;
	// radio
	private float tam;

	// Rotacion de la esfera
	private float angle;

	private float change;

	// variables formula super shape
	private float a;
	private float b;

	private float nUnoA;
	private float nDosA;
	private float nTresA;

	private float nUnoB;
	private float nDosB;
	private float nTresB;

	public Central(PApplet app) {
		this.app = app;

		total = 50;

		globe = new PVector[total + 1][total + 1];

		a = 1;
		b = 1;

		tam = 150;
	}

	public void draw() {
		angle += 0.005f;
		app.pushMatrix();
		app.fill(360);
		// app.noStroke();
		app.translate(app.width / 2, app.height / 2, -500);
		app.rotateX(angle);
		app.rotateZ(angle);
		app.rotateY(angle);
		off += 5;

		// Variacion de la animacion---------------------------
		change += 0.01f;// velocidad de animacion
		// m = PApplet.map(PApplet.sin(change), -1, 1, 4, 10);
		// ----------------------------------------------------

		// Calcular valores para etablecer los puntos de la esfera
		// ---------------------------------------------------------
		for (int i = 0; i < total + 1; i++) {
			float lat = PApplet.map(i, 0, total, -PConstants.HALF_PI, PConstants.HALF_PI);
			float rDos = superShape(lat, mB, nUnoB, nDosB, nTresB);

			for (int j = 0; j < total + 1; j++) {
				float lon = PApplet.map(j, 0, total, -PConstants.PI, PConstants.PI);
				float rUno = superShape(lon, mA, nUnoA, nDosA, nTresA);

				float x = tam * rUno * PApplet.cos(lon) * rDos * PApplet.cos(lat);
				float y = tam * rUno * PApplet.sin(lon) * rDos * PApplet.cos(lat);
				float z = tam * rDos * PApplet.sin(lat);

				globe[i][j] = new PVector(x, y, z);
			}

		} // -----------------------------------------------------

		// Pintar la esfera ----------------------------------------
		for (int i = 0; i < total; i++) {
			app.beginShape(PConstants.TRIANGLE_STRIP);
			for (int j = 0; j < total + 1; j++) {
				PVector v = globe[i][j];
				app.vertex(v.x, v.y, v.z);
				PVector b = globe[i + 1][j];
				app.vertex(b.x, b.y, b.z);
			}
			app.endShape();
		} // -------------------------------------------------------
		app.popMatrix();
	}

	/**
	 * Metodo para la animacion de la esfera
	 * 
	 * @param theta
	 *            angulo (lat / lon)
	 * @param m
	 *            tamano de cambio
	 * @param nUno
	 *            n1 ecuacion
	 * @param nDos
	 *            n2 ecuacion
	 * @param nTres
	 *            n3 ecuacion
	 * @return r
	 */
	private float superShape(float theta, float m, float nUno, float nDos, float nTres) {
		float tUno = PApplet.abs((1 / a) * PApplet.cos(m * theta / 4));
		tUno = PApplet.pow(tUno, nDos);
		float tDos = PApplet.abs((1 / b) * PApplet.sin(m * theta / 4));
		tDos = PApplet.pow(tDos, nTres);
		float tTres = tUno + tDos;
		float r = PApplet.pow(tTres, -1 / nUno);
		return r;
	}

	public void setNa(float nUnoA, float nDosA, float nTresA) {
		this.nUnoA = nUnoA;
		this.nDosA = nDosA;
		this.nTresA = nTresA;
	}

	public void setNb(float nUnoB, float nDosB, float nTresB) {
		this.nUnoB = nUnoB;
		this.nDosB = nDosB;
		this.nTresB = nTresB;
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public PVector[][] getGlobe() {
		return globe;
	}

	public void setGlobe(PVector[][] globe) {
		this.globe = globe;
	}

	public float getTam() {
		return tam;
	}

	public void setTam(float tam) {
		this.tam = tam;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public float getmA() {
		return mA;
	}

	public void setmA(float mA) {
		this.mA = mA;
	}

	public float getmB() {
		return mB;
	}

	public void setmB(float mB) {
		this.mB = mB;
	}
	
}
