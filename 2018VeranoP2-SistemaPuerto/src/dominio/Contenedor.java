/**
 * 
 */
package dominio;

/**
 * @author Cristian Chiang
 *
 */
public abstract class Contenedor {

	private String codigo;
	private int capacidad;
	private int carga;
	
	/**
	 * @param codigo
	 * @param capacidad
	 * @param carga
	 */
	public Contenedor(String codigo, int capacidad, int carga) {
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.carga = carga;
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
	 * @return the carga
	 */
	public int getCarga() {
		return carga;
	}

	/**
	 * @param carga the carga to set
	 */
	public void setCarga(int carga) {
		this.carga = carga;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * @return el costo de operación del contenedor
	 */
	public abstract int getCosto();
}
