package ejercicios;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ejercicios {

    public static void ejercicio4() {
        int divisor = 2;

        System.out.print("Ingrese un número entero(FIN DE DATOS -1): ");
        int entero = StdIn.readInt();
        while (entero != -1) {
            for (int i = 0; i <= entero; i++) {
                if (entero % divisor == 0) {
                    System.out.println("Los factores primos son: " + divisor);
                    entero = entero / divisor;
                } else {
                    divisor++;
                }
            }
            divisor = 2;
            System.out.print("Ingrese un número entero(FIN DE DATOS -1): ");
            entero = StdIn.readInt();
        }

    }

    public static void main(String[] args) {
        ejercicio4();
    }

}
