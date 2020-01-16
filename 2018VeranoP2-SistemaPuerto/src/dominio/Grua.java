/**
 * 
 */
package dominio;

import java.util.ArrayList;

/**
 * @author Cristian Chiang
 *
 */
public class Grua {

	private int numero;
	private int capacidad;
	private int mantenciones;
	private boolean enMantencion;
	private ArrayList<Contenedor> descargados;
	
	/**
	 * @param numero
	 * @param capacidad
	 * @param mantenciones
	 */
	public Grua(int numero, int capacidad) {
		this.numero = numero;
		this.capacidad = capacidad;
		this.mantenciones = 0;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the mantenciones
	 */
	public int getMantenciones() {
		return mantenciones;
	}

	/**
	 * @param mantenciones the mantenciones to set
	 */
	public void setMantenciones(int mantenciones) {
		this.mantenciones = mantenciones;
	}

	/**
	 * @return the enMantencion
	 */
	public boolean isEnMantencion() {
		return enMantencion;
	}

	/**
	 * @param enMantencion the enMantencion to set
	 */
	public void setEnMantencion(boolean enMantencion) {
		this.enMantencion = enMantencion;
	}

	/**
	 * @return the descargados
	 */
	public ArrayList<Contenedor> getDescargados() {
		return descargados;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * @param cont
	 * @return
	 */
	public boolean intentaAdd(Contenedor cont) {
		boolean resp = false;
		if(this.capacidad >= cont.getCarga())
			resp = true;
		return resp;
	}
	
	/**
	 * @param cont
	 */
	public void agregaContenedor(Contenedor cont) {
		this.descargados.add(cont);
		this.capacidad -= cont.getCarga();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grua [numero=" + numero + ", capacidad=" + capacidad + ", mantenciones=" + mantenciones + "]";
	}
}