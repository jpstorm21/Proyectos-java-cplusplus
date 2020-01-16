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
public class ListaPersonas {
    private NodoPersona first;

    public ListaPersonas() {
    this.first=null;
    }

    public NodoPersona getFirst() {
        return first;
    }

    public void setFirst(NodoPersona first) {
        this.first = first;
    }
    
public void ingresarPersona(Persona P) {//MÉTODO INGRESAR AL FINAL.
        NodoPersona nuevo = new NodoPersona(P);
        if (first == null) {
            first = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
}
        
    public Persona  buscarPersona(String rut){ 
           NodoPersona curr = first;
        
        while( curr != null && !curr.getPersona().getRut().equalsIgnoreCase(rut)) {
            curr = curr.getNext();
        }
        if ( curr != null){
           return curr.getPersona();
        } else {
            return null;
        }
    }
    
        
}
    
