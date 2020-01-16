/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

public class ListaPersonas {

    private NodoPersona first;
    private NodoPersona last;

    public ListaPersonas() {
        first = null;
        last = null;
    }

    public NodoPersona getFirst() {
        return first;
    }

    public void setFirst(NodoPersona first) {
        this.first = first;
    }

    public NodoPersona getLast() {
        return last;
    }

    public void setLast(NodoPersona last) {
        this.last = last;
    }

    public void ingresarPersona(Persona P) {
        NodoPersona actual = first;
        while (actual != null && !actual.getPersona().getCorreo().equalsIgnoreCase(P.getCorreo())) {
            actual = actual.getNext();
        }
        if (actual != null) {
            System.out.println("persona tiene un correo igual al de otra!!");
        } else {
            NodoPersona nuevo = new NodoPersona(P);
            NodoPersona prev = null;
            NodoPersona aux = first;

            while (aux != null && P.getNombre().compareToIgnoreCase(aux.getPersona().getNombre())> 0) {
                prev = aux;
                aux = aux.getNext();
            }
            if (prev == null) {
                first = nuevo;
            } else {
                prev.setNext(nuevo);
                nuevo.setPrev(prev);
            }
            nuevo.setNext(aux);
            if (aux != null) {
                aux.setPrev(nuevo);
            } else {
                last = nuevo;
            }
        }
    }

    public Persona buscarPersonaXrut(String rut) {
        NodoPersona actual = first;
        while (actual != null && !actual.getPersona().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getPersona();
        }else{
            return null;
        } 
    }
    public Persona buscarPersonaXalias(String alias) {
        NodoPersona actual = first;
        while (actual != null && !actual.getPersona().getAlias().equalsIgnoreCase(alias)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getPersona();
        }else{
            return null;
        } 
    }
    public boolean eliminarPersona(String rut){
        NodoPersona actual = first;
        while(actual !=  null && !actual.getPersona().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNext();
        }
        if(actual != null){
            if(actual == first){
                first = first.getNext();
            }else{
                actual.getPrev().setNext(actual.getNext());
            }
            if(actual == last){
                last = last.getPrev();
            }else{
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        }else{
            return false;
        }
    }
    

}
