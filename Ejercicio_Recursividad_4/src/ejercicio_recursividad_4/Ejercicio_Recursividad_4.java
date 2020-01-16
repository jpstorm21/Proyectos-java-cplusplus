package ejercicio_recursividad_4;

/**
 *
 * @author Cristóbal
 */
public class Ejercicio_Recursividad_4 {

    //EJERCICIO 4 - Recorrer una matriz de forma recursiva.
    public static void recorrer_Matriz_Recursiva(int[][] matriz, int fila, int columna) {

        System.out.print(matriz[fila][columna] + " ");
        if (fila != matriz.length - 1 || columna != matriz[fila].length - 1) {
            if (columna == matriz[fila].length - 1) {
                fila++;
                columna = 0;
                System.out.println(" ");
            } else {
                columna++;
            }
            recorrer_Matriz_Recursiva(matriz, fila, columna);
        }

    }

    public static void main(String[] args) {
        int[][] matriz = 
        {{1, 2, 3},
        {3, 4, 5},
        {6, 7, 8}
        };
        recorrer_Matriz_Recursiva(matriz, 0, 0);
    }

}
