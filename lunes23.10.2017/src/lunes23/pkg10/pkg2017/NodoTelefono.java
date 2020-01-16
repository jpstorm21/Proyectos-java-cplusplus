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
public class NodoTelefono {
    private Telefono telefono;
    private NodoTelefono next;

    public NodoTelefono(Telefono telefono) {
        this.telefono = telefono;
        this.next = null;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public NodoTelefono getNext() {
        return next;
    }

    public void setNext(NodoTelefono next) {
        this.next = next;
    }
    
}
