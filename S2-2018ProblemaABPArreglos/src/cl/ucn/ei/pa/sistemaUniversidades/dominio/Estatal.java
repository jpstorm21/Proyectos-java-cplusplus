package cl.ucn.ei.pa.sistemaUniversidades.dominio;

public class Estatal extends Tradicional{

	private static int arancelBasico;
	
	public Estatal(int codigo, String nombre, boolean gratuidad, double por) {
		super(codigo, nombre, gratuidad, por);
	}
	
	public double calcularAlfa() {
		if (isAcreditada()) {
			return getPor()*100;
		}
		else {
			return (getPor()* getArancelBasico()/20.0);
		}
	}
	
	public static int getArancelBasico() {
		return arancelBasico;
	}

	public static void setArancelBasico(int arancelBasico) {
		Estatal.arancelBasico = arancelBasico;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Universidad Estatal [codigo=" + getCodigo() + ", " + (getNombre() != null ? "nombre=" + getNombre() + ", " : "")
				+ "acreditada=" + isAcreditada() + ", agnosAcreditacion=" + getAñosAcreditacion() + ", "
				+ (getFechaInicioAcreditacion() != null ? "fechaInicioAcreditacion=" + getFechaInicioAcreditacion() + ", " : "")
				+ (getFechaFinAcreditacion() != null ? "fechaFinAcreditacion=" + getFechaFinAcreditacion() + ", " : "")
				+ "gratuidad=" + isGratuidad() + "]";
	}

	

	
	
	
}
