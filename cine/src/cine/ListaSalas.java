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
public class ListaSalas {

    private int cant;
    private int max;
    private sala[] ls;

    public ListaSalas(int max) {
        this.cant = 0;
        this.max = max;
        this.ls = new sala[max];
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

    public sala[] getLs() {
        return ls;
    }

    public void setLs(sala[] ls) {
        this.ls = ls;
    }

    public boolean ingresar(sala s) {
        if (cant >= max) {
            return false;
        } else {
            ls[cant] = s;
            cant++;
            return true;
        }
    }
    public sala buscarSala(int numero){
        int i;
        for(i = 0; i< cant;i++){
            if(ls[i].getNumero() == numero ){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return ls[i];
        }
    }
}
