package cl.ucn.ei.pa.sistemaUniversidades.logica;

import java.io.IOException;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Carrera;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.Estatal;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.G9;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.Privada;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.Universidad;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

public class App {
	
	public static void leerUniversidades(SistemaUniversidades sistema) throws IOException{
		ArchivoEntrada archivo = new ArchivoEntrada("Universidades.txt");
		while(!archivo.isEndFile()) {
			Registro registro = archivo.getRegistro();
			int cod = registro.getInt();
			String nombre = registro.getString();
			boolean gratuidad = registro.getBoolean();
			int tipo = registro.getInt();
			if (tipo == 2)  {//Privada
				boolean adscrita = registro.getBoolean();
				sistema.ingresarUniversidadPrivada(cod, nombre, gratuidad, adscrita);
			}
			else {//tipo = 1, del Cruch
				double por = registro.getDouble();
				int  estatalG9 = registro.getInt();
				if(estatalG9 == 1) {
					sistema.ingresarUniversidadEstatal(cod, nombre, gratuidad, por);
				}
				else {
					sistema.ingresarUniversidadG9(cod, nombre, gratuidad, por);
				}
			}
		}
		archivo.close();
	}
	
	public static void leerCarreras(SistemaUniversidades sistema) throws IOException{
		ArchivoEntrada archivo = new ArchivoEntrada("Carreras.txt");
		while(!archivo.isEndFile()) {
			Registro registro = archivo.getRegistro();
			int cod = registro.getInt();
			String nombre = registro.getString();
			int duracion = registro.getInt();
			int costoEstimadoSemestral = registro.getInt();
			sistema.ingresarCarrera(cod, nombre, duracion, costoEstimadoSemestral);
		}
		archivo.close();
	}
	
	public static void leerUniversidadesCarreras(SistemaUniversidades sistema) throws IOException {
		ArchivoEntrada archivo = new ArchivoEntrada("UniversidadesCarreras.txt");
		while(!archivo.isEndFile()) {
			Registro registro = archivo.getRegistro();
			int codUniversidad = registro.getInt();
			int codCarrera = registro.getInt();
			try {
				sistema.asociarCarreraUniversidad(codUniversidad, codCarrera);
			}catch(NullPointerException ex) {
				StdOut.println(ex.getMessage());
			}
		}
		archivo.close();
	}
	
	
	public static void leerOrganizaciones(SistemaUniversidades sistema) throws IOException{
		ArchivoEntrada archivo = new ArchivoEntrada("Organizaciones.txt");
		while(!archivo.isEndFile()) {
			Registro registro = archivo.getRegistro();
			int cod = registro.getInt();
			String nombreOrganizacion = registro.getString();
			int monto = registro.getInt();
			String nombreUniversidad = registro.getString();
			boolean asociacion = true;
			try {
				asociacion = sistema.asociarOrganizacionUniversidadPrivada(nombreUniversidad, cod, nombreOrganizacion, monto);
			}catch(NullPointerException ex) {
				StdOut.println(ex.getMessage());
			}
			if(!asociacion) {
				StdOut.println("No se pudo hacer la asociacion entre la universidad " + nombreUniversidad +" y organizacion "+ nombreOrganizacion);
			}
		}
		archivo.close();
	}
	
	public static void leerInformacionAcreditacionUniversidades(SistemaUniversidades sistema) {
		ListaUniversidades listaUniversidades = sistema.obtenerUniversidades();
		for(int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			StdOut.println("\n Ingrese informacion acreditacion universidad "+ universidad.getNombre());
			StdOut.print("Acreditada? [1]==> Si; [2] ==> No " );
			int acreditada = StdIn.readInt();
			if (acreditada == 1) {
				StdOut.print("Agnos acreditacion : " );
				int años = StdIn.readInt();
				StdOut.print("Fecha inicio acreditacion [DDMMAAAA]: " );
				String fechaInicio= StdIn.readString();
				StdOut.print("Fecha fin acreditacion [DDMMAAAA]: " );
				String fechaFin= StdIn.readString();
				//Debiera validarse las fechas y que sea consistente con los años de acreditacion
				
				universidad.setAcreditada(true);
				universidad.setAñosAcreditacion(años);
				universidad.setFechaInicioAcreditacion(fechaInicio);
				universidad.setFechaFinAcreditacion(fechaFin);
			}
			else {
				universidad.setAcreditada(false);
				universidad.setAñosAcreditacion(0);
				universidad.setFechaInicioAcreditacion(null);
				universidad.setFechaFinAcreditacion(null);
			}
		}
	}
	
