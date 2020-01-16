
package taller5_sgdo_part2;

public class Backtraking {
    private static final char PARED = 'X';
    private static final char LIBRE = ' ';
    private static final char VISITADO = 'V';
    private static final char META = 'M';
    private static final char INICIO = 'I';
    private char [][] tablero;
    private int filas; // tamaño
    private int columnas; // tamaño
    private int filaMeta;
    private int filaInicio;
    private int colMeta;
    private int colInicio;
    private int[] movFila = {-1, 0, 1, 0};
    private int[] movColumna = {0, 1, 0, -1};

    public Backtraking(int filas, int columnas, int filaMeta, int colMeta, int filaInicio, int colInicio) {
        this.tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = LIBRE;
            }
        }
        this.filas = filas;
        this.columnas = columnas;
        this.filaInicio = filaInicio;
        this.filaMeta = filaMeta;
        this.colInicio = colInicio;
        this.colMeta = colMeta;
        tablero[filaInicio][colInicio] = INICIO;
        tablero[filaMeta][colMeta] = META;
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
        // TODO: Validacion de 
        this.tablero[fil][col] = VISITADO;
    }

    public void addMeta(int fil, int col) {
        this.tablero[fil][col] = META;
    }

    public void addInicio(int fil, int col) {
        this.tablero[fil][col] = INICIO;
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

    public int SolucionBacktraking() {
        return SolucionBacktrakingRecursivo(this.filaInicio, this.colInicio);
    }

    private int SolucionBacktrakingRecursivo(int fila, int columna) {
        System.out.println("------------------------------------------------");
        System.out.println("Fila: " + fila + "  Col: " + columna + " //Empiezo en esta posicion ");
        System.out.println();
        this.imprimirTablero();

        if (fila == this.filaMeta && columna == this.colMeta) {

            System.out.println("------------------------------------------------");
            System.out.println("RESUELTO!");
            System.out.println("------------------------------------------------");
            return 1;
        }

        for (int k = 0; k < 4; k++) {
            int ff = fila + this.movFila[k];
            int fc = columna + this.movColumna[k];
            if (this.isAceptable(ff, fc)) {
                System.out.println("ff:" + ff + " fc:" + fc + " Aceptada");
                if (this.tablero[ff][fc] != META && this.tablero[ff][fc] != INICIO) {
                    this.tablero[ff][fc] = VISITADO;
                }
                int res = this.SolucionBacktrakingRecursivo(ff, fc);
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
