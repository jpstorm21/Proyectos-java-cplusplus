/**
 * 
 */
package Logica;

import java.util.Scanner;

/**
 * @author Cristian Chiang
 *
 */
public class TraductorApp {

	private static boolean[][] diccionarios;
	private static int[] solActual;
	private static int[] solOptima;
	
	/**
	 * Método para cargar los idiomas
	 */
	public static void cargarIdiomas() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de Idiomas: ");
		int cantIdiomas = sc.nextInt();
		diccionarios = new boolean[cantIdiomas][cantIdiomas];
		for(int i=0; i<cantIdiomas; i++)
			for(int j=0; j<cantIdiomas; j++)
				diccionarios[i][j] = false;
		sc.close();
	}
		
	/**
	 * Método para cargar los diccionarios
	 */
	public static void cargarDiccionarios() {
		Scanner sc = new Scanner(System.in);
		//Leemos la cantidad de diccionarios
		System.out.print("Ingrese la cantidad de Diccionarios: ");
		int cantDiccionarios = sc.nextInt();
		//Si la cantidad es menor a 1 o mayor a la cantidad de idiomas
		while(cantDiccionarios < 1 || cantDiccionarios > diccionarios.length) {
			//Indicamos el error y solicitamos ingresar nuevamente la cantidad
			System.out.print("INGRESE UN NUMERO MAYOR A 0 Y MENOR A " + diccionarios.length + " !!!");
			System.out.print("Ingrese la cantidad de diccionarios: ");
			cantDiccionarios = sc.nextInt();
		}
		//Inicializamos el arreglo solución con 0
		for(int j=0; j<cantDiccionarios; j++) {
			solActual[j] = 0;
			solOptima[j] = 0;
		}
		//Para todos los diccionarios indicados
		for(int i=0; i<cantDiccionarios; i++) {
			System.out.println("Para el diccionario " + (i+1) +": ");
			//Solicitamos el idioma de origen
			System.out.print("Ingrese idioma de origen: ");
			int idiomaOrigen = sc.nextInt();
			//Y el idioma de destino
			System.out.print("Ingrese idioma de destino: ");
			int idiomaDestino = sc.nextInt();
			//Marcamos como True, que existe un diccionario para ambos idiomas
			diccionarios[idiomaOrigen][idiomaDestino] = true;
		}
		sc.close();
	}
	
	/**
	 * Función que verifica si el candidato es aceptable
	 * @param solActual
	 * @param etapa
	 * @return True si el candidato es aceptable, falso en caso contrario
	 */
	public static boolean aceptable(int etapa) {
		//Si no existe un diccionario para los idiomas indicados
		if(!diccionarios[solActual[etapa-1]][solActual[etapa]])
			//Retornamos falso
			return false;
		else
			//Si existe el diccionario, verificamos que no haya sido ingresado a la solución antes
			for(int i=1; i<etapa; i++)
				if(solActual[i] == solActual[etapa])
					return false;
			return true;
	}
	
	/**
	 * Método backtracking que encuentra la secuencia de traducciones mínima
	 * Almacena la solución en solOptima
	 * @param idiomaDestino
	 * @param numActualInicial
	 * @param numOptimo
	 * @param etapa
	 */
	public static void traducir(int idiomaDestino, int numActualInicial, int numOptimo, int etapa) {
		if(numActualInicial < numOptimo) {
			for(int k=0; k<solActual.length; k++) {
				solActual[etapa] = k;
				if(aceptable(etapa)) {
					int numActual = numActualInicial + 1;
					if(solActual[etapa] == idiomaDestino) {
						if(numActual < numOptimo) {
							numOptimo = numActual;
							solOptima = solActual;
						}else {
							traducir(idiomaDestino, numActual, numOptimo, etapa++);
						}
					}
				}
			}
		}
	}

	/**
	 * Método llamador
	 * @param idiomaOrigen
	 * @param idiomaDestino
	 * @return el número de traducciones mínima
	 */
	public static int traducir(int idiomaOrigen, int idiomaDestino) {
		solActual[0] = idiomaOrigen;
		int numTraducciones = 99999;
		traducir(idiomaDestino, 0, numTraducciones, 1);
		return numTraducciones;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cargarIdiomas();
		cargarDiccionarios();
		System.out.print("Ingrese el idioma de origen: ");
		int origen = sc.nextInt();
		System.out.print("Ingrese el idioma de destino: ");
		int destino = sc.nextInt();
		int traduccionesMinimas = traducir(origen, destino);
		System.out.println("El número de traducciones mínima es: " + traduccionesMinimas);
		System.out.print("Secuencia de Traducción: ");
		int i;
		for(i=0; i<traduccionesMinimas-1; i++)
			System.out.print(solOptima[i] + "-");
		System.out.println(solOptima[i]);
		sc.close();
	}

}
