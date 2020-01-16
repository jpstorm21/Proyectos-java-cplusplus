/**
 * 
 */
package logica;

import java.util.ArrayList;

import dominio.Contenedor;
import dominio.Grua;

/**
 * @author Cristian Chiang
 *
 */
public class ListaGruas {

	private NodoGrua ultimo;
		
	/**
	 * Constructor
	 */
	public ListaGruas() {
		this.ultimo = null;
	}
	
	/**
	 * @return
	 */
	public Grua obtenerDisponible() {
		Grua resp = null;
		if(this.ultimo != null) {
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente() && aux.getGrua().isEnMantencion() == true) {
				aux = aux.getSiguiente();
			}
			if(aux.getGrua().isEnMantencion() == false) {
				resp = aux.getGrua(); 
			}
		}
		return resp;
	}
	
	/**
	 * @param g
	 */
	public void agregarGrua(Grua g) {
		NodoGrua nuevo = new NodoGrua(g);
		if(this.ultimo == null) {
			this.ultimo = nuevo;
			nuevo.setSiguiente(this.ultimo);
		}else {
			nuevo.setSiguiente(ultimo.getSiguiente());
			this.ultimo.setSiguiente(nuevo);
		}
	}
	
	/**
	 * @param numero
	 * @return
	 */
	public boolean pasarAMantencion(int numero) {
		boolean resp = false;
		if(this.ultimo != null) {
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente() && aux.getGrua().getNumero() != numero) {
				aux = aux.getSiguiente();
			}
			if(aux.getGrua().getNumero() == numero) {
				aux.getGrua().setEnMantencion(true);
				resp = true;
			}
		}
		return resp;
	}
	
	/**
	 * 
	 */
	public void realizarMantencion() {
		if(this.ultimo != null) {
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente() && aux.getGrua().isEnMantencion() == false) {
				aux = aux.getSiguiente();
			}
			if(aux.getGrua().isEnMantencion() == true)
				aux.getGrua().setEnMantencion(false);
		}
	}
	
	/**
	 * @return
	 */
	public int getCargaMovida() {
		int total = 0;
		if(this.ultimo != null) {
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente()) {
				aux = aux.getSiguiente();
				ArrayList<Contenedor> contenedores = aux.getGrua().getDescargados();
				for(Contenedor cont : contenedores) {
					total += cont.getCarga();
				}					
			}
		}
		return total;
	}
	
	/**
	 * @return
	 */
	public int getCostoOperacion() {
		int total = 0;
		if(this.ultimo != null) {
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente()) {
				aux = aux.getSiguiente();
				ArrayList<Contenedor> contenedores = aux.getGrua().getDescargados();
				for(Contenedor cont : contenedores) {
					total += cont.getCosto();
				}					
			}
		}
		return total;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String resp = "Sin Grúas!";
		if(this.ultimo != null) {
			resp = "";
			NodoGrua aux = this.ultimo.getSiguiente();
			while(aux.getSiguiente() != this.ultimo.getSiguiente()) {
				aux = aux.getSiguiente();
				resp += aux.getGrua().toString();					
			}
		}
		return resp;
	}
}
