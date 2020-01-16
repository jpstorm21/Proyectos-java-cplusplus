/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villagra.martinez;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class VillagraMartinez {

    private static final int COLUMNAS = 10;
    private static final int FILAS = 5;

    public static void main(String[] args) {
        JFrame v = new JFrame();
        v.setLocationRelativeTo(null);

        // el contenedor es donde almacena todo lo del jframe ( ventanita )
        v.getContentPane().setLayout(new GridLayout(FILAS, COLUMNAS)); //el grid es una rejilla

        JPanel[][] panel = new JPanel[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                panel[i][j] = new JPanel();
                v.getContentPane().add(panel[i][j]);
            }
        }
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        char[][] tablero = new char[5][5];
        tablero = Matriz(tablero);
        System.out.println("Tablero inicial: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
        }

        //'L' casillas Libres
        //'B' puesta la bomba
        //'R' hasta donde llega la explosion
        //'H' casilla con humano
        //'Z' casilla con zombie 
        if (backtraking(tablero)) {
            System.out.println("Solucion al problema");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("No se encuentra solucion");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
        menu.main(args);

    }

    public static char[][] Matriz(char[][] tablero) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = 'L';// L son las casillas disponibles para colocar una bomba

                if (Math.random() < 0.2) {
                    tablero[i][j] = 'Z';// Z casillas donde hay zombies
                }
                if (Math.random() < 0.05) {
                    tablero[i][j] = 'H';//H son los humanos
                }
            }
        }
        return tablero;
    }

    public static boolean backtraking(char[][] tablero) {

        int fila = 0;
        int columna = 0;
        int N = 0;
        int[] movF = {0, -1, 0, 1};
        int[] movC = {-1, 0, 1, 0};
        int bombas = 0;
        return Recbacktracking(tablero, fila, columna, movF, movC, N, bombas);
    }

    private static boolean Recbacktracking(char[][] tablero, int fila, int columna, int[] movF, int[] movC, int n, int b) {

        if (testBomba(fila, columna, tablero)) {
            if (b < 4 && tablero[fila][columna] != 1) {
                tablero[fila][columna] = 'B';//B Casilla donde se coloco una bomba
            }

            if (b < 4) { // con este if revisamos si no hemos usado todas las bombas
                tablero = rellenar(tablero, fila, columna, b);
                return Recbacktracking(tablero, fila, columna, movF, movC, n, b + 1);
            } else if (comprobarZombies(tablero)) {// revisa si hay zombies en el movimiento
                return true;
            } else {
                System.out.println("Aun no se completa la solucion");
                return false;
            }
        } else if (columna < 5) {

            return Recbacktracking(tablero, fila, columna + 1, movF, movC, n, b);
        } else if (fila < 5) {
            return Recbacktracking(tablero, fila + 1, 0, movF, movC, n, b);
        } else {

            return false;
        }
    }

    public static boolean inTablero(int fila, int col) {
        if (fila < 0 || fila > 4) {
            return false;
        }
        if (col > 4 || col < 0) {
            return false;
        }
        return true;
    }

    public static boolean testBomba(int fila, int col, char[][] tablero) {

        if (!inTablero(fila, col)) {
            return false;
        }
        if (tablero[fila][col] == 'H') {//revisa si en aquella posicion [fila][col] haya algun zombie o humano
            return false;
        }
        if (tablero[fila][col] == 'Z') {
            return false;
        }

        if (tablero[fila][col] == 'B') {
            return false;
        }

        for (int i = 0; i < 5; i++) {//revisa si hay algun humano en la fila
            if (tablero[i][col] == 'H') {
                return false;
            }
        }

        for (int i = 0; i < 5; i++) {//revisa si hay algun humano en la columna
            if (tablero[fila][i] == 'H') {
                return false;
            }
        }

        return true;
    }

    public static boolean comprobarZombies(char[][] tablero) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tablero[i][j] == 'Z') {
                    return false;
                }
            }
        }

        return true;
    }

    public static char[][] rellenar(char[][] tablero, int fila, int col, int b) {

        for (int i = 0; i < 5; i++) {

            if (tablero[i][col] == 'B') {
                tablero[i][col] = 'B';
            } else {
                tablero[i][col] = 'R';
            }
        }
        System.out.println("Bomba: " + (b + 1));
        for (int i = 0; i < 5; i++) {

            if (tablero[fila][i] == 'B') {
                tablero[fila][i] = 'B';
            } else {
                tablero[fila][i] = 'R';
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        return tablero;
        
    }

}
