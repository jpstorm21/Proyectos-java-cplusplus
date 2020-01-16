/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;

/**
 *
 * @author maick
 */
public class Taller5 {

    public static char[][] crearMatriz() {
        char[][] matriz = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int porcentaje = (int) (Math.random() * 100 + 1);
                if (porcentaje > 90) {
                    matriz[i][j] = 'o';
                } else {
                    matriz[i][j] = 'l';
                }
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String titulo = "Taller 5";
        int ancho = 600;
        int alto = 550;
        int matrizSize = 5; //cantidad de celdas
        OrdenaCajas oc= new OrdenaCajas (titulo, ancho, alto);
    }

}
