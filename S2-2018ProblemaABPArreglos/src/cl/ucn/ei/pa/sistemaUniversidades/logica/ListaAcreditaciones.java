package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Acreditacion;

public class ListaAcreditaciones {
	private Acreditacion [] lista;
	private int cantidadAcreditaciones;
	private int max;
	
	public ListaAcreditaciones(int max) {
		lista = new Acreditacion[max];
		cantidadAcreditaciones = 0;
		this.max = max;
	}
	
	public boolean ingresar(Acreditacion acreditacion) {
		if (cantidadAcreditaciones < max) {
			lista[cantidadAcreditaciones]= acreditacion;
			cantidadAcreditaciones ++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @return the cantidadAcreditacions
	 */
	public int getCantidadAcreditaciones() {
		return cantidadAcreditaciones;
	}

	/**
	 * @param cantidadAcreditaciones the cantidadAcreditacions to set
	 */
	public void setCantidadAcreditaciones(int cantidadAcreditaciones) {
		this.cantidadAcreditaciones = cantidadAcreditaciones;
	}
	
	public Acreditacion getAcreditacionI(int i) {
		if (i < cantidadAcreditaciones) {
			return lista[i];
		}
		else {
			return null;
		}
	}
}
