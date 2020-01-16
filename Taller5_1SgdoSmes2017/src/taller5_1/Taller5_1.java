package taller5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ucn.*;

/**
 *
 * @author Juan Pablo Martinez Romero
 */
public class Taller5_1 {

    public static void leer(Out salida, Out salida2) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("escaneo.txt"));
        while (sc.hasNext()) {
            String linea = sc.nextLine();
            char[] vector = linea.toCharArray();
            int cantAbiertos = 0;
            int cantCerrados = 0;
            int [] resultados = Funcion(cantAbiertos, cantCerrados, vector);//posicion [0] = 1 si escaneo correcto, 0 escaneo incorrecto, posicion [1] = mayor nivel, posicion [2] = prioridad
            if (resultados[0] == 1) {
                salida2.println(linea + ";" + resultados[1] + ";" + resultados[2]);
            } else {
                if (cantAbiertos > cantCerrados) {
                    salida.println(linea + " faltaron parentesis que cerrar");
                } else {
                    salida.println(linea + " faltaron parentesis que abrir");
                }
            }
        }
        sc.close();
    }

    public static int[] Funcion(int cantAbiertos, int cantCerrados, char[] vector) {
        int pos = 0;
        int mayor = 0;
        int prioridad = 0;
        int niveles = 0;
        int [] resultados = new int[3];
        return RFuncion(cantAbiertos, cantCerrados, vector, pos, niveles, mayor, prioridad, resultados);
    }

    private static int [] RFuncion(int cantAbiertos, int cantCerrados, char[] vector, int pos, int niveles, int mayor, int prioridad, int[] resultados) {
        if (pos > vector.length - 1) {
            if (cantAbiertos == cantCerrados) {
                resultados[0] = 1;
                resultados[1] = mayor;
                resultados[2] = prioridad;
                return resultados;
            } else {
                resultados[0] = 0;
                return resultados;
            }
        } else {
            if (vector[pos] == '(') {
                cantAbiertos++;
                niveles++;
                if (niveles > mayor) {
                    mayor = niveles;
                }
                pos++;
                return RFuncion(cantAbiertos, cantCerrados, vector, pos, niveles, mayor, prioridad, resultados);
            } else if (vector[pos] == ')') {
                cantCerrados++;
                niveles--;
                pos++;
                return RFuncion(cantAbiertos, cantCerrados, vector, pos, niveles, mayor, prioridad, resultados);
            } else if (vector[pos] == 'x') {
                prioridad = prioridad + niveles * 1;
                pos++;
                return RFuncion(cantAbiertos, cantCerrados, vector, pos, niveles, mayor, prioridad, resultados);
            } else {
                pos++;
                return RFuncion(cantAbiertos, cantCerrados, vector, pos, niveles, mayor, prioridad, resultados);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Out salida = new Out("errores_escaneo.txt");
        Out salida2 = new Out("salares_validos.txt");
        leer(salida, salida2);
        System.out.println("Se han generado los archivos exitosamente");
    }
}
