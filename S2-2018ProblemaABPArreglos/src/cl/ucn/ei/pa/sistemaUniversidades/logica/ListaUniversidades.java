package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Universidad;

public class ListaUniversidades {
	private Universidad [] lista;
	private int cantidadUniversidades;
	private int max;
	
	public ListaUniversidades(int max) {
		lista = new Universidad[max];
		cantidadUniversidades = 0;
		this.max = max;
	}
	
	public boolean ingresar(Universidad universidad) {
		if (cantidadUniversidades < max) {
			lista[cantidadUniversidades]= universidad;
			cantidadUniversidades ++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Universidad buscarPorNombre(String nombre) {
		int i = 0;
		while(i < cantidadUniversidades && !lista[i].getNombre().equals(nombre)) {
			i++;
		}
		if(i == cantidadUniversidades) {
			return null;
		}
		else {
			return lista[i];
		}
	}

	
	public Universidad buscarPorCodigo(int codigo) {
		int i = 0;
		while(i < cantidadUniversidades && lista[i].getCodigo()!= codigo) {
			i++;
		}
		if(i == cantidadUniversidades) {
			return null;
		}
		else {
			return lista[i];
		}
	}

	/**
	 * @return the cantidadUniversidades
	 */
	public int getCantidadUniversidades() {
		return cantidadUniversidades;
	}

	/**
	 * @param cantidadUniversidades the cantidadUniversidades to set
	 */
	public void setCantidadUniversidades(int cantidadUniversidades) {
		this.cantidadUniversidades = cantidadUniversidades;
	}
	
	public Universidad getUniversidadI(int i) {
		if (i < cantidadUniversidades) {
			return lista[i];
		}
		else {
			return null;
		}
	}
	

}
