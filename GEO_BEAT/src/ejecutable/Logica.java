package ejecutable;

import java.util.ArrayList;

import instrumentos.Cruz;
import instrumentos.Cubo;
import instrumentos.Diamond;
import instrumentos.Estrella;
import instrumentos.Helix;
import instrumentos.MasterGeometry;
import instrumentos.Piramide;
import instrumentos.Sphere;
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

	private ArrayList<MasterGeometry> instrumentos = new ArrayList<>();
	private ArrayList<Escenario> electro = new ArrayList<>();

	private int tam;

	public Logica(PApplet app) {
		this.app = app;

		fondo = new Escenario(app, -1000);
		central = new Central(app);
		musica = new Music(app);

		posInicial = new PVector(app.width / 2, app.height / 2, -500);

		tam = 50;

		// primera orbita
		instrumentos.add(new Cubo(app, posInicial, tam, (PConstants.TWO_PI / 3) * 1));
		instrumentos.add(new Sphere(app, posInicial, tam, (PConstants.TWO_PI / 3) * 2));
		instrumentos.add(new Piramide(app, posInicial, tam, (PConstants.TWO_PI / 3) * 3));

		// segunda orbita
		instrumentos.add(new Helix(app, posInicial, tam, (PConstants.TWO_PI / 4) * 1));
		instrumentos.add(new Estrella(app, posInicial, tam, (PConstants.TWO_PI / 4) * 2));
		instrumentos.add(new Cruz(app, posInicial, tam, (PConstants.TWO_PI / 4) * 3));
		instrumentos.add(new Diamond(app, posInicial, tam, (PConstants.TWO_PI / 4) * 4));

	}

	public void draw() {
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

		System.out.println(musica.getPromedio());

		if (central.getM() > 0) {
			central.setM(central.getM() - 0.5f);
		}
		if (central.getM() < 10) {
			// central.setM(PApplet.map(musica.getPromedio(), 0, 93, 4, 6));
			central.setM(central.getM() + PApplet.map(musica.getPromedio(), 0, 93, 0, 2));
		}

		for (int i = 0; i < instrumentos.size(); i++) {
			MasterGeometry m = instrumentos.get(i);
			m.draw();
			m.setR(m.getR() + 0.005f);
			m.setGrosor(grosor);
		}

	}
}
