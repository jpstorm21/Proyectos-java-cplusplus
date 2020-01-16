/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdelistasconnexos;

/**
 *
 * @author Usuario
 */
public class Nodo2nexo {
    private Nodo2nexo next;
    private Nodo2nexo prev;
    private Empleado empleado;

    public Nodo2nexo(Empleado E) {
        this.next = null;
        this.prev = null;
        this.empleado= E;
    }

    public Nodo2nexo getNext() {
        return next;
    }

    public void setNext(Nodo2nexo next) {
        this.next = next;
    }

    public Nodo2nexo getPrev() {
        return prev;
    }

    public void setPrev(Nodo2nexo prev) {
        this.prev = prev;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    
    
}
