/*
 * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class tableroBacktracking {

    private static final char PARED = 'X';
    private static final char LIBRE = ' ';
    private static final char VISITADO = 'V';
    private char[][] tablero;
    private int filas; // tamaño
    private int columnas; // tamaño
    private int filaInicio;
    private int colInicio;
    private int filaFinal;
    private int colFinal;
    private int[] movFila = {-1, 0, 1, 0};
    private int[] movColumna = {0, 1, 0, -1};

    public tableroBacktracking(int filas, int columnas, int filaInicio, int colInicio, int filaFinal, int colFinal) {
        this.tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = LIBRE;
            }
        }

        this.filas = filas;
        this.columnas = columnas;
        this.filaInicio = filaInicio;
        this.colInicio = colInicio;
        this.filaFinal = filaFinal;
        this.colFinal = colFinal;
    }

    public void addPared(int fil, int col) {
        // TODO: Validacion de parametros
        this.tablero[fil][col] = PARED;
    }

    public void addLibre(int fil, int col) {
        // TODO: Validacion de parametros
        this.tablero[fil][col] = LIBRE;
    }

    public void addVisitado(int fil, int col) {
        // TODO: Validacion de parametros
        this.tablero[fil][col] = VISITADO;
    }

    public boolean isAceptable(int fil, int col) {

        if (fil < 0 || fil >= this.filas) {
            return false;
        }
        if (col < 0 || col >= this.columnas) {
            return false;
        }
        if (this.tablero[fil][col] == PARED) {
            return false;
        }
        for (int k = 0; k < 5; k++) {
            if (this.tablero[fil][col] == VISITADO) {
                return false;
            }
        }
        return true;

    }

    public int resolverLaberinto() {
        return this.resolverLaberinto(this.filaInicio, this.colInicio);
    }

    private int resolverLaberinto(int f, int c) {
        System.out.println("------------------------------------------------");
        System.out.println("Fila: " + f + "  Col: " + c + " //Empiezo en esta posicion ");
        System.out.println();
        this.imprimirTablero();

        if (f == this.filaFinal && c == this.colFinal) {

            System.out.println("------------------------------------------------");
            System.out.println("RESUELTO!");
            System.out.println("------------------------------------------------");
            return 1;
        }

        for (int k = 0; k < 4; k++) {
            int ff = f + this.movFila[k];
            int fc = c + this.movColumna[k];
            if (this.isAceptable(ff, fc)) {
                System.out.println("ff:" + ff + " fc:" + fc + " Aceptada");
                this.tablero[ff][fc] = VISITADO;
                int res = this.resolverLaberinto(ff, fc);
                switch (res) {
                    case 0:
                        System.out.println("Fila: " + ff + " Col: " + fc + "// No es solucion, liberando posocion");
                        this.tablero[ff][fc] = LIBRE;
                        break;
                    case -1:
                        System.out.println("Fila: " + ff + " Col: " + fc + "// No es solucion , en esta rama nose puede");
                        this.tablero[ff][fc] = VISITADO;
                        break;
                    default:
                        return 1;
                }
            } else {
                System.out.println("Fila: " + ff + " Col: " + fc + "// No es aceptable esta posicion");
            }
        }
        System.out.println("Se acabaron candidatos");
        return -1;
    }

    public void imprimirTablero() {

        for (int i = 0; i < this.filas; i++) {
            System.out.print("|\t" + i + "");
        }
        System.out.print("|");
        System.out.println();
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (j == 0) {
                    System.out.print("|" + i + "| \t" + tablero[i][j] + "|");
                } else {
                    System.out.print(" \t" + tablero[i][j] + "|");
                }
            }
            System.out.println();
        }
    }
}
