/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class NodoABB {
    private int dato;
    private NodoABB hijoDer;
    private NodoABB hijoIzq;
    
    public NodoABB(int dato) {
        this.dato = dato;
        hijoDer = null;
        hijoIzq = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoABB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoABB hijoDer) {
        this.hijoDer = hijoDer;
    }

    public NodoABB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoABB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    
}
