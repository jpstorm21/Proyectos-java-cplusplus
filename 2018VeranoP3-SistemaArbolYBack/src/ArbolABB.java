import java.util.ArrayList;
import java.util.Queue;

import ucn.StdOut;

/**
 * 
 */

/**
 * @author Cristian Chiang
 *
 */
public class ArbolABB {

	private NodoABB raiz;
	
	/**
	 * 
	 */
	public ArbolABB() {
		this.raiz = null;
	}
	
	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	public void insertar(String palabra) {
		NodoABB nuevo = new NodoABB(palabra);
		if(this.isEmpty()) {
			this.raiz = nuevo;
		}else {
			insertar(this.raiz, nuevo);
		}
	}
	
	private void insertar(NodoABB raizLocal, NodoABB nuevo) {
		if(raizLocal.getPalabra().compareTo(nuevo.getPalabra()) > 0) {
			if(raizLocal.getHijoIzquierdo() == null)
				raizLocal.setHijoIzquierdo(nuevo);
			else
				insertar(raizLocal.getHijoIzquierdo(), nuevo);
		}else {
			if(raizLocal.getHijoDerecho() == null)
				raizLocal.setHijoDerecho(nuevo);
			else
				insertar(raizLocal.getHijoDerecho(), nuevo);
		}
	}

	//---------ES COMPLETO---------
	public boolean esCompleto() {
		if(this.isEmpty())
			return true;
		else
			return esCompleto(this.raiz);
	}
	
	private boolean esCompleto(NodoABB raizLocal) {
		if(raizLocal.getHijoIzquierdo() == null && raizLocal.getHijoDerecho() == null)
			return true;
		else {
			if(raizLocal.getHijoIzquierdo() != null && raizLocal.getHijoDerecho() != null) {
				return esCompleto(raizLocal.getHijoIzquierdo()) && esCompleto(raizLocal.getHijoDerecho());
			}else {
				return false;
			}
		}
			
	}
	
	//---------OBTENER PROMEDIO---------
	public double obtenerPromedio() {
		double promedio = 0;
		if(!this.isEmpty()) {
			promedio = (double)(obtenerSuma(this.raiz) / obtenerCantidad(this.raiz));
		}
		return promedio;
	}
	
	private int obtenerSuma(NodoABB raizLocal) {
		int suma = 0;
		if(raizLocal != null) {
			suma = raizLocal.getPalabra().length() + obtenerSuma(raizLocal.getHijoIzquierdo()) + obtenerSuma(raizLocal.getHijoDerecho());
		}
		return suma;
	}
	
	private int obtenerCantidad(NodoABB raizLocal) {
		int total = 0;
		if(raizLocal != null) {
			total = 1 + obtenerCantidad(raizLocal.getHijoIzquierdo()) + obtenerCantidad(raizLocal.getHijoDerecho());
		}
		return total;
	}
	
	public int obtenerCantidad() {
		return obtenerCantidad(this.raiz);
	}
	
	//---------LISTAR HOJAS---------
	public String listarHojas() {
		String resp = "No hay palabras!!!";
		if(!this.isEmpty()) {
			resp = "";
			return listarHojas(this.raiz, resp);
		}
		return resp;
	}
	
	private String listarHojas(NodoABB raizLocal, String resp) {
		if(raizLocal == null)
			return resp;
		else {
			if(raizLocal.getHijoIzquierdo() == null && raizLocal.getHijoDerecho() == null)
				return resp + raizLocal.getPalabra();
			else
				return listarHojas(raizLocal.getHijoIzquierdo(), resp) + listarHojas(raizLocal.getHijoDerecho(), resp);
		}
	}
	
	//---------ES ABB---------
	public boolean esABB() {
		boolean resp = false;
		if(this.isEmpty()) {
			resp = true;
		}else {
			resp = esABB(this.raiz);
		}
		return resp;
	}
	
	private boolean esABB(NodoABB raizLocal) {
		if(raizLocal == null)
			return true;
		else {
			return (raizLocal.getPalabra().compareTo(max(raizLocal.getHijoIzquierdo())) > 0 &&
					raizLocal.getPalabra().compareTo(min(raizLocal.getHijoDerecho())) < 0);
		}
	}
	
	private String max(NodoABB raizLocal) {
		String max = "";
		if(raizLocal != null) {
			String maxIzq = max(raizLocal.getHijoIzquierdo());
			String maxDer = max(raizLocal.getHijoDerecho());
			if(raizLocal.getPalabra().compareTo(maxDer) > 0)
				if(raizLocal.getPalabra().compareTo(maxIzq) > 0)
					max = raizLocal.getPalabra();
				else
					max = maxIzq;
			else
				if(maxIzq.compareTo(maxDer) > 0)
					max = maxIzq;
				else
					max = maxDer;
		}
		return max;
	}
	
	private String min(NodoABB raizLocal) {
		String min = "ZZZZZZZZZZZZZZZZZZZZ";
		if(raizLocal != null) {
			String minIzq = min(raizLocal.getHijoIzquierdo());
			String minDer = min(raizLocal.getHijoDerecho());
			if(raizLocal.getPalabra().compareTo(minDer) < 0)
				if(raizLocal.getPalabra().compareTo(minIzq) < 0)
					min = raizLocal.getPalabra();
				else
					min = minIzq;
			else
				if(minIzq.compareTo(minDer) > 0)
					min = minIzq;
				else
					min = minDer;
		}
		return min;
	}
	
	//---------ES COMPLETO---------
	public String convertir(String palabra) {
		String resp = "";
		if(!this.isEmpty()) {
			resp = convertir(this.raiz, palabra);
		}
		return resp;
	}
	
	private String convertir(NodoABB raizLocal, String palabra) {
		String resp = "";
		if(raizLocal != null) {
			resp = "";
			if(raizLocal.getPalabra().equalsIgnoreCase(palabra)) {
				resp = palabra.substring(palabra.length()-3, palabra.length());
			}else {
				if(raizLocal.getPalabra().compareTo(palabra) > 0) {
					resp = raizLocal.getPalabra().substring(raizLocal.getPalabra().length()-3, raizLocal.getPalabra().length()) + "*" + convertir(raizLocal.getHijoIzquierdo(), palabra);
				}else {
					resp = raizLocal.getPalabra().substring(raizLocal.getPalabra().length()-3, raizLocal.getPalabra().length()) + "#" + convertir(raizLocal.getHijoDerecho(), palabra);
				}
			}				
		}
		return resp;
	}
	
	//---------IMPRIMIR POR NIVELES---------
	public String imprimirNiveles() {
		String resp = "";
		if(!this.isEmpty()) {
			ArrayList<NodoABB> cola = new ArrayList<NodoABB>();
			ArrayList<NodoABB> colaAux = new ArrayList<NodoABB>();
			NodoABB aux = this.raiz;
			cola.add(aux);
			while(!cola.isEmpty()) {
				for(NodoABB n : cola) {
					if(n.getHijoIzquierdo() != null) {
						if(!colaAux.contains(n.getHijoIzquierdo())) {
							colaAux.add(n.getHijoIzquierdo());
						}
					}
					if(n.getHijoDerecho() != null) {
						if(!colaAux.contains(n.getHijoDerecho())) {
							colaAux.add(n.getHijoDerecho());
						}
					}
				}
				resp += cola.remove(0).getPalabra() + " ";
				if(cola.isEmpty()) {
					cola.addAll(colaAux);
					colaAux.clear();
					resp += "\n";
				}
			}
		}
		return resp;
	}
}