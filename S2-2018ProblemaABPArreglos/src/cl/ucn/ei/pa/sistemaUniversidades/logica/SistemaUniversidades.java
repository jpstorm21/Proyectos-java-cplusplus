package cl.ucn.ei.pa.sistemaUniversidades.logica;

import cl.ucn.ei.pa.sistemaUniversidades.dominio.Carrera;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.Privada;
import cl.ucn.ei.pa.sistemaUniversidades.dominio.Universidad;

public interface SistemaUniversidades {
	
	public boolean ingresarUniversidadEstatal(int codigo, String nombre, boolean gratuidad, double por);
	
	public boolean ingresarUniversidadG9(int codigo, String nombre, boolean gratuidad, double por);
	
	public boolean ingresarUniversidadPrivada(int codigo, String nombre, boolean gratuidad, boolean adscrita);
	
	public boolean ingresarCarrera(int codigo, String nombre, int duracion, int costoEstimadoSemnestral);
	
	public void asociarCarreraUniversidad(int codigoUniversidad, int codigoCarrera);
	
	public boolean asociarOrganizacionUniversidadPrivada (String nombreUniversidad, int codigo, String nombtreOrganizacion, int monto);
	
	public ListaUniversidades obtenerUniversidades();
	
	public void ingresarAcreditacionCarreraUniversidad(Universidad universidad, Carrera carrera, boolean acreditada, int años,String fechaInicio, String fechaFin);
	
	public void ingresarArancelCarreraUniversidadPrivada(int arancel, Privada privada, Carrera carrera);
	
	public String datosUniversidadesCarreras();
	
	public String datosUniversidadesUnaCarrera (int codigoCarrera);
	
	public String nombreCarrerasUCN();
	
	public String obtenerDatosOrganizacionApoyaUniversidadPrivada(String nombreUniversidad);
	
	public String obtenerDatosUniversidadesMas10Carreras();
}
