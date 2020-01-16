/**
 * 
 */
package dominio;

import java.util.LinkedList;

import logica.ListaGruas;

/**
 * @author Cristian Chiang
 *
 */
public class Sitio {
	
	private int numero;
	private LinkedList<Barco> descargados;
	private Barco barco;
	private ListaGruas gruas;
	private Grua grua1;
	private Grua grua2;
	
	public Sitio(int numero) {
		this.numero = numero;
		this.descargados = new LinkedList<Barco>();
		this.gruas = new ListaGruas();
	}

	/**
	 * @return the descargados
	 */
	public LinkedList<Barco> getDescargados() {
		return descargados;
	}

	/**
	 * @param descargados the descargados to set
	 */
	public void setDescargados(LinkedList<Barco> descargados) {
		this.descargados = descargados;
	}

	/**
	 * @return the barco
	 */
	public Barco getBarco() {
		return barco;
	}

	/**
	 * @param barco the barco to set
	 */
	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	/**
	 * @return the gruas
	 */
	public ListaGruas getGruas() {
		return gruas;
	}

	/**
	 * @param gruas the gruas to set
	 */
	public void setGruas(ListaGruas gruas) {
		this.gruas = gruas;
	}

	/**
	 * @return the grua1
	 */
	public Grua getGrua1() {
		return grua1;
	}

	/**
	 * @param grua1 the grua1 to set
	 */
	public void setGrua1(Grua grua1) {
		this.grua1 = grua1;
	}

	/**
	 * @return the grua2
	 */
	public Grua getGrua2() {
		return grua2;
	}

	/**
	 * @param grua2 the grua2 to set
	 */
	public void setGrua2(Grua grua2) {
		this.grua2 = grua2;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
}