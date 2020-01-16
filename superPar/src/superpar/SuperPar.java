package superpar;

import java.io.IOException;
import java.util.Scanner;
import ucn.*;

public class SuperPar {

    public static void LecturaArchivo(ArchivoEntrada arch, int[] proyectos, String[] empleados,
            int[][] porcentaje) throws IOException {
        int i = 0;
        int j = 0;
        while (!arch.isEndFile()) {
            Registro reg = arch.getRegistro();
            int proyecto = reg.getInt();
            String nombre = reg.getString();
            int porcent = reg.getInt();

            while (j < 50 && proyectos[j] != 51 && proyectos[j] != proyecto) {
                j += 1;
            }
            if (proyectos[j] == 51) {
                proyectos[j] = proyecto;
            }

            while (i < 200 && empleados[i] != null && !empleados[i].equals(nombre)) {
                i += 1;
            }
            if (empleados[i] == null) {
                empleados[i] = nombre;
            }
            for (int x = 0; x < 50; x++) {
                for (int y = 0; y < 200; y++) {
                    if (proyectos[x] == proyecto) {
                        if (nombre.equals(empleados[y])) {
                            porcentaje[x][y] = porcent;
                        }
                    }
                }
            }
        }
        arch.close();
    }

    public static void SumaPorcentaje(int[][] matriz, int[] arreglo, int cantidad) {
        for (int c = 0; c < cantidad; c++) {
            int suma = 0;
            for (int f = 0; f < 50; f++) {
                suma += matriz[f][c];
            }
            arreglo[c] = suma;
        }
    }

    public static void BuscarMayor(int[] arreglo, String[] arreglo2, int cantidad) {
        int i;
        String emMayor = "";
        int mayor = -9999;
        for (i = 0; i < cantidad; i++) {
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
                emMayor = arreglo2[i];
            }
        }
        StdOut.println("Empleado más ocupado: " + emMayor + " ---> " + mayor + "%");
    }

    public static void main(String[] args) throws IOException {
        ArchivoEntrada arch1 = new ArchivoEntrada("proyectos.txt");
        int[] proyectos = new int[50];
        String[] empleados = new String[200];
        int[][] dedicacion = new int[50][200];
        int[] contador = new int[50];
        int[] porcentajeT = new int[200];

        for (int fila = 0; fila < 50; fila++) {
            proyectos[fila] = 51;
            contador[fila] = 0;
        }

        for (int fila = 0; fila < 50; fila++) {
            for (int col = 0; col < 200; col++) {
                dedicacion[fila][col] = 0;
            }
        }
        LecturaArchivo(arch1, proyectos, empleados, dedicacion);

        StdOut.println("Ingrese empleado para saber sus dedicaciones: ");
        String nombreI = StdIn.readString();
        int i;
        for (i = 0; i < 200; i++) {
            if (nombreI.equals(empleados[i])) {
                break;
            }
        }
        for (int fila = 0; fila < 50; fila++) {
            if (dedicacion[fila][i] != 0) {
                StdOut.println("Proyecto: " + proyectos[fila] + ": " + dedicacion[fila][i] + "%");
            }
        }
        SumaPorcentaje(dedicacion, porcentajeT, 200);
        BuscarMayor(porcentajeT, empleados, 200);
        int contaux = 0;
        for (int j = 0; j < 50; j++) {
            if (proyectos[j] != 51) {
                contaux += 1;

            }
        }
        StdOut.println("La cantidad de proyectos es de: " + contaux);
        int contEm = 0;

        for (int j = 0; j < 200; j++) {
            if (empleados[j] != null) {
                contEm += 1;

            }
        }

        StdOut.println("La cantidad de integrantes son: " + contEm);
        for (int fila = 0; fila < 50; fila++) {

            for (int col = 0; col < 200; col++) {
                if (dedicacion[fila][col] != 0) {
                    contador[fila] += 1;
                }
            }
        }
        int varSuma = 0;

        for (int j = 0; j < 50; j++) {
            if (contador[j] != 0) {
                varSuma += contador[j];
            }

        }

        StdOut.println("El promedio de integrantes por proyecto es: " + (varSuma / contaux));
        int cont1015 = 0;
        for (int j = 0; j < 50; j++) {
            if (contador[j] >= 10 && contador[j] <= 15) {
                cont1015 += 1;
            }
        }
        StdOut.println("El porcentaje de proyectos que tienen entre 10 y 15 integrantes es: " + (cont1015 * 100 / contaux) + "%");
    }
}
