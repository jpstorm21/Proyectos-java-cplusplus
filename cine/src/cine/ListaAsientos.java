/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

/**
 *
 * @author ASUS
 */
public class ListaAsientos {
    private int cant;
    private int max;
    private Asientos [] la;

    public ListaAsientos(int max) {
        this.cant = 0;
        this.max = max;
        la = new Asientos[1000];
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Asientos[] getLa() {
        return la;
    }

    public void setLa(Asientos[] la) {
        this.la = la;
    }
    
    
}
