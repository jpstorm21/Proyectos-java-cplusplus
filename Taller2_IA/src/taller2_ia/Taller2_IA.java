/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2_ia;

import java.util.LinkedList;

/**
 *
 * @author Juan Carlos Lamas
 * @author Juan Pablo Martínez
 */
public class Taller2_IA {

  public static int ciudadInicial;
  public static int n;
  public static int[][] costeCaminos;
  public static LinkedList<Integer> camino;
  public static int costeTotal;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Leer cantidad de ciudades
     n = Integer.parseInt(args[0]);
    //n = 9;
    ciudadInicial = randomWithRange(0, n - 1);

    // Crear matriz de N x N  con costes de caminos
    costeCaminos = crearCaminos(n, n);

    // Crear camino
    camino = new LinkedList<>();
    
    // Iniciar Coste total
    costeTotal = 0;

    // Imprimir ciudad inicial y caminos
    System.out.println("\nCiudad Inicial Viajero: " + (ciudadInicial + 1) + "\n");
    printCost(costeCaminos);
    
    // Encontrar camino optimo haciendo uso de algoritmo hillClimbing
    hillClimbing(ciudadInicial);
    
    System.out.println("\nCamino: \n");
    System.out.println(camino.toString());
    System.out.println("\nCoste total: " + costeTotal + "\n\n");
  }

  public static int[][] crearCaminos(int n, int m) {
    int[][] mapa = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == j) {
          mapa[i][j] = 0;
        } else if (mapa[i][j] == 0) {
          mapa[i][j] = mapa[j][i] = randomWithRange(1, 100);
        }
      }
    }
    return mapa;
  }

  /* Funciona para números aleatorios en un rango */
  public static int randomWithRange(int min, int max) {
    int range = (max - min) + 1;
    return (int) (Math.random() * range) + min;
  }

  public static void printCost(int[][] m) {
    try {
      int rows = m.length;
      int columns = m[0].length;
      String str = "";
      for (int w = 0; w < columns; w++) {
        str += "\t" + (w + 1);
      }
      str += "\n";
      for (int w = 0; w < columns; w++) {
        str += "\t-";
      }
      str += "\n";
      str += "1|\t";
      for (int i = 0; i < rows; i++) {

        for (int j = 0; j < columns; j++) {
          str += m[i][j] + "\t";
        }
        System.out.println(str + "|");
        str = (i + 2) + "|\t";
      }
      System.out.println("\n*********************************************\n");
    } catch (Exception e) {
      System.out.println("Matrix is empty!!");
    }
  }

  public static void hillClimbing(int ciudadActual) {
    
    //agregar actual en el array de caminos
    camino.addLast((ciudadActual+1));  
    if(camino.size() < n) {
      //agregar los hijos ordenados en el estado
      int [] ciudadMasCercana = hijoMenor(ciudadActual);
      costeTotal += ciudadMasCercana[1];
      //llamar a la funcion recursivamente con el mejor hijo siendo la nueva pos
      hillClimbing(ciudadMasCercana[0]);
    }
    //se detiene cuando se recorrieron las n ciudades (n llamados recursivos)
  }

  private static int [] hijoMenor(int ciudadActual) {
    int mejorCoste = 9999;
    int mejor = -1;
    
    for(int i = 0; i<n; i++){
      if(!camino.contains((i+1))){
        if(costeCaminos[ciudadActual][i] < mejorCoste){
          mejorCoste = costeCaminos[ciudadActual][i];
          mejor = i;
        }
      }
    }
    
    int [] mejorCiudad = new int[2];
    mejorCiudad[0] = mejor;
    mejorCiudad[1] = mejorCoste;   
    
    return mejorCiudad;
  }
}


