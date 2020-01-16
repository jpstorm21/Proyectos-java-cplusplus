/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia9_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaEntrenadores {

    private NodoEntrenador first;

    public ListaEntrenadores() {
        this.first = null;
    }

    public NodoEntrenador getFirst() {
        return first;
    }

    public void setFirst(NodoEntrenador first) {
        this.first = first;
    }

    public void ingresar(Entrenador e) {
        NodoEntrenador n = new NodoEntrenador(e);
        if (first == null) {
            first = n;
        } else {
            n.setNext(first);
            first = n;
        }
    }

    public Entrenador buscarEntrenador(int id) {
        NodoEntrenador current = first;
        while (current != null && current.getEntrenador().getIDentrenador() != id) {
            current = current.getNext();
        }
        if (current != null) {
            return current.getEntrenador();
        } else {
            return null;
        }
    }

    public boolean eliminarEntrenador(int id) {
        NodoEntrenador current = first;
        NodoEntrenador prev = null;
        while (current != null && current.getEntrenador().getIDentrenador() != id) {
            current = current.getNext();
        }
        if (current != null) {
            if (current == first) {
                first = first.getNext();
            } else {
                prev.setNext(current.getNext());
            }
            return true;
        } else {
            return false;
        }
    }
}
