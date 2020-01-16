/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class NodoPersona {
    private NodoPersona next;
    private Persona persona;

    public NodoPersona(Persona persona) {
   next=null;
   this.persona = persona;
    }

    public NodoPersona getNext() {
        return next;
    }

    public void setNext(NodoPersona next) {
        this.next = next;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
