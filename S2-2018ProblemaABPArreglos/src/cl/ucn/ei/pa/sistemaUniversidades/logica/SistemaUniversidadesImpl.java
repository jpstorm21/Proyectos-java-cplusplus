package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.*;


public class SistemaUniversidadesImpl implements SistemaUniversidades{
	
	private ListaUniversidades listaUniversidades;
	private ListaCarreras listaCarreras;
	
	public SistemaUniversidadesImpl() {
		listaUniversidades = new ListaUniversidades(20);
		listaCarreras = new ListaCarreras(20);
	}
	
	public boolean ingresarUniversidadEstatal(int codigo, String nombre, boolean gratuidad, double por) {
		Universidad universidad = new Estatal(codigo, nombre, gratuidad, por);
		boolean ingreso = listaUniversidades.ingresar(universidad);
		if(ingreso) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ingresarUniversidadG9(int codigo, String nombre, boolean gratuidad, double por) {
		Universidad universidad = new G9(codigo, nombre, gratuidad, por);
		boolean ingreso = listaUniversidades.ingresar(universidad);
		if(ingreso) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean ingresarUniversidadPrivada(int codigo, String nombre, boolean gratuidad, boolean adscrita) {
		Universidad universidad = new Privada(codigo, nombre, gratuidad, adscrita);
		boolean ingreso = listaUniversidades.ingresar(universidad);
		if(ingreso) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ingresarCarrera(int codigo, String nombre, int duracion, int costoEstimadoSemestral) {
		Carrera carrera = new Carrera(codigo, nombre, duracion, costoEstimadoSemestral);
		boolean ingreso = listaCarreras.ingresar(carrera);
		if(ingreso) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void asociarCarreraUniversidad(int codigoUniversidad, int codigoCarrera) {
		Universidad universidad = listaUniversidades.buscarPorCodigo(codigoUniversidad);
		Carrera carrera = listaCarreras.buscar(codigoCarrera);
		if (universidad != null && carrera != null) {
			carrera.getListaUniversidades().ingresar(universidad);
			universidad.getListaCarreras().ingresar(carrera);
		}
		else {
			throw new NullPointerException("universidad "+ codigoUniversidad+ " no existe y/o carrera " + codigoCarrera + " no existe");
		}
	}
	
	public boolean asociarOrganizacionUniversidadPrivada (String nombreUniversidad, int codigo, String nombreOrganizacion, int monto) {
		Universidad universidad = listaUniversidades.buscarPorNombre(nombreUniversidad);
		if (universidad == null) {
			throw new NullPointerException("universidad "+ nombreUniversidad+ " no existe");
		}
		else {
			if (universidad instanceof Privada) {
				Organizacion organizacion = new Organizacion(codigo, nombreOrganizacion, monto);
				Privada univPrivada = (Privada) universidad;
				univPrivada.setOrganizacion(organizacion);
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public ListaUniversidades obtenerUniversidades() {
		return listaUniversidades;
	}
	
	
	
	/*public ListaCarreras obtenerCarreras() {
		return listaCarreras;
	}
	*/
	public void ingresarAcreditacionCarreraUniversidad(Universidad universidad, Carrera carrera, boolean acreditada, int años,String fechaInicio, String fechaFin) {
		Acreditacion acreditacion = new Acreditacion(universidad, carrera, true, años,fechaInicio, fechaFin);
		carrera.getListaAcreditaciones().ingresar(acreditacion);
		universidad.getListaAcreditaciones().ingresar(acreditacion);
	}
	
	public void ingresarArancelCarreraUniversidadPrivada(int arancelBasico, Privada privada, Carrera carrera) {
		Arancel arancel = new Arancel(arancelBasico, privada, carrera);
		privada.getListaAranceles().ingresar(arancel);
		carrera.getListaAranceles().ingresar(arancel);
	}
	
	public String datosUniversidadesCarreras() {
		String salida = "\nUniversidades y sus carreras \n";
		for(int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			if(universidad instanceof Privada) {
				Privada univPrivada = (Privada) universidad;
				salida = salida + "\n"+univPrivada.toString()+ "\n";
			}
			else {
				if(universidad instanceof Estatal) {
					Estatal univEstatal = (Estatal) universidad;
					salida = salida + "\n"+ univEstatal.toString()+ "\n";
				}
				else {
					G9 univG9 = (G9) universidad;
					salida = salida + "\n"+univG9.toString()+ "\n";
				}
			}
			salida = salida + "\n";
			
			//Carreras de la universidad
			ListaCarreras listaCarrerasUniversidad = universidad.getListaCarreras();
			salida = salida +"Carreras de la universidad " + universidad.getNombre()+ "\n";
			for(int j = 0; j < listaCarrerasUniversidad.getCantidadCarreras(); j++) {
				Carrera carrera = listaCarrerasUniversidad.getCarreraI(j);
				salida = salida + carrera.toString() + "\n";
			}
		}
		return salida;
		
	}
	
	public String datosUniversidadesUnaCarrera (int codigoCarrera) {
		Carrera carrera = listaCarreras.buscar(codigoCarrera);
		if (carrera == null) {
			throw new NullPointerException("carrera con codigo "+ codigoCarrera+ " no existe");
		}
		else {
			String salida ="\n";
			salida = salida + "\n" + "Carrera " +carrera.getNombre() + " se imparte en las siguientes universidades: \n";
			ListaUniversidades listaUniversidadesCarrera = carrera.getListaUniversidades();
			for(int i = 0; i < listaUniversidadesCarrera.getCantidadUniversidades(); i++) {
				Universidad universidad = listaUniversidadesCarrera.getUniversidadI(i);
				
				//calculo de lo que cobra la universidad por la carrera
				double valor ;
				double valorCarrera;
				G9 univG9;
				Estatal univEstatal;
				Privada univPrivada;
				double arancel;
				double alfa = universidad.calcularAlfa();
				if (universidad instanceof Estatal || universidad instanceof G9) {
					double por;
					if (universidad instanceof Estatal) {
						univEstatal = (Estatal) universidad;
						por = univEstatal.getPor();
						arancel = Estatal.getArancelBasico();
					}
					else {
						univG9 = (G9) universidad;
						por = univG9.getPor();
						arancel =univG9.getArancelBasico();
					}
					int cantidadSemestres = 2 * carrera.getAñosDuracion();
					double sum = 0;
					for(int j = 1 ; j <= cantidadSemestres; j++) {
						sum = sum + (1 + por)* carrera.getCostoEstimadoSemestral();
					}
					valor = alfa + sum;
					valorCarrera = carrera.getAñosDuracion()*arancel + valor;
					if (universidad.isAcreditada()) {
						valorCarrera = 0.7*valorCarrera;
					}
				}
				else {
					univPrivada = (Privada) universidad;
					double X = carrera.getCostoEstimadoSemestral()/20000;
					double prod = 1.0;
					int fact = 1;
					for(int j = 1; j <= carrera.getAñosDuracion(); j++) {
						//Calculo del factorial de j
						fact = fact * j;
						prod = prod * Math.pow(X,fact)/fact;
					}
					valor = prod + alfa;
					valorCarrera = carrera.getAñosDuracion()* obtenerArancelBasicoCarreraUniversidad(carrera, univPrivada) + valor;
				}
				
				salida = salida + "nombre universidad: "+ universidad.getNombre()+ ", valor de la carrera en la universidad: " + valorCarrera + "\n";
			}
			return salida;
		}
	}
	
	private double obtenerArancelBasicoCarreraUniversidad(Carrera carrera, Privada univPrivada) {
		ListaAranceles listaArancelesCarrera = carrera.getListaAranceles();
		for(int i = 0; i < listaArancelesCarrera.getCantidadAranceles(); i++) {
			Arancel arancel = listaArancelesCarrera.getArancel(i);
			if(arancel.getPrivada()==univPrivada){
				return arancel.getArancelBasico();
			}
		}
		return -1;
	}
	
	public String nombreCarrerasUCN() {
		String salida ="\n";
		
		Universidad universidad = listaUniversidades.buscarPorNombre("ucn");
		if (universidad == null) {
			throw new NullPointerException("universidad UCN no existe");
		}
		else {
			salida = salida + "\n" + "Carreras de la UCN \n" ;
			ListaCarreras listaCarrerasUCN = universidad.getListaCarreras();
			for(int i = 0; i < listaCarrerasUCN.getCantidadCarreras(); i++) {
				Carrera carrera = listaCarrerasUCN.getCarreraI(i);
				salida = salida + "carrera "+ carrera.getNombre()+ "\n";
			}
		}
		return salida;
	}
		
	public String obtenerDatosOrganizacionApoyaUniversidadPrivada(String nombreUniversidad) {
		Universidad universidad = listaUniversidades.buscarPorNombre(nombreUniversidad);
		if (universidad == null) {
			throw new NullPointerException("universidad " + nombreUniversidad+  " no existe");
		}
		else {
			String salida = "\n";
			if (universidad instanceof Privada) {
				salida = salida + "\n" + "Codigo universidad " + universidad.getCodigo()+ ", Organizacion que apoya a la universidad " + nombreUniversidad+ "\n" ;
				Privada univPrivada = (Privada)universidad;
				if(univPrivada.getOrganizacion()!= null) {
					salida = salida + " nombre: " + univPrivada.getOrganizacion().getNombre()+ ", monto: "+ univPrivada.getOrganizacion().getMonto();
				}
				else {
					salida = salida + " no tiene organizacion que la apoye";
				}
			}
			else {
				salida = salida + nombreUniversidad + " no es una universidad privada \n";
			}
			return salida;
		}
	}
	
	public String obtenerDatosUniversidadesMas10Carreras() {
		String salida ="\nInformacion de universidades con mas de 10 carreras\n";
		for(int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			if(universidad.getListaCarreras().getCantidadCarreras()> 10) {
				if(universidad instanceof Privada) {
					Privada univPrivada = (Privada) universidad;
					salida = salida + "\n" + univPrivada.toString()+ "\n";
				}
				else {
					if(universidad instanceof Estatal) {
						Estatal univEstatal = (Estatal) universidad;
						salida = salida + "\n" +univEstatal.toString()+ "\n";
					}
					else {
						G9 univG9 = (G9) universidad;
						salida = salida + "\n" +univG9.toString()+ "\n";
					}
				}
				ListaCarreras listaCarrerasUniversidad = universidad.getListaCarreras();
				salida = salida + "\n carreras de la universidad \n";
				for(int j = 0; j < listaCarrerasUniversidad.getCantidadCarreras();j++) {
					Carrera carrera = listaCarrerasUniversidad.getCarreraI(j);
					salida = salida + "\n " +carrera.getNombre();
				}
				salida = salida + "\n";
			}
		}
		
		return salida;
	}
	
}
