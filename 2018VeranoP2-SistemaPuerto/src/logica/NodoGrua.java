/**
 * 
 */
package logica;

import dominio.Grua;

/**
 * @author Cristian Chiang
 *
 */
public class NodoGrua {

	private Grua grua;
	private NodoGrua siguiente;
	
	public NodoGrua(Grua grua) {
		this.grua = grua;
		this.siguiente = null;
	}

	/**
	 * @return the siguiente
	 */
	public NodoGrua getSiguiente() {
		return siguiente;
	}

	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(NodoGrua siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * @return the grua
	 */
	public Grua getGrua() {
		return grua;
	}
	
	
}
