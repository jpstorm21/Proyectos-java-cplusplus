/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Usuario
 */
public class back_soduko {

    private static final int size = 9;
    private int[][] tablero;

    public back_soduko() {
        this.tablero = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tablero[i][j] = 0;
            }
        }
    }

    public boolean isAceptable(int fila, int columna, int valor) {
        boolean respuesta = true;
        if (this.tablero[fila][columna] != 0) {
            respuesta = false;
        }        
        for(int i=0; i<9;i++){
            if(this.tablero[fila][i] == valor){
                respuesta =false;
            }
            if(this.tablero[i][columna] == valor){
                respuesta = false;
            }
        }
        int cuadrX = 3*(fila/3);
        int cuadrY = 3*(columna/3);
        for(int i = 0; i< cuadrX+3;i++){
            for(int j = 0;j<cuadrY+3;j++){
                if(this.tablero[i][j] == valor){
                    respuesta= false;
                }
            }
        }
        return respuesta;
    }
}