	public static void leerInformacionAcreditacionUniversidadCarrera(SistemaUniversidades sistema) {
		StdOut.println("");
		StdOut.println("\nLectura de las acreditaciones de cada carrera de cada universidad");
		StdOut.println("");
		
		ListaUniversidades listaUniversidades = sistema.obtenerUniversidades();
		for(int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			StdOut.println("\n");
			StdOut.println("Lectura de la acreditacion de las carreras de la universidad: "+universidad.getNombre());
			ListaCarreras listaCarrerasUniversidad = universidad.getListaCarreras();
			for(int j = 0; j < listaCarrerasUniversidad.getCantidadCarreras(); j++) {
				Carrera carrera = listaCarrerasUniversidad.getCarreraI(j);
				StdOut.println("Ingrese informacion acreditacion carrera "+ carrera.getNombre());
				StdOut.print("Acreditada? [1]==> Si; [2] ==> No " );
				int acreditada = StdIn.readInt();
				if (acreditada == 1) {
					StdOut.print("Agnos acreditacion : " );
					int años = StdIn.readInt();
					StdOut.print("Fecha inicio acreditacion [DDMMAAAA]: " );
					String fechaInicio= StdIn.readString();
					StdOut.print("Fecha fin acreditacion [DDMMAAAA]: " );
					String fechaFin= StdIn.readString();
					//Debiera validarse las fechas y que sea consistente con los años de acreditacion	
					sistema.ingresarAcreditacionCarreraUniversidad(universidad, carrera, true, años, fechaInicio, fechaFin);
				}
				else {
					sistema.ingresarAcreditacionCarreraUniversidad(universidad, carrera, false, 0, null, null);
				}
				
			}
		} 
	}
	
	public static void lecturaArancelesBasicos(SistemaUniversidades sistema){
		
		//Primero se lee el arncel básico de las universidades estatales. Es uno solo, para todas las universodades
		StdOut.print("\nIngrese arancel basico de las universidades estatales: ");
		int arancelBasico = StdIn.readInt();
		Estatal.setArancelBasico(arancelBasico);
		
		//Se lee el arancel básico por cada universidad del G9
		ListaUniversidades listaUniversidades = sistema.obtenerUniversidades();
		for (int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			if (universidad instanceof G9) {
				StdOut.print("\nIngrese arancel basico de la universidades del G9 con nombre "+ universidad.getNombre()+ ": ");
				arancelBasico = StdIn.readInt();
				G9 univG9 = (G9)universidad;
				univG9.setArancelBasico(arancelBasico);
			}
		}
		
		//Se lee el arancel basico por cada carrera de cada universidad privada
		for (int i = 0; i < listaUniversidades.getCantidadUniversidades(); i++) {
			Universidad universidad = listaUniversidades.getUniversidadI(i);
			if (universidad instanceof Privada) {
				Privada privada = (Privada) universidad;
				ListaCarreras listaCarrerasUniversidad = universidad.getListaCarreras();
			
				for(int j = 0; j < listaCarrerasUniversidad.getCantidadCarreras(); j++) {
					Carrera carreraUniversidad = listaCarrerasUniversidad.getCarreraI(j);
					StdOut.print("\nIngrese arancel basico de la carrera " + carreraUniversidad.getNombre()+ " de la universidad privada "+ universidad.getNombre()+ ": ");
					arancelBasico = StdIn.readInt();
					sistema.ingresarArancelCarreraUniversidadPrivada(arancelBasico, privada, carreraUniversidad);
				}
			}
		}
	}
	
	public static void desplegarUniversidadesUnaCarrera(SistemaUniversidades sistema) {
		StdOut.println();
		StdOut.print("\nIngrese codigo carrera para buscar universidades donde se imparte: ");
		int codigoCarrera = StdIn.readInt();
		try {
			StdOut.println(sistema.datosUniversidadesUnaCarrera(codigoCarrera));
		}catch(NullPointerException ex) {
			StdOut.println(ex.getMessage());
		}
	}
	
	public static void desplegarOrganizacionApoyoUniversidad(SistemaUniversidades sistema) {
		StdOut.println();
		StdOut.print("\nNombre universidad privada para ver organizacion que la apoya: ");
		String nombreUniversidad = StdIn.readString();
		
		try {
			StdOut.println(sistema.obtenerDatosOrganizacionApoyaUniversidadPrivada(nombreUniversidad));
		}catch(NullPointerException ex) {
			StdOut.println(ex.getMessage());
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		
		SistemaUniversidades sistema = new SistemaUniversidadesImpl();
		
		leerUniversidades(sistema);
		
		leerCarreras(sistema);
	
		leerUniversidadesCarreras(sistema);
		
		leerOrganizaciones(sistema);
		
		leerInformacionAcreditacionUniversidades(sistema);
		
		leerInformacionAcreditacionUniversidadCarrera(sistema);
		
		lecturaArancelesBasicos(sistema);
		
		StdOut.println(sistema.datosUniversidadesCarreras());
		
		desplegarUniversidadesUnaCarrera(sistema);
		
		try {
			StdOut.println(sistema.nombreCarrerasUCN());
		}catch(NullPointerException ex) {
			StdOut.println(ex.getMessage());
		}
		
		desplegarOrganizacionApoyoUniversidad(sistema);
		
		StdOut.println(sistema.obtenerDatosUniversidadesMas10Carreras());
	}

}
