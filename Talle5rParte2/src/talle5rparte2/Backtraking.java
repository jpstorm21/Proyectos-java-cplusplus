package talle5rparte2;

public class Backtraking {

    private static final char zombi = 1;
    private static final char humanos = 0;
    private static final char bomba = 'v';
    private static final char libre = ' ';
    private char [][] tablero;
    private int filas;
    private int columnas;
    private int fila_final;
    private int columna_final;
    private int fila_inicial;
    private int columna_inicial;
    private int[] movFila = {-1, 0, 1, 0};
    private int[] movColumna = {0, 1, 0, -1};

    public Backtraking(int filas, int columnas, int fila_final, int columna_final, int fila_inicial, int columna_inicial) {
        this.tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.tablero[i][j] = libre;
            }
        }
        this.filas = filas;
        this.columnas = columnas;
        this.fila_final = fila_final;
        this.columna_final = columna_final;
        this.fila_inicial = fila_inicial;
        this.columna_inicial = columna_inicial;
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
    public boolean isAceptable(int fil, int col) {
            
		if (fil < 0 || fil >= this.filas) return false;
		if (col < 0 || col >= this.columnas) return false;
		if (this.tablero[fil][col] == humanos) return false;
                for (int k=0; k<5; k++) {
                if (this.tablero[fil][col] == bomba) 
                    return false;
            }
                return true;
                
	}
    
    

}
