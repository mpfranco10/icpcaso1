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

		// Luego si inician threads
	}
}
