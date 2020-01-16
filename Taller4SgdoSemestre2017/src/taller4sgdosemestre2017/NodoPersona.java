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
public class NodoPersona {
    private Persona persona;
    private NodoPersona next;

    public NodoPersona(Persona persona) {
        this.persona = persona;
        this.next = null;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public NodoPersona getNext() {
        return next;
    }

    public void setNext(NodoPersona next) {
        this.next = next;
    }
    
}
