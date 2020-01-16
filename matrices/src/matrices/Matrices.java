/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import ucn.*;

/**
 *
 * @author Usuario
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] vectorFila = {"cavs","golden","okc","heat"};
        String[] vectorCol = {"cavs","golden","okc","heat"};
        int[][] matriz = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                StdOut.print("ingrese puntos obtenidos por el equipo " + (j + 1) + " : ");
                int puntaje = StdIn.readInt();
                while (vectorFila[i] == vectorCol[j] && puntaje != 0) {
                    StdOut.println("son los mismo equipos debe ingresar 0 : ");
                    StdOut.print("ingrese puntos obtenidos por el equipo " + (j + 1) + " : ");
                    puntaje = StdIn.readInt();
                }
                while (puntaje != 0 && puntaje != 1 && puntaje != 3) {
                    StdOut.println("ingrese puntaje entre 0,1 o 3");
                    StdOut.print("ingrese puntos obtenidos por el equipo " + (j + 1) + " : ");
                    puntaje = StdIn.readInt();
                }
                matriz[i][j] = puntaje;
            }
        }
        int suma = 0;
        int mayor = -1;
        int posCampeon = 0;
        StdOut.println("los puntajes son los siguientes");
        for (int i = 0; i < 4; i++) {
            suma = 0;
            for (int j = 0; j < 4; j++) {
                suma = suma + matriz[i][j];
            }
            if (suma > mayor) {
                mayor = suma;
                posCampeon = i;
            }
            StdOut.println(vectorFila[i] + " " + suma + " pts");
        }
        StdOut.println("el campeon es " + vectorFila[posCampeon] + " con " + mayor + " pts");
    }

}
