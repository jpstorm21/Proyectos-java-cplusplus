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
public class Lista2nexosCirculares {

    private Nodo2nexo first;
    private Nodo2nexo last;

    public Lista2nexosCirculares() {
        this.first = null;
        this.last = null;
    }

    public Nodo2nexo getFirst() {
        return first;
    }

    public void setFirst(Nodo2nexo first) {
        this.first = first;
    }

    public Nodo2nexo getLast() {
        return last;
    }

    public void setLast(Nodo2nexo last) {
        this.last = last;
    }

    public void ingresarCircular(Empleado E) {
        Nodo2nexo nuevo = new Nodo2nexo(E);
        if (first == null) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.setPrev(last);
            last.setNext(nuevo);
            nuevo.setNext(first);
            first.setPrev(nuevo);
            first = nuevo;
        }
    }

    public Empleado buscarCircular(String nombre) {
        Nodo2nexo actual = first;
        while (actual.getNext() != first && !actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNext();
        }
        if (actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            return actual.getEmpleado();
        } else {
            return null;
        }
    }

    public boolean eliminarCircular(String nombre) {
        Nodo2nexo actual = first;
        while (actual.getNext() != first && !actual.getEmpleado().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            if (actual == first) {
                first = first.getNext();
                first.setPrev(last);
                last.setNext(first);
            } else {
                actual.getPrev().setNext(actual.getNext());
            }
            if (actual == last) {
                last = last.getPrev();
                last.setNext(first);
                first.setPrev(last);
            } else {
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        } else {
            return false;
        }
    }
}
