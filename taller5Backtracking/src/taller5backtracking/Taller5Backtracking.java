/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5backtracking;

/**
 *
 * @author DOMINGOANTONIO
 */
public class Taller5Backtracking {

    /**
     * @param args the command line arguments
     */
    public static int[][] rellenarMatriz(int[][] matriz) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = 0;// 0 son las posibles posibilidades de colocar la bomba

                if (Math.random() < 0.2) {// 1 representa los zombis 
                    matriz[i][j] = 1;
                }
                if (Math.random() < 0.05) { //2 representa los sobrevivientes
                    matriz[i][j] = 2;
                }
            }
        }
        return matriz;
    }

    public static boolean back(int[][] matriz) {

        int fila = 0;
        int col = 0;
        int n = 0;
        int[] movF = {0, -1, 0, 1};
        int[] movC = {-1, 0, 1, 0};
        int bombas = 0;
        return backtracking(matriz, fila, col, movF, movC, n, bombas);
    }

    private static boolean backtracking(int[][] m, int f, int c, int[] movF, int[] movC, int n, int b) {

        if (puedo(f, c, m)) {
            if (b < 4 && m[f][c] != 1) {
                m[f][c] = 8;// 8 va a ser el numero que marca el visitado
            }

            if (b < 4) { // comprueba que aun no se han utilizado todas las bombas
                m = rellenarFilaCol(m, f, c, b);
                return backtracking(m, f, c, movF, movC, n, b + 1);
            } else if (comprobar(m)) {// comprueba si hay un zombie
                return true;
            } else {
                System.out.println("Solucion incompleta");
                return false;
            }
        } else if (c < 5) {

            return backtracking(m, f, c + 1, movF, movC, n, b);
        } else if (f < 5) {
            return backtracking(m, f + 1, 0, movF, movC, n, b);
        } else {

            return false;
        }
    }

    public static boolean dentro(int fila, int col) {
        if (fila < 0 || fila > 4) {
            return false;
        }
        if (col > 4 || col < 0) {
            return false;
        }
        return true;
    }

    public static boolean puedo(int fila, int col, int[][] matriz) {

        if (!dentro(fila, col)) {
            return false;
        }
        if (matriz[fila][col] == 2 ) {//comprueba si hay un sobreviviente o zombie en la posicion
            return false;
        }
        if(matriz[fila][col] == 1){
            return false;
        }

        if (matriz[fila][col] == 8) {
            return false;
        }

        for (int i = 0; i < 5; i++) {//comprueba si hay un sobreviviente en la fila
            if (matriz[i][col] == 2) {
                return false;
            }
        }

        for (int i = 0; i < 5; i++) {//comprueba si hay un sobreviviente en la columna
            if (matriz[fila][i] == 2) {
                return false;
            }
        }

        return true;
    }

    public static boolean comprobar(int[][] matriz) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] rellenarFilaCol(int[][] matriz, int fila, int col, int b) {

        for (int i = 0; i < 5; i++) {
            
                if (matriz[i][col] == 8) {
                    matriz[i][col] = 8;
                } else {
                    matriz[i][col] = 7;
                }
        }
        System.out.println("Bomba: "+(b+1));
        for (int i = 0; i < 5; i++) {
 
                if (matriz[fila][i] == 8) {
                    matriz[fila][i] = 8;
                } else {
                    matriz[fila][i] = 7;
                }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        return matriz;
    }

    public static void main(String[] args) {
        // TODO code application logic he
        int[][] matriz = new int[5][5];
        matriz = rellenarMatriz(matriz);
        System.out.println("Tablero inicial: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println("8 repesenta la bomba colocada ");
        System.out.println("7 la linea de alcance de la explosion ");
        System.out.println("2 representa un sobreviviente ");
        System.out.println("1 representa un zombie ");
        System.out.println("0 representa las casillas desocupadas ");
        System.out.println("------------------------------- ");
        System.out.println(" ");
        
        
        if (back(matriz)) {
            System.out.println("Solucion");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("No solucion");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ");
            }
        }

        new Ventana();

    }

}
