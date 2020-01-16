package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Arancel;

public class ListaAranceles {
	private Arancel [] lista;
	private int cantidadAranceles;
	private int max;
	
	public ListaAranceles(int max) {
		lista = new Arancel[max];
		cantidadAranceles = 0;
		this.max = max;
	}
	
	public boolean ingresar(Arancel arancel) {
		if (cantidadAranceles < max) {
			lista[cantidadAranceles]= arancel;
			cantidadAranceles ++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Arancel getArancel(int i) {
		if(i >= 0 && i < cantidadAranceles) {
			return lista[i];
		}
		else {
			return null;
		}
	}

	public int getCantidadAranceles() {
		return cantidadAranceles;
	}

	public void setCantidadAranceles(int cantidadAranceles) {
		this.cantidadAranceles = cantidadAranceles;
	}
	
	
}
