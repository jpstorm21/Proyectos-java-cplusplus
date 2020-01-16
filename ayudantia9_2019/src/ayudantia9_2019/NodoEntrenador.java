/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia9_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class NodoEntrenador {
    private NodoEntrenador next;
    private Entrenador entrenador;

    public NodoEntrenador(Entrenador entrenador) {
        this.next = null;
        this.entrenador = entrenador;
    }

    public NodoEntrenador getNext() {
        return next;
    }

    public void setNext(NodoEntrenador next) {
        this.next = next;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
}
