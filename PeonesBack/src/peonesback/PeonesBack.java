/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonesback;

import ucn.StdIn;
import ucn.StdOut;

/**
 *
 * @author Juan Pablo Martinez
 */
public class PeonesBack {

    private static int[][] tablero;
    private static int n;
    private static int posX;
    private static int posY;
    private static int peonesPendientes;
    private static int peonesNegros;
    private static int[] dX = {1, 0, -1, 0};
    private static int[] dY = {0, 1, 0, -1};
    private static int m;

    public static boolean aceptable(int v) {
        boolean resp = false;
        if (1 <= posX && posX <= n && 1 <= posY && posY <= n) {
            if (tablero[posX][posY] == 0) {
                resp = true;
            }
            /* No es necesario porque resp es falso por defecto
			if(tablero[posX][posY] == 1)
				resp = false;
             */
            if (1 <= posX + dX[v] && posX + dX[v] <= n && 1 <= posY + dY[v] && posY + dY[v] <= n && tablero[posX + dX[v]][posY + dY[v]] == 0) {
                if (tablero[posX][posY] == 2) {
                    peonesPendientes--;
                    tablero[posX][posY] = 3;
                    posX += dX[v];
                    posY += dY[v];
                    resp = true;
                }
            }
        }
        return resp;
    }

    public static boolean peones(int xIni, int yIni, int etapa, int peonesPendientesIni) {
        boolean resp = false;
        if (etapa < m) {
            for (int v = 1; v <= 4; v++) {
                posX = xIni + dX[v];
                posY = yIni + dY[v];
                peonesPendientes = peonesPendientesIni;
                if (aceptable(v)) {
                    if (peonesPendientes == 0) {
                        resp = true;
                    } else {
                        if (peones(posX, posY, etapa++, peonesPendientes)) {
                            resp = true;
                        } else {
                            if (peonesPendientes != peonesPendientesIni) {
                                tablero[xIni + dX[v]][yIni + dY[v]] = 2;
                            }
                        }
                    }
                }
            }
        }
        return resp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        StdOut.print("Ingres el tamaño del tablero (n): ");
        n = StdIn.readInt();
        StdOut.print("Ingrese la posición inicial (x): ");
        posX = StdIn.readInt();
        StdOut.print("Ingrese la posición inicial (y): ");
        posY = StdIn.readInt();
        StdOut.print("Ingrese la cantidad de peones blancos: ");
        peonesPendientes = StdIn.readInt();
        peonesNegros = peonesPendientes / 3;

        if (peones(posX, posY, 1, peonesPendientes)) {
            StdOut.println("Solucionado!!!");
        } else {
            StdOut.println("Sin Solución!!!");
        }

    }

}
