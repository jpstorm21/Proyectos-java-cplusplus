package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class ListaProductos {//DOBLE NEXO
    
    private NodoProducto first;
    private NodoProducto last;

    public ListaProductos() {
        this.first = null;
        this.last = null;
    }

    public NodoProducto getFirst() {
        return first;
    }

    public void setFirst(NodoProducto first) {
        this.first = first;
    }

    public NodoProducto getLast() {
        return last;
    }

    public void setLast(NodoProducto last) {
        this.last = last;
    }
    
    public void ingresarProducto(Producto P){//MÉTODO INGRESAR AL PRINCIPIO.
        NodoProducto nuevo = new NodoProducto(P);
        if(first == null){
            first = nuevo;
            last = nuevo;
        }else{
            first.setPrev(nuevo);
            nuevo.setNext(first);
            first = nuevo;
        }
    }
    
    /*public void ingresarProducto(Producto P){
        NodoProducto nuevo = new NodoProducto(P);
            if(first == null){
                first = nuevo;
                last = nuevo;
            }else{
                first.setNext(nuevo);
                nuevo.setPrev(first);
                last = nuevo; 
        }
    */
    
    public Producto buscarProducto(String id){
        NodoProducto actual = first;
        while(actual != null && !actual.getProducto().getId().equalsIgnoreCase(id)){
            actual = actual.getNext();
        }
        
        if(actual != null){
            return actual.getProducto();
        }else{
            return null;
        }
    }
    
    public boolean eliminarProducto(String id){
        NodoProducto actual = first;
        while(actual != null && !actual.getProducto().getId().equalsIgnoreCase(id)){
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
