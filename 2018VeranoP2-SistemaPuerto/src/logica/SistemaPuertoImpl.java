/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import dominio.Barco;
import dominio.Contenedor;
import dominio.Grua;
import dominio.Sitio;

/**
 * @author Cristian Chiang
 *
 */
public class SistemaPuertoImpl implements SistemaPuerto {

	private ListaGruas listaGruas;
	private LinkedList<Barco> listaBarcos;
	private ArrayList<Sitio> listaSitios;
	
	/**
	 * 
	 */
	public SistemaPuertoImpl() {
		this.listaGruas = new ListaGruas();
		this.listaBarcos = new LinkedList<Barco>();
		this.listaSitios = new ArrayList<Sitio>();
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#ingresarBarco(dominio.Barco)
	 */
	@Override
	public boolean ingresarBarco(String n, String p) {
		boolean resp = false;
		Barco b = new Barco(n, p);
		if(!this.listaBarcos.contains(b)) {
			this.listaBarcos.add(b);
			resp = true;
		}
		return resp;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#obtenerSitiosOcupados()
	 */
	@Override
	public String obtenerSitiosOcupados() {
		String ocupados = "Todos los sitios disponibles!";
		if(!this.listaSitios.isEmpty()) {
			ocupados = "";
			for(Sitio sitio : this.listaSitios) {
				if(sitio.getBarco() != null) {
					ocupados += sitio.getNumero() + " ";
				}
			}
		}
		return ocupados;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#descargarBarco(int)
	 */
	@Override
	public void descargarBarco(int sitio) {
		Sitio sitioBarco = this.listaSitios.get(sitio);
		Barco barco = sitioBarco.getBarco();
		Iterator<Contenedor> it = barco.getContenedores().iterator();
		boolean descargado = false;
		while(it.hasNext()) {
			Contenedor cont = it.next();
			while(!descargado) {
				Grua grua1 = sitioBarco.getGrua1();
				if(grua1.intentaAdd(cont)) {
					grua1.agregaContenedor(cont);
					descargado = true;
				}else {
					grua1.setEnMantencion(true);
					sitioBarco.setGrua1(this.listaGruas.obtenerDisponible());
					Grua grua2 = sitioBarco.getGrua2();
					if(grua2.intentaAdd(cont)) {
						grua2.agregaContenedor(cont);
						descargado = true;
					}else {
						grua2.setEnMantencion(true);
						sitioBarco.setGrua2(this.listaGruas.obtenerDisponible());
					}
				}
				this.realizarMantenciones();
			}
		}
		this.liberarSitio(sitio);
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#liberarSitio(int)
	 */
	@Override
	public boolean liberarSitio(int sitio) {
		if(this.listaSitios.get(sitio).getBarco().getContenedores().isEmpty()) {
			this.listaSitios.get(sitio).setBarco(null);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#obtenerTotalCargaMovida()
	 */
	@Override
	public String obtenerTotalCargaMovida() {
		String resp = "No hay carga movida en el puerto";
		int totalCarga = this.listaGruas.getCargaMovida();
		if(totalCarga > 0) {
			resp = "";
			resp = "La carga total movida fu�: " + totalCarga + " Toneladas";
		}
		return resp;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#obtenerBarcos()
	 */
	@Override
	public ArrayList<Barco> obtenerBarcos() {
		ArrayList<Barco> descargados = new ArrayList<Barco>();
		for(Sitio sitio : this.listaSitios)
			for(Barco barco : sitio.getDescargados())
				descargados.add(barco);		
		return descargados;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#obtenerCostosOperacion()
	 */
	@Override
	public int obtenerCostosOperacion() {
		return this.listaGruas.getCostoOperacion();
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#obtenerGruasSitio(int)
	 */
	@Override
	public String obtenerGruasSitio(int sitio) {
		String resp = "El sitio no ha tenido gr�as!";
		for(Sitio s : this.listaSitios) {
			if(s.getNumero() == sitio){
				ListaGruas lg = s.getGruas();
				resp = lg.toString();
			}
		}
		return resp;
	}

	/* (non-Javadoc)
	 * @see logica.SistemaPuerto#realizarMantenciones()
	 */
	@Override
	public void realizarMantenciones() {
		this.listaGruas.realizarMantencion();
	}

}
