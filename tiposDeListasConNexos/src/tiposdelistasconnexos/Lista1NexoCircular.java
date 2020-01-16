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
public class Lista1NexoCircular {

    private Nodo1nexo first;

    public Lista1NexoCircular() {
        first = null;
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
            first.setNext(first);
        } else {
            Nodo1nexo actual = first;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    public Empleado buscar(String nombre) {
        Nodo1nexo actual = first;
        while (actual.getNext() != null && !actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNext();
        }
        if (actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            return actual.getEmpleado();
        } else {
            return null;
        }
    }

    public boolean eliminar(String nombre) {
        Nodo1nexo actual = first;
        Nodo1nexo prev = first;
        while (actual != null && !actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            prev = actual;
            actual = actual.getNext();
        }
        if (actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            if (actual.getNext() == first) {
                first = null;
            } else if (actual == first) {
                Nodo1nexo current = first;
                while (actual.getNext() != null) {
                    actual = actual.getNext();
                }
                first = first.getNext();
                actual.setNext(first);
            } else {
                prev.setNext(actual.getNext());
            }
            return true;
        } else {
            return false;
        }
    }

}
