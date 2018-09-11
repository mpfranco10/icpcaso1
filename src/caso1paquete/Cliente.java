package caso1paquete;

public class Cliente extends Thread {

	private int numMensajes;
	private Buffer buffer;

	public Cliente(int numMensajes, Buffer buffer) {
		super();
		this.numMensajes = numMensajes;
		this.buffer = buffer;
	}

	public void run() {

		while (numMensajes > 0) {
			enviarMensaje();
		}
		buffer.retirarCliente();
	}

	public void enviarMensaje() {

		Mensaje nuevo = new Mensaje(1, 0);
		if (!buffer.almacenar(nuevo)) {
			yield();
		}
		nuevo.esperar();
	}

}
