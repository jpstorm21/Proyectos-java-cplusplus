/**
 * 
 */
package logica;

import dominio.Barco;
import dominio.Contenedor;
import dominio.Normal;
import dominio.Refrigerado;
import ucn.StdIn;
import ucn.StdOut;

/**
 * @author Cristian Chiang
 *
 */
public class SistemaPuertoApp {

	
	
	/**
	 * 
	 */
	public static void ingresarBarco(SistemaPuerto sistema) {
		StdOut.print("Ingrese el Nombre del Barco: ");
		String nombreBarco = StdIn.readString();
		StdOut.print("Ingrese el País del Barco: ");
		String paisBarco = StdIn.readString();
		Barco b = new Barco(nombreBarco, paisBarco);
		StdOut.print("Ingrese el código del contenedor: ");
		String codCont = StdIn.readString();
		while(!codCont.equalsIgnoreCase("fin")) {
			Contenedor c;
			StdOut.print("Ingrese la capacidad del contenedor: ");
			int capa = StdIn.readInt();
			StdOut.print("Ingrese la carga del contenedor: ");
			int carga = StdIn.readInt();
			StdOut.print("Ingrese el tipo de contenedor (1 Normal / 2 Refrigerado): ");
			int tipo = StdIn.readInt();
			if(tipo == 2) {
				StdOut.print("Ingrese la fecha de vencimiento del contenedor: ");
				String fechaVencimiento = StdIn.readString();
				c = new Refrigerado(codCont, capa, carga, fechaVencimiento);
			}else {
				c = new Normal(codCont, capa, carga);
			}
			b.getContenedores().add(c);
		}
		sistema.ingresarBarco(nombreBarco, paisBarco);
	}
	
	public static void descargarBarco(SistemaPuerto sistema) {
		StdOut.print("Ingrese el número del sitio a descargar: ");
		int sitio = StdIn.readInt();
		sistema.descargarBarco(sitio);
	}
	
	public static void imprimirCostosOperacion(SistemaPuerto sistema) {
		StdOut.print("Costos totales de operación: " + sistema.obtenerCostosOperacion());
	}
	
	
	public static void main(String[] args) {
		SistemaPuerto sistema = new SistemaPuertoImpl(); 
		ingresarBarco(sistema);
		descargarBarco(sistema);
		imprimirCostosOperacion(sistema);
	}

}
