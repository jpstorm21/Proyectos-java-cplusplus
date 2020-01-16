/**
 * 
 */
package logica;

import java.util.ArrayList;

import dominio.Barco;

/**
 * @author Cristian Chiang
 *
 */
public interface SistemaPuerto {

	/**
	 * @param b
	 * @return
	 */
	boolean ingresarBarco(String n, String p);
	
	/**
	 * @return
	 */
	String obtenerSitiosOcupados();
	
	/**
	 * @param sitio
	 */
	void descargarBarco(int sitio);
	
	/**
	 * @param sitio
	 * @return
	 */
	boolean liberarSitio(int sitio);
	
	/**
	 * @return
	 */
	String obtenerTotalCargaMovida();
	
	/**
	 * @return
	 */
	ArrayList<Barco> obtenerBarcos();
	
	/**
	 * @return
	 */
	int obtenerCostosOperacion();
	
	/**
	 * @param sitio
	 * @return
	 */
	String obtenerGruasSitio(int sitio);
	
	/**
	 * 
	 */
	void realizarMantenciones();
}