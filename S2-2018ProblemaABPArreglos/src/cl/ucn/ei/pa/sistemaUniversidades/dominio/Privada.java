package cl.ucn.ei.pa.sistemaUniversidades.dominio;

import cl.ucn.ei.pa.sistemaUniversidades.logica.ListaAranceles;

public class Privada extends Universidad{

	private boolean adscritaSistemaSeleccion;
	private Organizacion organizacion;
	private ListaAranceles listaAranceles;

	
	public Privada(int codigo, String nombre, boolean gratuidad, boolean adscritaSistemaSeleccion) {
		super(codigo, nombre, gratuidad);
		this.adscritaSistemaSeleccion= adscritaSistemaSeleccion;
		listaAranceles = new ListaAranceles(20);
		organizacion = null;
	}

	/**
	 * @return the adscritaSistemaSeleccion
	 */
	public boolean isAdscritaSistemaSeleccion() {
		return adscritaSistemaSeleccion;
	}

	/**
	 * @param adscritaSistemaSeleccion the adscritaSistemaSeleccion to set
	 */
	public void setAdscritaSistemaSeleccion(boolean adscritaSistemaSeleccion) {
		this.adscritaSistemaSeleccion = adscritaSistemaSeleccion;
	}

	/**
	 * @return the organizacion
	 */
	public Organizacion getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	public double calcularAlfa() {
		if (organizacion != null) {
			return (organizacion.getMonto()+150000);
		}
		else {
			return 150000;
		}
	}

	public ListaAranceles getListaAranceles() {
		return listaAranceles;
	}

	public void setListaAranceles(ListaAranceles listaAranceles) {
		this.listaAranceles = listaAranceles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Universidad Privada [codigo=" + getCodigo() + ", " + (getNombre() != null ? "nombre=" + getNombre() + ", " : "")
				+ "acreditada=" + isAcreditada() + ", agnosAcreditacion=" + getAñosAcreditacion() + ", "
				+ (getFechaInicioAcreditacion() != null ? "fechaInicioAcreditacion=" + getFechaInicioAcreditacion() + ", " : "")
				+ (getFechaFinAcreditacion() != null ? "fechaFinAcreditacion=" + getFechaFinAcreditacion() + ", " : "")
				+ "gratuidad=" + isGratuidad() + ", " 
				+ "adscrita al sistema de seleccion=" + isAdscritaSistemaSeleccion()+"]";
	}
	

}
