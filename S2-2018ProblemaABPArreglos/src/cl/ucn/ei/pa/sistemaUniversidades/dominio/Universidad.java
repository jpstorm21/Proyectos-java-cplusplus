/**
 * 
 */
package cl.ucn.ei.pa.sistemaUniversidades.dominio;

import cl.ucn.ei.pa.sistemaUniversidades.logica.ListaAcreditaciones;
import cl.ucn.ei.pa.sistemaUniversidades.logica.ListaCarreras;

/**
 * @authoor Loreto Telgie
 *
 */
public abstract class Universidad {
	private int codigo;
	private String nombre;
	private boolean acreditada;
	private int añosAcreditacion;
	private String fechaInicioAcreditacion;
	private String fechaFinAcreditacion;
	private boolean gratuidad;
	private ListaCarreras listaCarreras;
	private ListaAcreditaciones listaAcreditaciones;
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param gratuidad
	 */
	protected Universidad(int codigo, String nombre, boolean gratuidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.gratuidad = gratuidad;
		listaCarreras = new ListaCarreras(20);
		listaAcreditaciones = new ListaAcreditaciones(20);
		/*listaAranceles = new ListaAranceles(20);
	*/
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

	
	public boolean isAcreditada() {
		return acreditada;
	}

	
	public void setAcreditada(boolean acreditada) {
		this.acreditada = acreditada;
	}

	
	public int getAñosAcreditacion() {
		return añosAcreditacion;
	}

	
	public void setAñosAcreditacion(int añosAcreditacion) {
		this.añosAcreditacion = añosAcreditacion;
	}

	
	public String getFechaInicioAcreditacion() {
		return fechaInicioAcreditacion;
	}

	
	public void setFechaInicioAcreditacion(String fechaInicioAcreditacion) {
		this.fechaInicioAcreditacion = fechaInicioAcreditacion;
	}

	public String getFechaFinAcreditacion() {
		return fechaFinAcreditacion;
	}

	
	public void setFechaFinAcreditacion(String fechaFinAcreditacion) {
		this.fechaFinAcreditacion = fechaFinAcreditacion;
	}

	
	public boolean isGratuidad() {
		return gratuidad;
	}

	public void setGratuidad(boolean gratuidad) {
		this.gratuidad = gratuidad;
	}

	
	public ListaCarreras getListaCarreras() {
		return listaCarreras;
	}


	public void setListaCarreras(ListaCarreras listaCarreras) {
		this.listaCarreras = listaCarreras;
	}


	public ListaAcreditaciones getListaAcreditaciones() {
		return listaAcreditaciones;
	}


	public void setListaAcreditaciones(ListaAcreditaciones listaAcreditaciones) {
		this.listaAcreditaciones = listaAcreditaciones;
	}

	public abstract double calcularAlfa();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Universidad [codigo=" + codigo + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ "acreditada=" + acreditada + ", añosAcreditacion=" + añosAcreditacion + ", "
				+ (fechaInicioAcreditacion != null ? "fechaInicioAcreditacion=" + fechaInicioAcreditacion + ", " : "")
				+ (fechaFinAcreditacion != null ? "fechaFinAcreditacion=" + fechaFinAcreditacion + ", " : "")
				+ "gratuidad=" + gratuidad + "]";
	}

	
	
	
}
