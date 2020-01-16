/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercristobal;

import ucn.*;

public class TallerCristobal {

    public static int leeviajes(String[][] matrizviajes) {
        int pos = 0;
        In entrada = new In("viajes.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            matrizviajes[pos][0] = linea[0];
            matrizviajes[pos][1] = linea[1];
            matrizviajes[pos][2] = linea[2];
            pos++;
        }
        entrada.close();
        return pos;

    }

    public static int leedestinos(String[][] matrizdestinos) {
        int pos = 0;
        In entrada = new In("destinos.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            matrizdestinos[pos][0] = linea[0];
            matrizdestinos[pos][1] = linea[1];
            matrizdestinos[pos][2] = linea[2];
            pos++;
        }
        entrada.close();
        return pos;

    }

    public static void menu(String[][] matrizviajes, String[][] matrizdestinos, int cantviajes, int cantdestinos, String[] ciudades, String[] destinos, String[] precios, String[] clientesTotales) {
        int opcionmenu = 0;
        while (opcionmenu != 5) {
            StdOut.println("menu: ");
            StdOut.println("RF1");
            StdOut.println("RF2");
            StdOut.println("RF3");
            StdOut.println("RF4");
            StdOut.println("RF5(salir)");
            StdOut.println("------------------");
            StdOut.println("ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {
                TallerCristobal.RF1(matrizviajes, matrizdestinos, cantviajes, cantdestinos, ciudades, destinos, precios);
            }
            if (opcionmenu == 2) {
                TallerCristobal.RF2(matrizviajes, matrizdestinos, cantviajes, cantdestinos, ciudades, destinos, precios, clientesTotales, cantviajes);
            }
            if (opcionmenu == 3) {
                
            }
            if (opcionmenu == 4) {

            }

        }
    }

    public static void RF1(String[][] matrizviajes, String[][] matrizdestinos, int cantviajes, int cantdestinos, String[] ciudades, String[] destinos, String[] precios) {
        Out salida = new Out("ViajesPorMes.txt");
        String[] meses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        int cant = 0;
        int precio = 0;
        for (int j = 0; j < meses.length; j++) {
            salida.println("mes : " + meses[j]);
            salida.println("ciudades");
            for (int w = 0; w < ciudades.length; w++) {
                for (int i = 0; i < cantviajes; i++) {
                    if (matrizviajes[i][2].equals(meses[j]) && matrizviajes[i][1].equals(destinos[w])) {
                        cant++;
                    }
                }
                precio = Integer.parseInt(matrizdestinos[w][2]) * cant;
                String ciudad = ciudades[w];
                salida.println(ciudad + " cantidad de visitas " + cant + " con un valor de :" + precio);
                cant = 0;
            }
        }
        StdOut.println("archivo generado exitosamente");
    }


    public static void RF2(String[][] matrizviajes, String[][] matrizdestinos, int cantviajes, int cantdestinos, String[] ciudades, String[] destinos, String[] precios, String[] clientesTotales, int cantclientes) {
        Out salida = new Out("Clientes.txt");
        int cant = 0;
        int precio = 0;
        for (int i = 0; i < clientesTotales.length; i++) {
            salida.println("cliente : " + clientesTotales[i]);
            salida.println("ciudades que el cliente visito");
            for (int j = 0; j < destinos.length; j++) {
                for (int w = 0; w < cantviajes; w++) {
                    if (matrizviajes[w][0].equals(clientesTotales[i]) && matrizviajes[w][1].equals(destinos[j])) {
                        cant++;
                    }
                }
                if (cant != 0) {
                    precio = Integer.parseInt(matrizdestinos[j][2]) * cant;
                    String ciudad = ciudades[j];
                    salida.println(ciudad + " cantidad de visitas de " + cant + " con un valor de " + precio);
                    cant = 0;
                }
            }
        }
        StdOut.println("archivo generado exitosamente");
    }

    

    public static void main(String[] args) {
        String[][] matrizviajes = new String[9999][3];
        int cantviajes = TallerCristobal.leeviajes(matrizviajes);
        String[][] matrizdestinos = new String[9999][3];
        int cantdestinos = TallerCristobal.leedestinos(matrizdestinos);
        String[] ciudades = new String[cantdestinos];
        String[] destinos = new String[cantdestinos];
        String[] precios = new String[cantdestinos];
        for (int i = 0; i < cantdestinos; i++) {
            ciudades[i] = matrizdestinos[i][1];
            destinos[i] = matrizdestinos[i][0];
            precios[i] = matrizdestinos[i][2];
        }
        String[] clientesTotales = new String[cantviajes];
        for (int i = 0; i < cantviajes; i++) {
            clientesTotales[i] = matrizviajes[i][0];
        }
        TallerCristobal.menu(matrizviajes, matrizdestinos, cantviajes, cantdestinos, ciudades, destinos, precios, clientesTotales);
    }

}
