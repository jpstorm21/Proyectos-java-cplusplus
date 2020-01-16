/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4sgdosemestre2017;

/**
 *
 * @author Usuario
 */
public class NodoServicio {
    private Servicio servicio;
    private NodoServicio next;
    private NodoServicio prev;

    public NodoServicio(Servicio servicio) {
        this.servicio = servicio;
        this.next = null;
        this.prev = null;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
    
}
