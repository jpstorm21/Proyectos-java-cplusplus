
package ejemplenodo;


public class Nodo {
    private int dato;
    private Nodo next;
    private Nodo prev;
    
    public Nodo(int dato) {
        this.dato = dato;
        next = null;
        prev = null;
        
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
    
}

