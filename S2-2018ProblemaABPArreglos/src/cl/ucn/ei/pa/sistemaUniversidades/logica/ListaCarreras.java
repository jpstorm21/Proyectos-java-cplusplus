package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Carrera;

public class ListaCarreras {
	private Carrera [] lista;
	private int cantidadCarreras;
	private int max;
	
	public ListaCarreras(int max) {
		lista = new Carrera[max];
		cantidadCarreras = 0;
		this.max = max;
	}
	
	public boolean ingresar(Carrera Carrera) {
		if (cantidadCarreras < max) {
			lista[cantidadCarreras]= Carrera;
			cantidadCarreras ++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @return the cantidadCarreras
	 */
	public int getCantidadCarreras() {
		return cantidadCarreras;
	}

	/**
	 * @param cantidadCarreraes the cantidadCarreras to set
	 */
	public void setCantidadCarreraes(int cantidadCarreras) {
		this.cantidadCarreras = cantidadCarreras;
	}
	
	public Carrera getCarreraI(int i) {
		if (i < cantidadCarreras) {
			return lista[i];
		}
		else {
			return null;
		}
	}
	
	public Carrera buscar(int codigo) {
		int i = 0;
		while(i < cantidadCarreras && lista[i].getCodigo()!= codigo) {
			i++;
		}
		if(i == cantidadCarreras) {
			return null;
		}
		else {
			return lista[i];
		}
	}

	
}
