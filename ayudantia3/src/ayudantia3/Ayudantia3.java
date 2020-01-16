/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia3;

import java.io.IOException;
import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia3 {

    /**
     * @param args the command line arguments
     */
    public static int leerUsuarios(String[] usuarios) throws IOException {
        ArchivoEntrada arch1 = new ArchivoEntrada("usuarios.txt");
        int i = 0;
        while (!arch1.isEndFile()) {
            Registro reg = arch1.getRegistro();
            String nombre = reg.getString();
            usuarios[i] = nombre;
            i++;
        }
        arch1.close();
        return i;
    }

    public static int leerJuegos(String[] juegos) throws IOException {
        ArchivoEntrada arch2 = new ArchivoEntrada("juegos.txt");
        int i = 0;
        while (!arch2.isEndFile()) {
            Registro reg2 = arch2.getRegistro();
            String nombre = reg2.getString();
            juegos[i] = nombre;
            i++;
        }
        arch2.close();
        return i;
    }

    public static void leerJuegosUsuarios(int[][] matriz, int cantUsuarios, int cantJuegos, String[] usuarios, String[] juegos) throws IOException {
        ArchivoEntrada arch2 = new ArchivoEntrada("usuariojuego.txt");
        while (!arch2.isEndFile()) {
            Registro reg2 = arch2.getRegistro();
            String nombre = reg2.getString();
            String juego = reg2.getString();
            int n = reg2.getInt();
            int posX = 0;
            for (int i = 0; i < cantUsuarios; i++) {
                if (usuarios[i].equalsIgnoreCase(nombre)) {
                    posX = i;
                    break;
                }
            }
            int posY = 0;
            for (int j = 0; j < cantJuegos; j++) {
                if (juegos[j].equalsIgnoreCase(juego)) {
                    posY = j;
                    break;
                }
            }
            matriz[posX][posY] = n;
        }
        arch2.close();
    }

    public static boolean usuarioTieneJuego(int[][] matriz, int cantUsuarios, int cantJuegos, String[] usuarios, String[] juegos) {
        StdOut.print("ingrese juego: ");
        String juego = StdIn.readLine();
        StdOut.print("ingrese usuario: ");
        String usuario = StdIn.readString();
        int pos = 0;
        for (int j = 0; j < cantJuegos; j++) {
            if (juegos[j].equalsIgnoreCase(juego)) {
                pos = j;
                break;
            }
        }

        int posU = 0;
        for (int i = 0; i < cantUsuarios; i++) {
            if (usuarios[i].equalsIgnoreCase(usuario)) {
                posU = i;
                break;
            }
        }
        boolean tiene = false;
        if (matriz[posU][pos] == 1) {
            tiene = true;
        }
        return tiene;
    }

    public static void juegoMayor(int[][] matriz, int cantUsuarios, int cantJuegos, String[] juegos) {
        int mayor = -999;
        String nombre = "";
        for (int i = 0; i < cantJuegos; i++) {
            int suma = 0;
            for (int j = 0; j < cantUsuarios; j++) {
                suma = suma + matriz[j][i];
            }
            if (suma > mayor) {
                mayor = suma;
                nombre = juegos[i];
            }
        }
        StdOut.println("el juego que la mayoria de los usuario tiene es: " + nombre);
    }

    public static void main(String[] args) throws IOException {
        String[] usuarios = new String[100];
        String[] juegos = new String[100];
        int cantUsuarios = leerUsuarios(usuarios);
        int cantJuegos = leerJuegos(juegos);
        int[][] matriz = new int[5][5];
        leerJuegosUsuarios(matriz, cantJuegos, cantJuegos, usuarios, juegos);
       /* boolean esta = usuarioTieneJuego(matriz, cantUsuarios, cantJuegos, usuarios, juegos);
        if (esta) {
            StdOut.println("si tiene el juego");
        } else {
            StdOut.println("no tiene el juego");
        }
        juegoMayor(matriz, cantUsuarios, cantJuegos, juegos);*/
        for(int w = 0;w<cantJuegos;w++){
            System.out.print(juegos[w]+ " ");
        }
        System.out.println("");
        for (int i = 0; i < cantUsuarios; i++) {
            for (int j = 0; j < cantJuegos; j++) {
                System.out.print("    "+matriz[i][j] + "");
            }
            System.out.println("");
        }
    }

}
