/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_parte2sgdo2017;

/**
 *
 * @author Usuario
 */
public class NodoMatriz {
    private int[][] matriz;
    private NodoMatriz prev;
    private NodoMatriz next;
    
    public NodoMatriz(int[][] matriz){
        this.matriz = matriz;
        this.next = null;
        this.prev = null;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public NodoMatriz getNext() {
        return next;
    }

    public void setNext(NodoMatriz next) {
        this.next = next;
    }

    public NodoMatriz getPrev() {
        return prev;
    }

    public void setPrev(NodoMatriz prev) {
        this.prev = prev;
    }
}
