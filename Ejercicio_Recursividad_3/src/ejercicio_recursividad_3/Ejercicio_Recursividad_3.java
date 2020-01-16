package ejercicio_recursividad_3;

import ucn.*;

/**
 *
 * @author Cristóbal
 */
public class Ejercicio_Recursividad_3 {

    //EJERCICIOS - Buscar un elemento de un array de forma recursiva.
    public static int buscar_Elemento(int[] array, int elemento, int indice) {       
        if (indice == array.length || array[indice] == elemento) {
            if (indice == array.length) {
                return -1;
            } else {
                return indice;
            }
        } else {
            return buscar_Elemento(array, elemento, indice + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Ingrese el elemento a buscar: ");
        int elemento = StdIn.readInt();
        int posicionElemento = buscar_Elemento(array, elemento, 0);
        if (posicionElemento == -1) {
            System.out.println("elemento no encontrado");
        } else {
            System.out.println("El elemento a buscar se encuentra en la posición: " + posicionElemento);
        }
    }

}
