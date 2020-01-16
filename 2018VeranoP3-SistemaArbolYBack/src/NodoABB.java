/**
 * 
 */

/**
 * @author Cristian Chiang
 *
 */
public class NodoABB {

	/**
	 * Atributos de la clase NodoABB
	 */
	private String palabra;
	private NodoABB hijoIzquierdo;
	private NodoABB hijoDerecho;
	
	/**
	 * Constructor
	 */
	public NodoABB(String palabra) {
		this.palabra = palabra;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
	}

	/**
	 * @return the hijoIzquierdo
	 */
	public NodoABB getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	/**
	 * @param hijoIzquierdo the hijoIzquierdo to set
	 */
	public void setHijoIzquierdo(NodoABB hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	/**
	 * @return the hijoDerecho
	 */
	public NodoABB getHijoDerecho() {
		return hijoDerecho;
	}

	/**
	 * @param hijoDerecho the hijoDerecho to set
	 */
	public void setHijoDerecho(NodoABB hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	/**
	 * @return the palabra
	 */
	public String getPalabra() {
		return palabra;
	}
}