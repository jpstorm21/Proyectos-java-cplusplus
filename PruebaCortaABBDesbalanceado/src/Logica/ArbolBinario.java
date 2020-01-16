/**
 * 
 */
package Logica;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cristian
 *
 */
public class ArbolBinario {

	private NodoArbolBinario raiz;
	private Queue cola;
	
	public ArbolBinario() {
		this.raiz = null;
		cola = new LinkedList();
	}
	
	public void insertar(int dato) {
		insertar(this.raiz, new NodoArbolBinario(dato));
	}
	
	private void insertar(NodoArbolBinario raizLocal, NodoArbolBinario nuevo) {
		if(raizLocal.getDato() > nuevo.getDato()) {
			if(raizLocal.getHijoIzquierdo() == null) {
				raizLocal.setHijoIzquierdo(nuevo);
			}else {
				insertar(raizLocal.getHijoIzquierdo(), nuevo);
			}
		}else {
			if(raizLocal.getHijoDerecho() == null) {
				raizLocal.setHijoDerecho(nuevo);
			}else {
				insertar(raizLocal.getHijoDerecho(), nuevo);
			}
		}
	}
		
	public boolean desbalanceado() {
		boolean resp = false;
		if(this.raiz != null) {
			int suma1 = suma(raiz.getHijoIzquierdo());
			int suma2 = suma(raiz.getHijoDerecho());
			if(suma1 - suma2 > 5 || suma2 - suma1 > 5)
				resp = true;
		}
		return resp;		
	}
	
	private int suma(NodoArbolBinario raizLocal) {
		int suma = 0;
		if(raizLocal != null) {
			suma = raizLocal.getDato() + suma(raizLocal.getHijoIzquierdo()) + suma(raizLocal.getHijoDerecho());
		}
		return suma;
	}
	
	public void imprimeNiveles() {
		String resp = "";
		if(this.raiz != null) {
			this.cola.add(this.raiz);
			while(!cola.isEmpty()) {
				NodoArbolBinario aux = (NodoArbolBinario) cola.poll();
				if(aux != null) {
					resp += aux.getDato();
					cola.add(aux.getHijoIzquierdo());
				}				
			}
		}
	}
	
}
