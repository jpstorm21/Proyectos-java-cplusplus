/**
 * 
 */
package cl.ucn.ei.pa.sistemaUniversidades.dominio;

/**
 * @author Loreto Telgie
 *
 */
public class Organizacion {
	private int codigo;
	private String nombre;
	private Universidad univPrivada;
	private int monto;
	
	public Organizacion(int codigo, String nombre, int monto) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.monto = monto;
		univPrivada = null;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	/**
	 * @return the univPrivada
	 */
	public Universidad getUnivPrivada() {
		return univPrivada;
	}

	/**
	 * @param univPrivada the univPrivada to set
	 */
	public void setUnivPrivada(Universidad univPrivada) {
		this.univPrivada = univPrivada;
	}
	
	
	
}
