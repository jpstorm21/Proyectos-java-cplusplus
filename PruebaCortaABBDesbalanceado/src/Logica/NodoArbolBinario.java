/**
 * 
 */
package Logica;

/**
 * @author Cristian
 *
 */
public class NodoArbolBinario {

	private int dato;
	private NodoArbolBinario hijoIzquierdo;
	private NodoArbolBinario hijoDerecho;
	
	public NodoArbolBinario(int dato) {
		this.dato = dato;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
	}

	/**
	 * @return the hijoIzquierdo
	 */
	public NodoArbolBinario getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	/**
	 * @param hijoIzquierdo the hijoIzquierdo to set
	 */
	public void setHijoIzquierdo(NodoArbolBinario hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	/**
	 * @return the hijoDerecho
	 */
	public NodoArbolBinario getHijoDerecho() {
		return hijoDerecho;
	}

	/**
	 * @param hijoDerecho the hijoDerecho to set
	 */
	public void setHijoDerecho(NodoArbolBinario hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	/**
	 * @return the dato
	 */
	public int getDato() {
		return dato;
	}
	
	
}
