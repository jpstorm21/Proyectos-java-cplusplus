/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nreinas;

/**
 *
 * @author Usuario
 */
public class NReinas {

    /*en este arreglo almacenaremos la solución. Cada posición del arreglo representa
 /una columna, y el valor en cada posición representará la fila donde es posible
 poner una reina*/
    private static int[] solucion;

    //esta función chequea si es posible poner la reina en la posición x2,y2
    public boolean isAceptable(int x2, int y2) {
        for (int i = 0; i < x2; i++) {
            //si solucion[i]==y2 son la misma columna
            //si (i - x2) es igual a (solucion[i] - y2) en valor absoluto, entonces están en la misma diagonal
            if ((solucion[i] == y2)
                    || (Math.abs(i - x2) == Math.abs(solucion[i] - y2))) {
                return false;
            }
        }
        return true;
    }

    public void resolverReinas(int x) {
        for (int i = 0; i < solucion.length; i++) {
            //chequea si es posible poner en la fila "x" de la columna "i" una reina
            if (isAceptable(x, i)) {
                //si es posible se guarda la posición de la reina en el arreglo
                solucion[x] = i;
                if (x == solucion.length - 1) {
                    desplegar();
                }
                resolverReinas(x + 1);
            }
        }
    }

    public void desplegar() {
        for (int i = 0; i < solucion.length; i++) {
            System.out.print(solucion[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int n = 8;
        solucion = new int[n];
        NReinas i = new NReinas();
        //comenzamos evaluando la posición 0
        i.resolverReinas(0);
    }
}
