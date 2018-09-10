package caso1paquete;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class GeneradorArchivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		OutputStream output = null;

		Random rand = new Random();
		int numclientes = rand.nextInt(60) + 10; // Entre 10 y 60 clientes
		int numServ = rand.nextInt(10) + 3; // Entre 3 y 10 servidores
		int bufftam = rand.nextInt(50) + 30; // Entre 30 y 50 tamaño del buffer

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty("numclientes", numclientes + "");
			prop.setProperty("numServ", numServ + "");
			prop.setProperty("bufftam", bufftam + "");

			// ahora inicializar los mensjes de cada cliente

			for (int i = 0; i < numclientes; i++) {
				int mens = rand.nextInt(10) + 1; // entre 1 y 10 mensajes por
													// cliente (?)
				prop.setProperty("numMensajescliente" + i, mens + "");
			}

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
