package cl.ucn.ei.pa.sistemaUniversidades.dominio;

public class Acreditacion {
	private Universidad universidad;
	private Carrera carrera;
	private  boolean acreditada;
	private int añosAcreditacion;
	private String fechaInicioAcreditacion;
	private String fechaFinAcreditacion;

	public Acreditacion(Universidad universidad, Carrera carrera, boolean acreditada, int añosAcreditacion, String fechaInicioAcreditacion, String fechaFinAcreditacion) {
		this.universidad = universidad;
		this.carrera = carrera;
		this.acreditada = acreditada;
		this.añosAcreditacion = añosAcreditacion;
		this.fechaInicioAcreditacion = fechaInicioAcreditacion;
		this.fechaFinAcreditacion = fechaFinAcreditacion;
	}
	
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
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
	
	
	
}
