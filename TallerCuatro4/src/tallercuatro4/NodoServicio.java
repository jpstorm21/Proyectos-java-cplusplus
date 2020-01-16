/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class NodoServicio {
    private NodoServicio next;
    private NodoServicio prev;
    private Servicio servicio;

    public NodoServicio(Servicio servicio) {
        next=null;
        prev=null;
        this.servicio=servicio;
    }

    public NodoServicio getNext() {
        return next;
    }

    public void setNext(NodoServicio next) {
        this.next = next;
    }

    public NodoServicio getPrev() {
        return prev;
    }

    public void setPrev(NodoServicio prev) {
        this.prev = prev;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
}
