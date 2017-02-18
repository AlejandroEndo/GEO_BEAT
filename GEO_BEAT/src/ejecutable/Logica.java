package ejecutable;

import java.util.ArrayList;

import de.voidplus.myo.*;

import instrumentos.Cruz;
import instrumentos.Cubo;
import instrumentos.Diamond;
import instrumentos.Estrella;
import instrumentos.Helix;
import instrumentos.MasterGeometry;
import instrumentos.Piramide;
import instrumentos.Sphere;
import myo.Jarvis;
import principal.Central;
import principal.Escenario;
import principal.Music;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Logica {

	private PApplet app;

	private PVector posInicial;

	private Escenario fondo;
	private Central central;
	private Music musica;

//	private Jarvis jarvis;
//	private Myo myo;

	private ArrayList<MasterGeometry> instrumentos = new ArrayList<>();
	private ArrayList<Escenario> electro = new ArrayList<>();

	private int tam;

	private float a;
	private float b;

	private boolean init;

	private String instrumento;

	public Logica(PApplet app) {
		this.app = app;
//		this.myo = myo;

		fondo = new Escenario(app, -1000);
		central = new Central(app);
		musica = new Music(app);

//		jarvis = new Jarvis(myo, app);

		posInicial = new PVector(app.width / 2, app.height / 2, -500);

		tam = 50;

		init = true;

		// primera orbita
		instrumentos.add(new Cubo(app, posInicial, tam, (PConstants.TWO_PI / 3) * 1));
		instrumentos.add(new Sphere(app, posInicial, tam, (PConstants.TWO_PI / 3) * 2));
		instrumentos.add(new Piramide(app, posInicial, tam, (PConstants.TWO_PI / 3) * 3));

		// segunda orbita
		instrumentos.add(new Helix(app, posInicial, tam, (PConstants.TWO_PI / 4) * 1));
		instrumentos.add(new Estrella(app, posInicial, tam, (PConstants.TWO_PI / 4) * 2));
		instrumentos.add(new Cruz(app, posInicial, tam, (PConstants.TWO_PI / 4) * 3));
		instrumentos.add(new Diamond(app, posInicial, tam, (PConstants.TWO_PI / 4) * 4));

		instrumento = "ELECTRONICO";
	}

	public void draw() {
		if (init) {
			superCentral(instrumento);
			init = false;
		}

		superAnimacion(instrumento);

		musica.vals();
		app.pushMatrix();
		app.translate(0, 0, -200);
		fondo.draw();
		fondo.setArcoProf(PApplet.map(musica.getPromedio(), 0, 93, 0, 200));
		app.popMatrix();
		app.directionalLight(0, 100, 100, 0, 0, -1);
		central.draw();

		electro.add(
				new Escenario(app, app.width + 200, PApplet.map(musica.getPromedio(), 0, 93, app.height, 0), -1000));

		for (int i = 0; i < electro.size(); i++) {
			electro.get(i).electro();
			if (electro.get(i).getZ() >= 10) {
				electro.remove(i);
			}
		}

		float grosor = PApplet.map(musica.getPromedio(), 0, 93, 1, 10);

		// System.out.println(musica.getPromedio());

		for (int i = 0; i < instrumentos.size(); i++) {
			MasterGeometry m = instrumentos.get(i);
			m.draw();
			m.setR(m.getR() + 0.005f);
			m.setGrosor(grosor);
		}

//		float altura = PApplet.map(jarvis.getOrientacion().y, 0.4f, 1, 0, -1500);

		app.beginShape(PConstants.QUADS);
		app.vertex(-200, app.height + 200, 0);
//		app.vertex(-200, app.height + 200, altura);
//		app.vertex(app.width + 200, app.height + 200, altura);
		app.vertex(app.width + 200, app.height + 200, 0);
		app.endShape();
	}

	private void superAnimacion(String instrumento) {
		switch (instrumento) {

		case "VIENTO":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "PERCUSION":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "CUERDA":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "ELECTRONICO":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "ACUSTICO":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "URBANO":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "NATURAL":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;

		case "ASTRAL":
			if (central.getmA() > 0 && central.getmB() > 0) {
				a -= 0.1f;
				b -= 0.1f;
				central.setmA(a);
				central.setmB(b);
				System.out.println(central.getmA());
			}

			if (central.getmA() < 7) {
				a += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmA(a);
			}

			if (central.getmB() < 7) {
				b += (PApplet.map(musica.getPromedio(), 0, 93, 0, 0.5f));
				central.setmB(b);
			}
			break;
		}
	}

	private void superCentral(String instrumento) {

		switch (instrumento) {

		case "VIENTO":
			central.setA(1);
			central.setB(1);
			central.setmA(2);
			central.setmB(3);
			central.setNa(0.7f, 0.3f, 0.2f);
			central.setNb(100f, 100f, 100f);

			break;

		case "PERCUSION":
			central.setA(1);
			central.setB(1);
			central.setmA(7);
			central.setmB(7);
			central.setNa(0.20f, 1.70f, 1.70f);
			central.setNb(0.20f, 1.70f, 1.70f);
			break;

		case "CUERDA":
			central.setA(1);
			central.setB(1);
			central.setmA(6);
			central.setmB(3);
			central.setNa(1f, 1f, 1f);
			central.setNb(1f, 1f, 1f);
			break;

		case "ELECTRONICO":
			central.setA(1);
			central.setB(1);
			central.setmA(6);
			central.setmB(6);
			central.setNa(60f, 55f, 1000f);
			central.setNb(250f, 100f, 100f);
			central.setTam(75);
			break;

		case "ACUSTICO":
			central.setA(1);
			central.setB(1);
			central.setmA(5.7f);
			central.setmB(10);
			central.setNa(0.5f, 1f, 2.5f);
			central.setNb(3f, 0.2f, 1f);
			break;

		case "URBANO":
			central.setA(1);
			central.setB(1);
			central.setmA(6);
			central.setmB(7);
			central.setNa(0.709889f, 46.8299f, -0.802f);
			central.setNb(-31.9083f, -0.196521f, 97.03f);
			break;

		case "NATURAL":
			central.setA(1);
			central.setB(1);
			central.setmA(2);
			central.setmB(7);
			central.setNa(0.990241f, 97.6722f, -0.439f);
			central.setNb(-8.11486f, -0.0807913f, 93.599f);
			break;

		case "ASTRAL":
			central.setA(1);
			central.setB(1);
			central.setmA(2);
			central.setmB(1);
			central.setNa(0.437933f, 13.1909f, 0.6489f);
			central.setNb(-21.8776f, 0.637533f, 68.801f);
			central.setTam(100);
			break;
		}
	}
}
