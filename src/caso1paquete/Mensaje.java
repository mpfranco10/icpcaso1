package caso1paquete;

public class Mensaje {

	private int mensaje;
	private int respuesta;

	public Mensaje(int m, int r) {
		mensaje = m;
		respuesta = r;
	}

	public int getMensaje() {
		return mensaje;
	}

	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public synchronized void esperar() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void notificar() {
		notify();
	}

}
