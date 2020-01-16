/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

/**
 *
 * @author Usuario
 */
public class ListaMensajes {

    private NodoMensaje first;

    public ListaMensajes() {
        first = null;
    }

    public NodoMensaje getFirst() {
        return first;
    }

    public void setFirst(NodoMensaje first) {
        this.first = first;
    }

    public void ingresarMensaje(Mensaje M) {
        NodoMensaje nuevo = new NodoMensaje(M);
        if (first == null) {
            first = nuevo;
        } else {
            NodoMensaje prev = first;
            while (prev.getNext() != first) {
                prev = prev.getNext();
            }
            prev.setNext(nuevo);
        }
        nuevo.setNext(first);
    }

    public boolean eliminarMensaje(String asunto) {
        NodoMensaje prev = first;
        NodoMensaje actual = first;
        if (first != null) {
            while (actual.getNext() != first && !actual.getMensaje().getAsunto().equalsIgnoreCase(asunto)) {
                prev = actual;
                actual = actual.getNext();
            }
            NodoMensaje ultimo = first;
            while (ultimo.getNext() != first) {
                ultimo = ultimo.getNext();
            }
            if (actual.getMensaje().getAsunto().equalsIgnoreCase(asunto)) {
                if (actual == first) {
                    first = first.getNext();
                    ultimo.setNext(first);
                } else {
                    prev.setNext(actual.getNext());
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
