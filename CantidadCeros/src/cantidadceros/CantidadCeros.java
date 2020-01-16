package cantidadceros;

import java.util.Scanner;

public class CantidadCeros {

    public static int obtenerCantidadCeros(int cant, int[] vector) {
        int contador = 0;
        return resolver(0, cant, vector, contador);
    }

    private static int resolver(int inicio, int fin, int[] vector, int contador) {
        if (inicio == fin) {//un solo elemento
            if (vector[inicio] == 0) {
                contador++;
            }
            return contador;
        } else {
            if (inicio == fin - 1) {//dos elementos
                if (vector[inicio] == 0) {
                    contador++;
                }
                if (vector[fin] == 0) {
                    contador++;
                }
                return contador;
            } else {
                int mitad = (inicio + fin) / 2;
                int ceros1 = resolver(inicio, mitad, vector, contador);
                int ceros2 = resolver(mitad + 1, fin, vector, contador);
                contador = ceros1 + ceros2;
                return contador;
            }

        }
    }

    public static void main(String[] args) {
        int[] vector = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int cantCeros = obtenerCantidadCeros(vector.length - 1, vector);
        System.out.println("la cantidad de ceros es: " + cantCeros);
    }
}
