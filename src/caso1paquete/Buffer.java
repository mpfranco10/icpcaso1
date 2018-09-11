package caso1paquete;

import java.util.ArrayList;

public class Buffer {

	private int tamanio;
	private int numClientes;
	private ArrayList<Mensaje> almacenados;

	public Buffer(int tamanio, int numClientes) {
		this.tamanio = tamanio;
		this.numClientes = numClientes;
		this.almacenados = new ArrayList<Mensaje>();
	}

	// indica si se pudo almacenar el mensaje o no
	public synchronized boolean almacenar(Mensaje m) {
		if (almacenados.size() == tamanio) {
			return false;
		} else {
			almacenados.add(m);
			return true;
		}
	}

	public synchronized Mensaje retirar() {
		if (almacenados.size() == 0) {
			return null;
		} else {
			return almacenados.remove(0);

		}
	}

	public synchronized boolean finClientes() {
		return numClientes == 0;
	}

	public synchronized void retirarCliente() {
		numClientes--;
		System.out.println("Se retiró un cliente, ahora hay " + numClientes);
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}

	public ArrayList<Mensaje> getAlmacenados() {
		return almacenados;
	}

	public void setAlmacenados(ArrayList<Mensaje> almacenados) {
		this.almacenados = almacenados;
	}

	public Buffer(int tam) {
		tamanio = tam;
	}
}
