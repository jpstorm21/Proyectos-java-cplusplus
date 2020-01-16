/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

public class ListaCreditos {

    private int max;
    private int cantCred;
    private Creditos[] LCred;

    public ListaCreditos(int max) {
        this.max = max;
        cantCred = 0;
        LCred = new Creditos[max];

    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantCred() {
        return cantCred;
    }

    public void setCantCred(int cantCred) {
        this.cantCred = cantCred;
    }

    public Creditos getLCred(int i) {
        return LCred[i];
    }

    public void setLCred(Creditos[] LCred) {
        this.LCred = LCred;
    }

    public boolean IngresarCredito(Credito C) {
        if (cantCred >= max) {
            return false;

        } else {
            LCred[cantCred] = C;
            cantCred++;
            return true;
        }
    }

    public Credito BuscarCreditoXCodigo(int codigoCred) {
        int i;
        for (i = 0; i < cantCred; i++) {
            if (LCred[i].getCodigo() == codigoCred) {
                break;
            }
        }
        if (i == cantCred) {
            return null;

        } else {
            return LCred[i];
        }
    }

    public boolean EliminarCredito(Credito C) {
        int i;
        for (i = 0; i < cantCred; i++) {
            if (LCred[i] == C) {
                break;
            }
        }
        if (i == cantCred) {
            return false;

        } else {
            int j;
            for (j = 0; j < cantCred; j++) {
                LCred[j] = LCred[j + 1];
            }
            cantCred--;
            return true;
        }
    }

}
