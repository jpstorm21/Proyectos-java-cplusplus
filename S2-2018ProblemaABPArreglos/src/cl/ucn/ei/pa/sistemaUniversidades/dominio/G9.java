package cl.ucn.ei.pa.sistemaUniversidades.dominio;

public class G9 extends Tradicional{
	
	private int arancelBasico;
	
	public G9(int codigo, String nombre, boolean gratuidad, double por) {
		super(codigo, nombre, gratuidad, por);
	}
	
	public double calcularAlfa() {
		return getPor()*150;
	}

	
	public int getArancelBasico() {
		return arancelBasico;
	}

	public void setArancelBasico(int arancelBasico) {
		this.arancelBasico = arancelBasico;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Universidad G9 [codigo=" + getCodigo() + ", " + (getNombre() != null ? "nombre=" + getNombre() + ", " : "")
				+ "acreditada=" + isAcreditada() + ", agnosAcreditacion=" + getAñosAcreditacion() + ", "
				+ (getFechaInicioAcreditacion() != null ? "fechaInicioAcreditacion=" + getFechaInicioAcreditacion() + ", " : "")
				+ (getFechaFinAcreditacion() != null ? "fechaFinAcreditacion=" + getFechaFinAcreditacion() + ", " : "")
				+ "gratuidad=" + isGratuidad() + "]";
	}
	
	
}
