/**
 * 
 */
package cl.ucn.ei.pa.sistemaUniversidades.dominio;

/**
 * @author Loretro Telgie
 *
 */
public abstract class Tradicional extends Universidad{
	
	private double por;
	
	/**
	 * 
	 */
	public Tradicional(int codigo, String nombre, boolean gratuidad, double por) {
		super(codigo, nombre, gratuidad);
		this.por= por;
	}
	/**
	 * @return the por
	 */
	public double getPor() {
		return por;
	}
	/**
	 * @param por the por to set
	 */
	public void setPor(double por) {
		this.por = por;
	}
	
}
