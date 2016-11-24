package ejecutable;

import java.util.ArrayList;

import instrumentos.Cubo;
import instrumentos.Diamond;
import instrumentos.Estrella;
import instrumentos.Helix;
import instrumentos.MasterGeometry;
import instrumentos.Piramide;
import instrumentos.Sphere;
import principal.Central;
import principal.Escenario;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Logica {

	private PApplet app;

	private PVector posInicial;

	private Escenario fondo;
	private Central central;

	private ArrayList<MasterGeometry> instrumentos = new ArrayList<>();

	private int tam;

	public Logica(PApplet app) {
		this.app = app;

		fondo = new Escenario(app, -1000);
		central = new Central(app);

		posInicial = new PVector(app.width / 2, app.height / 2, -500);

		tam = 50;

		// primera orbita
		instrumentos.add(new Cubo(app, posInicial, tam, (PConstants.TWO_PI / 3) * 1));
		instrumentos.add(new Sphere(app, posInicial, tam, (PConstants.TWO_PI / 3) * 2));
		instrumentos.add(new Piramide(app, posInicial, tam, (PConstants.TWO_PI / 3) * 3));

		// segunda orbita
		instrumentos.add(new Helix(app, posInicial, tam, (PConstants.TWO_PI / 4) * 1));
		instrumentos.add(new Estrella(app, posInicial, tam, (PConstants.TWO_PI / 4) * 2));
		instrumentos.add(new Helix(app, posInicial, tam, (PConstants.TWO_PI / 4) * 3));
		instrumentos.add(new Diamond(app, posInicial, tam, (PConstants.TWO_PI / 4) * 4));

	}

	public void draw() {
//		fondo.draw();
		app.directionalLight(0, 100, 100, 0, 0, -1);
		central.draw();

		for (int i = 0; i < instrumentos.size(); i++) {
			MasterGeometry m = instrumentos.get(i);
			m.draw();
		}
	}
}
