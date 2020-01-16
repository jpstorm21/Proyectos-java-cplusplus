/**
 * 
 */
package dominio;

/**
 * @author Cristian Chiang
 *
 */
public class Normal extends Contenedor {

	/**
	 * @param codigo
	 * @param capacidad
	 * @param carga
	 */
	public Normal(String codigo, int capacidad, int carga) {
		super(codigo, capacidad, carga);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dominio.Contenedor#getCosto()
	 */
	@Override
	public int getCosto() {
		return 1500 * this.getCarga();
	}
}
