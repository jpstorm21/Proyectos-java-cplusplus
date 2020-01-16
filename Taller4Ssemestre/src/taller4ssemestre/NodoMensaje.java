/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

/**
 *
 * @author Usuario
 */
public class NodoMensaje {
    private NodoMensaje next;
    private Mensaje mensaje;

    public NodoMensaje( Mensaje mensaje) {
        next = null;
        this.mensaje = mensaje;
    }

    public NodoMensaje getNext() {
        return next;
    }

    public void setNext(NodoMensaje next) {
        this.next = next;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    
}
