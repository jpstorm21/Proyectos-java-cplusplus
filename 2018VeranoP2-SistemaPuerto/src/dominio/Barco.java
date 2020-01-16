/**
 * 
 */
package dominio;

import java.util.ArrayList;

/**
 * @author Cristian Chiang
 *
 */
public class Barco {

	private String nombre;
	private String pais;
	private ArrayList<Contenedor> contenedores;
	
	/**
	 * @param n
	 * @param p
	 */
	public Barco(String n, String p) {
		this.nombre = n;
		this.pais = p;
		this.contenedores = new ArrayList<Contenedor>();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the contenedores
	 */
	public ArrayList<Contenedor> getContenedores() {
		return contenedores;
	}

	/**
	 * @param contenedores the contenedores to set
	 */
	public void setContenedores(ArrayList<Contenedor> contenedores) {
		this.contenedores = contenedores;
	}
	
	
}
