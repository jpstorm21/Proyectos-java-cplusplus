package chulopracticandorecu;

import java.util.Scanner;

public class ChuloPracticandoRecu {

    public static double serieArmonica(double n) {
        return serieRecursivo(n);
    }

    private static double serieRecursivo(double n) {
        if (n == 1) {
            return 1;
        } else {
            return (1 / n) + serieRecursivo(n - 1);
        }

    }

    public static int obtener_mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return obtener_mcd(b, a % b);
        }
    }

    public static int busquedaBinaria(int[] a, int d) {//revisar 
        return busquedaRecu(a, d, 0, a.length - 1);
    }

    private static int busquedaRecu(int[] a, int d, int posi, int posf) {
        int mitad = (posi + posf) / 2;
        if (a[mitad] == d) {//si esta en el medio
            return mitad;
        } else {
            if (posi > posf) {
                return -1;
            } else {
                if (a[mitad] < d) {
                    return busquedaRecu(a, d, mitad +1, posf);//mitad superior
                } else {
                    return busquedaRecu(a, d, posi, mitad);//mitad inferior
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese valor para n :");
        int n = sc.nextInt();
        double sa = serieArmonica(n);
        System.out.println(sa);

        System.out.println("Ingrese valor para A :");
        int a = sc.nextInt();
        System.out.println("Ingrese valor para b :");
        int b = sc.nextInt();
        int mcd = obtener_mcd(a, b);
        System.out.println(mcd);

        System.out.println("tamaño del arreglo");
        int valor = sc.nextInt();
        int[] arre = new int[valor];
        for (int i = 0; i < valor; i++) {
            System.out.println("ingrese valores de manera ordenada");
            int v = sc.nextInt();
            arre[i] = v;
        }
        System.out.println("valor a  buscar");
        int vl = sc.nextInt();
        int pos = busquedaBinaria(arre, vl);
        System.out.println(vl);
    }
}
