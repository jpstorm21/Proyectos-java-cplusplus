
package ejemplenodo;


public class ListaCircularUnNexo {
    private Nodo first;
    
    public ListaCircularUnNexo() {
        first = null;
    }
    
    public void ingresar(int d) {
        Nodo curr = new Nodo(d);
        if(first == null) {
            first = curr;
        } else {
            Nodo prev = first;
            while( prev.getNext() != first) {
                prev = prev.getNext();
            }
            prev.setNext(curr);
        }
        curr.setNext(first);
    }
    
    public boolean eliminar( int d) {
        Nodo curr = first;
        Nodo prev = first;
        if(first != null) {
        while( curr.getNext() != first && curr.getDato() != d) {
            prev = curr;
            curr = curr.getNext();
        }
        Nodo ult = first;
        while( ult.getNext() != first) {
            ult = ult.getNext();
        }
        
        if( curr.getDato() == d ) {
           if( first.getNext() == first) {
               first = null;
               
           } else {
               if ( curr == first ) {
                   first = first.getNext();
                   ult.setNext(first);
                   
                   
               } else {
                   prev.setNext(curr.getNext());
               }
           }
        }
        return true;
    } else {
            return false;
        }
    }
    public Nodo getFirst() {
        return first;
    }
   
}
