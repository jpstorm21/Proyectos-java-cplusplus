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
public class Lista1nexo {

    private Nodo1nexo first;

    public Lista1nexo() {
        this.first = null;
    }

    public Nodo1nexo getFirst() {
        return first;
    }

    public void setFirst(Nodo1nexo first) {
        this.first = first;
    }

    public void ingresar(Empleado E) {
        Nodo1nexo nuevo = new Nodo1nexo(E);
        if (first == null) {
            first = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    public Empleado buscar(String nombre) {
        Nodo1nexo actual = first;
        while (actual != null && actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getEmpleado();
        } else {
            return null;
        }

    }

    public boolean eliminarNodo(String nombre) {
        Nodo1nexo actual = first;
        Nodo1nexo previo = first;
        while (actual != null && !actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            previo = actual;
            actual = actual.getNext();
        }
        if (actual != null) {
            if (actual == first) {
                first = first.getNext();
            } else {
                previo.setNext(actual.getNext());
            }
            return true;
        } else {
            return false;
        }
        
    }
}
