package ejercicio_recursividad_1;

/**
 *
 * @author Cristóbal
 */
public class Ejercicio_Recursividad_1 {

    //EJERCICIO 1 - Recorrer un array de forma recursiva.
    public static void recorrer_Array_Recursivo(int [] array, int indice){
        if(indice != array.length){
            System.out.print(array[indice]);
            System.out.print(" ");
            recorrer_Array_Recursivo(array, indice + 1);
        }  
    }
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        recorrer_Array_Recursivo(array, 0);
    }
    
}
