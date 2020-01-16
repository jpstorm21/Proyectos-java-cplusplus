
package ejemplenodo;

public class ListaUnNexo {
    private Nodo first;
    private Nodo last;
    
    public ListaUnNexo() {
        first = null;
        last = null;
    }
    
    public void ingresar(int d) {
        Nodo curr = new Nodo(d);
        curr.setNext(first);
        first = curr;
    }
    public void ingresarOrdenado (int d) {
        Nodo nuevo = new Nodo(d);
        Nodo previo = null;
        Nodo curr = first;
        while( curr !=null && d > curr.getDato()) {
            previo = curr;
            curr = curr.getNext();
        }
        if(previo==null) { // si el previo es nulo , esta al comienzo
            first = nuevo;
        } else {
            previo.setNext(nuevo);
    }
        nuevo.setNext(curr);
    }
    
    public boolean buscar(int d) {
        Nodo curr = first;
        
        while( curr != null && curr.getDato() != d) {
            curr = curr.getNext();
        }
        if ( curr != null){
           return true;
        } else {
            return false;
        }
    }
    public boolean eliminar(int d) {
        Nodo curr = first;
        Nodo prev = first;
        while( curr!=null && curr.getDato() != d) {
            prev = curr;
            curr= curr.getNext();
        }
      
        
        if( curr != null) {
           if( curr == first) {
               first = first.getNext();
           } else {
               prev.setNext(curr.getNext());
           }
        }
        return true;
    
}
    
}
