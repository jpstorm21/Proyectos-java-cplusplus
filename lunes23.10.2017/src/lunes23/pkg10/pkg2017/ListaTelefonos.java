/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes23.pkg10.pkg2017;

/**
 *
 * @author Usuario
 */
public class ListaTelefonos {
    private NodoTelefono first;

    public ListaTelefonos() {
        this.first = null;
    }

    public NodoTelefono getFirst() {
        return first;
    }

    public void setFirst(NodoTelefono first) {
        this.first = first;
    }
    public void ingresarTelefono(Telefono T){
        NodoTelefono nuevo = new NodoTelefono(T);
        if(first == null){
            first = nuevo;
        }else{
            nuevo.setNext(first);
            first = nuevo;
        }
    }
    public Telefono buscarTelefono(int fono){
        NodoTelefono actual = first;
        while(actual != null && actual.getTelefono().getFono() != fono){
            actual = actual.getNext();
        }
        if(actual != null){
            return actual.getTelefono();
        }else{
            return null;
        }
    }
    public boolean eliminarTelefono(int fono){
        NodoTelefono actual = first;
         NodoTelefono prev = first;
        while(actual != null && actual.getTelefono().getFono() != fono){
            prev = actual;
            actual = actual.getNext();
        }
        if(actual != null){
            if(actual == first){
                first = first.getNext();
            }else{
                prev.setNext(actual.getNext());
            }
            return true;
        }else{
            return false;
        }
    }
   
}
