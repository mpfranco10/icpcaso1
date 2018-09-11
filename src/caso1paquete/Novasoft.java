package caso1paquete;

import java.io.*;
import java.util.Properties;

public class Novasoft {

	public static void main(String[] args) {

		// Obtener los valores del archivo
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Clientes " + prop.getProperty("numclientes"));
			System.out.println("Servidores " + prop.getProperty("numServ"));
			System.out.println("Tam buffer " + prop.getProperty("bufftam"));

			int clientes = Integer.parseInt(prop.getProperty("numclientes"));
			int serv = Integer.parseInt(prop.getProperty("numServ"));
			int buff = Integer.parseInt(prop.getProperty("bufftam"));

			// Luego si inician threads

			Buffer buf = new Buffer(buff, 0);

			int[] mensajesClientes = new int[clientes];
			for (int i = 0; i < clientes; i++) {
				mensajesClientes[i] = Integer.parseInt(prop.getProperty("numMensajescliente" + i));
				Cliente c = new Cliente(mensajesClientes[i], buf);
				System.out.println("Se creo un cliente con num mensajs " + mensajesClientes[i]);
				c.start();
			}
			for (int i = 0; i < serv; i++) {
				Servidor s = new Servidor(buf, true);
				s.start();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
