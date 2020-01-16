/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteligenciaartificial;

public class Agente {

    private int posicionX;
    private int posicionY;
    private int[][] tablero;

    public Agente(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public boolean posSirveCol(int x, int y) {
        boolean sirve1 = true;
        boolean sirve2 = true;
        if ((y + 1) > 9 || (y + 1) < 0) {
            sirve1 = false;
        }
        if ((y - 1) > 9 || (y - 1) < 0) {
            sirve2 = false;
        }
        return sirve1 && sirve2;
    }

    public boolean posSirveFil(int x, int y) {
        boolean sirve1 = true;
        boolean sirve2 = true;
        if ((x + 1) > 9 || (x + 1) < 0) {
            sirve1 = false;
        }
        if ((x - 1) > 9 || (x - 1) < 0) {
            sirve2 = false;
        }
        return sirve1 && sirve2;
    }

    public int[] determinarPos() {
        int[] movimientos = new int[2];
        if (posSirveFil(this.posicionX, this.posicionY)) {
            if ((this.tablero[this.posicionX + 1][this.posicionY]) == 1) {
                this.posicionX = this.posicionX + 1;
            } else if ((this.tablero[this.posicionX - 1][this.posicionY]) == 1) {
                this.posicionX = this.posicionX - 1;
            } else if ((this.tablero[this.posicionX + 1][this.posicionY]) == 0) {
                this.posicionX = this.posicionX + 1;
            } else if ((this.tablero[this.posicionX - 1][this.posicionY]) == 0) {
                this.posicionX = this.posicionX - 1;
            }
        }
        if (posSirveCol(this.posicionX, this.posicionY)) {
            if (((this.tablero[this.posicionX][this.posicionY + 1])) == 1) {
                this.posicionY = this.posicionY + 1;
            } else if (((this.tablero[this.posicionX][this.posicionY - 1])) == 1) {
                this.posicionY = this.posicionY - 1;
            } else if (((this.tablero[this.posicionX][this.posicionY + 1])) == 0) {
                this.posicionY = this.posicionY + 1;
            } else if (((this.tablero[this.posicionX][this.posicionY - 1])) == 0) {
                this.posicionY = this.posicionY - 1;
            }
        }
        movimientos[0] = this.posicionX;
        movimientos[1] = this.posicionY;

        return movimientos;
    }

}
