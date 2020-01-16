
package ejemplenodo;


public class ListaCircularDobleNexo {
    private Nodo first;
    private Nodo last;

    public ListaCircularDobleNexo() {
        first = null;
        last = null;
    }
    
    public boolean eliminar(int d) { // dibujar para entender
        Nodo actual = first;
        while(actual.getNext() != first && actual.getDato() != d){
            actual = actual.getNext();
        }
        if(actual != null){
            if(actual == first){
                first= first.getNext();
                first.setPrev(last);
                last.setNext(first);
            }else{
                actual.getPrev().setNext(actual.getNext());
            }
            if(actual == last){
                last = last.getPrev();
                last.setNext(first);
                first.setPrev(last);
            }else{
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        }else{
            return false;
        }
    }
    public boolean buscar(int d) {
        Nodo curr = first;
        if( first != null) {
        while (curr.getNext() != first && curr.getDato() != d) { // aqui termina cuando el siguiente es el primero, significa que termino la circularidad
            curr = curr.getNext();
        }
        
        if( curr.getDato() == d) {
           System.out.println("Dato encontrado");
           return true;
        } else {
            System.out.println("dato no encontrado");
            return false;
        }
    
    } else {
            return false;
        }
   
    }
    public void ingresar(int d) { // hacer dibujo para entender esto
       Nodo curr = new Nodo(d);
       if ( first == null) {
           first = curr;
           last = curr;
       } else {
          curr.setPrev(last);
          last.setNext(curr);
          curr.setNext(first);
          first.setPrev(curr);
          first = curr;
    }
  
}
}


