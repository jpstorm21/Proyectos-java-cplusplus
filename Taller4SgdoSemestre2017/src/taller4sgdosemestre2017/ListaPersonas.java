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
public class ListaPersonas {

    private NodoPersona first;

    public ListaPersonas() {
        first = null;
    }

    public NodoPersona getFirst() {
        return first;
    }

    public void setFirst(NodoPersona first) {
        this.first = first;
    }

    public void ingresarPersona(Persona p) {
        NodoPersona nuevo = new NodoPersona(p);
        if (first == null) {
            first = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    public Persona buscarPersona(String rut) {
        NodoPersona actual = first;
        while (actual != null && !actual.getPersona().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getPersona();
        } else {
            return null;
        }
    }
}
