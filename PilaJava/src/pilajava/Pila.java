/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilajava;

/**
 *
 * @author Usuario
 */
public class Pila {
    private int cantA;
    private int cantB;
    private int [] v;
    private int max;
    public Pila(int max) {
        this.cantA = cantA;
        this.cantB = cantB;
        this.max=max;
        v = new int[max];
    }

    public int getCantA() {
        return cantA;
    }

    public void setCantA(int cantA) {
        this.cantA = cantA;
    }

    public int getCantB() {
        return cantB;
    }

    public void setCantB(int cantB) {
        this.cantB = cantB;
    }

    public int getDato(int i) {
        return v[i];
    }

    public void setV(int[] v) {
        this.v = v;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public boolean ingresarA(int dato){
        int suma = cantA+cantB;
        if(suma == max){
            return false;
        }else{
            v[cantA] = dato;
            cantA++;
            return true;
        }
    }
    public boolean ingresarB(int dato){
        int suma = cantA+cantB;
        if(suma == max){
            return false;
        }else{ 
            v[(max-1)-cantB] = dato;
            cantB++;
            return true;
        }
    }    
    
}
