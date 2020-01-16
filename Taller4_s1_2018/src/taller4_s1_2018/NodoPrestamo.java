/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

/**
 *
 * @author Juan Pablo Martinez
 */
public class NodoPrestamo {
    private Prestamo prestamo;
    private NodoPrestamo next;

    public NodoPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.next = null;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public NodoPrestamo getNext() {
        return next;
    }

    public void setNext(NodoPrestamo next) {
        this.next = next;
    }
    
}
