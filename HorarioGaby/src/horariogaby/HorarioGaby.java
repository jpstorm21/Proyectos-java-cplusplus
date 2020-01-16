package horariogaby;

import ucn.*;

public class HorarioGaby {

    public static void main(String[] args) {
        In txt = new In("gaby.txt");
        String[] fechas = new String[100];
        String[] actividades = new String[100];
        int[][] tiempo = new int[100][100];
        int cantFechas = 0;
        int cantActividades = 0;
        while (!txt.isEmpty()) {
            String fecha = txt.readString();
            String actividad = txt.readString();
            int minuto = txt.readInt();
            int posFecha = 0;
            boolean estaba = false;                       //cambiara a true si la fecha ya existia antes para no volverla ingresar
            for (int i = 0; i < cantFechas; i++) {
                if (fecha.equals(fechas[i])) {
                    posFecha = i;
                    estaba = true;
                    break;
                }
            }
            if (estaba == false) {
                posFecha = cantFechas;
                fechas[cantFechas] = fecha;
                cantFechas++;
            }
            int posActi = 0;
            boolean estabaActi = false;                  //cambiara a true si la actividad ya existia antes para no volverla ingresar
            for (int i = 0; i < cantActividades; i++) {
                if (actividad.equals(actividades[i])) {
                    posActi = i;
                    estabaActi = true;
                    break;
                }
            }
            if (estabaActi == false) {
                posActi = cantActividades;
                actividades[cantActividades] = actividad;
                cantActividades++;
            }
            tiempo[posFecha][posActi] = tiempo[posFecha][posActi] + minuto;
        }

        for (int i = 0; i < cantFechas - 1; i++) {
            for (int j = i + 1; j < cantFechas; j++) {
                if (fechas[i].compareTo(fechas[j]) > 0) {
                    String aux = fechas[i];
                    fechas[i] = fechas[j];
                    fechas[j] = aux;
                    for (int w = 0; w < cantActividades; w++) {
                        int aux2 = tiempo[i][w];
                        tiempo[i][w] = tiempo[j][w];
                        tiempo[j][w] = aux2;
                    }
                }
            }
        }
        for (int i = 0; i < cantFechas; i++) {
            StdOut.println(fechas[i]);
            int mayor = -1;
            int menor = 9999;
            int minTotal = 0;
            for (int j = 0; j < cantActividades; j++) {
                if (tiempo[i][j] > mayor) {
                    mayor = tiempo[i][j];
                }
                if (tiempo[i][j] > 0) {
                    if (tiempo[i][j] < menor) {
                        menor = tiempo[i][j];
                    }
                }
                minTotal = minTotal + tiempo[i][j];
            }
            StdOut.println("mayor tiempo");
            for (int w = 0; w < cantActividades; w++) {
                if (tiempo[i][w] == mayor) {
                    StdOut.println("      " + actividades[w] + "(" + tiempo[i][w] + ")");
                }
            }
            StdOut.println("menor tiempo");
            for (int w = 0; w < cantActividades; w++) {
                if (tiempo[i][w] == menor) {
                    StdOut.println("      " + actividades[w] + "(" + tiempo[i][w] + ")");
                }
            }
            int porcentaje = 100 * minTotal / (60 * 16);
            StdOut.println("total de minutos es: " + minTotal + " (" + porcentaje + "%)");
            StdOut.println("--------------------------------------------------------------------");
        }
    }
}
