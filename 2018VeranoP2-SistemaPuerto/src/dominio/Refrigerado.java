/**
 * 
 */
package dominio;

/**
 * @author Cristian Chiang
 *
 */
public class Refrigerado extends Contenedor {

	private String fechaVencimiento;
	
	/**
	 * @param codigo
	 * @param capacidad
	 * @param carga
	 */
	public Refrigerado(String codigo, int capacidad, int carga, String fechaVencimiento) {
		super(codigo, capacidad, carga);
		this.fechaVencimiento = fechaVencimiento; 
	}
	
	/**
	 * @return the fechaVencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/* (non-Javadoc)
	 * @see dominio.Contenedor#getCosto()
	 */
	@Override
	public int getCosto() {
		return 2000 * this.getCarga();
	}
}