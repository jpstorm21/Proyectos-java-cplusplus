/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes23.pkg10.pkg2017;

/**
 *
 * @author Usuario
 */
public class NodoEmpleado {
    private Empleado empleado;
    private NodoEmpleado next;
    private NodoEmpleado prev;

    public NodoEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.next = null;
        this.prev = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NodoEmpleado getNext() {
        return next;
    }

    public void setNext(NodoEmpleado next) {
        this.next = next;
    }

    public NodoEmpleado getPrev() {
        return prev;
    }

    public void setPrev(NodoEmpleado prev) {
        this.prev = prev;
    }
    
    
}
