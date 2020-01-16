/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleeer1;

import java.io.File;
import java.util.Scanner;
import ucn.In;
import ucn.StdIn;
import ucn.StdOut;

public class Talleeer1 {

    public static int leerJuegosTxt(String matrizJ[][]) {
        int pos = 0;
        In archivoEntrada = new In("juegos.txt");

        while (!archivoEntrada.isEmpty()) {
            String leer = archivoEntrada.readLine();
            String[] linea = leer.split(",");
            matrizJ[pos][0] = linea[0];
            matrizJ[pos][1] = linea[1];
            matrizJ[pos][2] = linea[2];
            matrizJ[pos][3] = linea[3];
            matrizJ[pos][4] = linea[4];
            matrizJ[pos][5] = linea[5];
            pos++;
        }
        archivoEntrada.close();
        return pos;

    }

    public static int leerCategoriasTxt(String matrizC[][]) {
        int pos2 = 0;
        In archivoEntrada2 = new In("categorias.txt");

        while (!archivoEntrada2.isEmpty()) {
            String leer = archivoEntrada2.readLine();
            String[] linea = leer.split(",");
            matrizC[pos2][0] = linea[0];
            matrizC[pos2][1] = linea[1];
            pos2++;
        }
        archivoEntrada2.close();
        return pos2;

    }

    public static void RF1(String [][] matrizJ, int cantJuegos) {
        System.out.print("Ingrese año de lanzamiento: ");
        String año = StdIn.readString();
        
        int contVendidas = 0;
        int ganancias = 0;
        
        for(int i = 0; i < cantJuegos; i++){
            if(matrizJ[i][2].equalsIgnoreCase(año)){
                if(Integer.parseInt(matrizJ[i][5]) > contVendidas){
                    contVendidas = Integer.parseInt(matrizJ[i][5]);
                }
                if(Integer.parseInt(matrizJ[i][4]) > ganancias){
                    ganancias = Integer.parseInt(matrizJ[i][4]);
                }
            }               
        }
        StdOut.println("Los juegos con mayores cantidad vendidas son: ");
        for(int i = 0; i < cantJuegos; i++){
            if(Integer.parseInt(matrizJ[i][5]) == contVendidas){
                StdOut.println("-" + matrizJ[i][1]);
                StdOut.println("Con la cantidad vendida de: " + contVendidas);
            }
        }
        StdOut.println("Los juegos con mayores cantidad de ganancia son: ");
        for(int i = 0; i < cantJuegos; i++){
            if(Integer.parseInt(matrizJ[i][5]) == contVendidas){
                StdOut.println("-" + matrizJ[i][1]);
                StdOut.println("Con una ganancia de: " + ganancias);
            }
        }

    }

    public static void RF2() {

    }

    public static void RF3() {

    }

    public static void menu(String [][] matrizJ, int cantJuegos) {
        int opcionmenu = 0;
        while (opcionmenu != 4) {
            StdOut.println("A continuacion se le mostrara las opciones que quiera realizar:");
            StdOut.println("//////////////////////////////////////////////////////////////");
            StdOut.println("1.- Desplegar datos de juego dependiendo su año de lanzamiento");
            StdOut.println("2.- Desplegar ganancia total de una categoria de juegos");
            StdOut.println("3.- Generar archivos Top 10 dependiendo su categoria");
            StdOut.println("4.- Salir");
            StdOut.println("///////////////");
            StdOut.println("Ingrese opcion: ");
            opcionmenu = StdIn.readInt();

            if (opcionmenu == 1) {
                 RF1(matrizJ, cantJuegos);

            }
            if (opcionmenu == 2) {
                RF2();

            }
            if (opcionmenu == 3) {
                RF3();

            }
            if (opcionmenu == 4) {
                StdOut.println("///////////////");
                StdOut.println("Se ha finalizado el programa");

            }
        }
    }

    public static void main(String[] args) {

        String matrizJ[][] = new String[99][6];
        String matrizC[][] = new String[99][2];
        int cantJuegos = leerJuegosTxt(matrizJ);
        int cantCatego = leerCategoriasTxt(matrizC);
        menu(matrizJ, cantJuegos);

    }

}
