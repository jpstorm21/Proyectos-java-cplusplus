/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dividirparaconquistarpruebe3;

/**
 *
 * @author Juan pablo
 */
import java.util.Scanner;

public class DividirParaConquistarPruebe3 {

    public static int[] estaOrdenado(int[] arreglo) {
        // true(menor a mayor) / false(mayor a menor)
        int tamaño = arreglo.length - 1;
        int[] solucion = new int[1];// 1 menor mayor || 2  mayor a menor || 3  desordenado
        return estaOrdenado(arreglo, 0, tamaño, solucion);
    }

    private static int[] estaOrdenado(int[] arreglo, int posInicial, int posFinal, int[] solucion) {
        if (posInicial == posFinal) {//vector de una posicion
            int[] solucion1 = new int[1];
            solucion1[0] = 1;
            return solucion1;
        } else if (posInicial == posFinal - 1) {//vector de dos posiciones
            int[] solucion2 = new int[1];
            if (arreglo[posInicial] > arreglo[posFinal]) {
                solucion2[0] = 2;
                return solucion2;
            } else {
                solucion2[0] = 1;
                return solucion2;
            }
        } else if (posInicial == posFinal - 2) { //vector 3 posiciones
            int[] solucion3 = new int[1];
            if (arreglo[posInicial] > arreglo[posFinal - 1]) {
                solucion3[0] = 2;
                if (arreglo[posFinal - 1] > arreglo[posFinal]) {
                    solucion3[0] = 2;
                    return solucion3;
                }
            } else if (arreglo[posInicial] < arreglo[posFinal - 1]) {
                solucion3[0] = 1;
                if (arreglo[posFinal - 1] < arreglo[posFinal]) {
                    solucion3[0] = 1;
                    return solucion3;
                }
            } else {
                solucion3[0] = 3;
                return solucion3;
            }
        } else {
            int mitad = (posInicial + posFinal) / 2;
            int[] r1 = estaOrdenado(arreglo, posInicial, mitad, solucion);
            int[] r2 = estaOrdenado(arreglo, mitad + 1, posFinal, solucion);
            if (r1[0] == r2[0]) {
                if (r1[0] == 1) {
                    solucion[0] = 1;
                    return r1;
                } else  {
                    solucion[0] = 2;
                }
            } else {
                solucion[0] = 3;
                return solucion;
            }
        }
        return solucion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese cantidad de numeros a digitar(-1 para terminar): ");
        int cant = sc.nextInt();
        while (cant >= 0) {
            int[] arreglo = new int[cant];
            for (int i = 0; i < cant; i++) {
                System.out.print("ingrese numero " + (i + 1) + " : ");
                int n = sc.nextInt();
                arreglo[i] = n;
            }
            int[] respuesta = estaOrdenado(arreglo);
            if (respuesta[0] == 1) {
                System.out.println("ordenado de menor A mayor");
            } else if (respuesta[0] == 2) {
                System.out.println("ordenado de mayor a menor");
            } else {
                System.out.println("desornado");
            }
            System.out.print("ingrese cantidad de numeros a digitar(-1 para terminar): ");
            cant = sc.nextInt();
        }
    }
}
