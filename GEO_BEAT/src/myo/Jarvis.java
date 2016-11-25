package myo;

import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Vector3;

import de.voidplus.myo.*;
import processing.core.*;

public class Jarvis implements Runnable {
	private Thread t;
	private PApplet app;
	private Myo myo;

	private Device device;
	private Pose pose;
	private Vector3 point;
	private DeviceListener points;
	private int id;
	private boolean emg;
	private PVector acelerometro, giroscopio, orientacion;
	private float dxF;
	private float dyF;

	/**
	 * No hubo grandes cambios en la clas Jarvis frente al UML, pues la libreria
	 * del sensor era clara brind� los recursos adecuados para trabajar
	 * facilmente
	 * 
	 * @param myo
	 * @param app
	 */
	public Jarvis(Myo myo, PApplet app) {
		this.myo = myo;
		this.app = app;
		t = new Thread(this, "hiloJarvis");
		t.start();
		id = 0;
	}

	/**
	 * El hilo corre implementando y no heredando
	 */
	@Override
	public void run() {
		while (true) {
			if (myo.hasArm()) {
				deviceControl();
				unLock();
				// gesto();
				// pointer();
				calcularFisicas();
				
			}
			try {
				System.out.println("X: " + orientacion.x + " Y: " + orientacion.y + " Z: " + orientacion.z);
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	private void deviceControl() {
		if (device == null) {
			device = new Device(myo.getRawMyo(), 0);
		}
		id = device.getId();

	}

	private void unLock() {

		myo.unlock(Myo.Unlock.valueOf("HOLD"), id);

	}

	/**
	 * Se adiciona el metodo pointer() para hacer el paneo de coordenadas en la
	 * pantalla utilizando los vecotres de orientacion
	 */
	public void pointer() {
		if (device != null) {
			float dx = myo.getOrientation().z;
			float dy = myo.getOrientation().y;
			dxF = PApplet.map(dx, (float) 1, (float) 0.1, -app.width - app.width / 2, app.width + app.width / 3);
			dyF = PApplet.map(dy, (float) 1, (float) 0.1, -app.height, app.height + app.height / 2);
			app.noStroke();
			app.fill(120);
			app.ellipse(dxF, dyF, 20, 20);
		}
	}

	public float getDxF() {
		return dxF;
	}

	public float getDyF() {
		return dyF;
	}

	public Object gesto() {
		if (myo.hasArm()) {
			pose = myo.getPose();
			Object p;
			p = pose.getType();
			return p;
		}
		return null;
	}

	public boolean validarGestos(Object p, String poseEvent) {
		if (p == Pose.Type.valueOf(poseEvent)) {
			return true;
		}
		return false;
	}

	private void calcularFisicas() {
		acelerometro = myo.getAccelerometer(id);
		giroscopio = myo.getGyroscope(id);
		orientacion = myo.getOrientation(id);
	}
	
	public PVector getOrientacion() {
		return orientacion;
	}

}
