import ucn.StdOut;

/**
 * 
 */

/**
 * @author Cristian Chiang
 *
 */
public class ArbolABBApp {

	private static ArbolABB arbol = new ArbolABB();

	private static void llenarABB() {
		arbol.insertar("nuevo");
		arbol.insertar("silbar");
		arbol.insertar("fuerte");
		arbol.insertar("zoológico");
		arbol.insertar("aeropuerto");
		arbol.insertar("puerta");
		arbol.insertar("hueso");
		arbol.insertar("gato");
		arbol.insertar("queso");
		arbol.insertar("iglesia");
		arbol.insertar("oso");
		arbol.insertar("urbe");
		arbol.insertar("zumbido");
		arbol.insertar("abaco");
		arbol.insertar("barco");
	}

	private static void convertirABB() {
		StdOut.println("Convertir nuevo      : " + arbol.convertir("nuevo"));
		StdOut.println("Convertir silbar     : " + arbol.convertir("silbar"));
		StdOut.println("Convertir fuerte     : " + arbol.convertir("fuerte"));
		StdOut.println("Convertir zoológico  : " + arbol.convertir("zoológico"));
		StdOut.println("Convertir aeropuerto : " + arbol.convertir("aeropuerto"));
		StdOut.println("Convertir puerta     : " + arbol.convertir("puerta"));
		StdOut.println("Convertir hueso      : " + arbol.convertir("hueso"));
		StdOut.println("Convertir gato       : " + arbol.convertir("gato"));
		StdOut.println("Convertir queso      : " + arbol.convertir("queso"));
		StdOut.println("Convertir iglesia    : " + arbol.convertir("iglesia"));
		StdOut.println("Convertir oso        : " + arbol.convertir("oso"));
		StdOut.println("Convertir urbe       : " + arbol.convertir("urbe"));
		StdOut.println("Convertir zumbido    : " + arbol.convertir("zumbido"));
		StdOut.println("Convertir abaco      : " + arbol.convertir("abaco"));
		StdOut.println("Convertir barco      : " + arbol.convertir("barco"));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		llenarABB();
		StdOut.println(arbol.imprimirNiveles());
		convertirABB();
		
	}

}
