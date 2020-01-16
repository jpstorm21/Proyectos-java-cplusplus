/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;


public class NodoPersona {
    private NodoPersona next;
    private NodoPersona prev;
    private Persona persona;

    public NodoPersona(Persona persona) {
        next = null;
        prev = null;
        this.persona = persona;
    }

    public NodoPersona getNext() {
        return next;
    }

    public void setNext(NodoPersona next) {
        this.next = next;
    }

    public NodoPersona getPrev() {
        return prev;
    }

    public void setPrev(NodoPersona prev) {
        this.prev = prev;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
