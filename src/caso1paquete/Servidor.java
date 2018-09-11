package caso1paquete;

public class Servidor extends Thread {

	private Buffer buffer;
	private boolean activo;

	public Servidor(Buffer b, boolean a) {
		buffer = b;
		activo = a;
	}

	public void run() {
		while (activo) {
			procesar();
		}

		System.out.println("Servidor inactivo");
	}

	public void procesar() {

		Mensaje retirado = buffer.retirar();

		while (retirado == null && activo) {
			if (buffer.finClientes()) {
				activo = false;
			}

			retirado = buffer.retirar(); // Para volver al while
			yield();
		}
		if (activo) {
			int recibido = retirado.getMensaje();
			retirado.setRespuesta(recibido + 1);
			retirado.notificar();
			System.out.println("Mensaje retirado, respuesta" + retirado.getRespuesta());
		}
	}

}