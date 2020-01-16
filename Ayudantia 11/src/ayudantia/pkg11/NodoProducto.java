package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class NodoProducto {
    
    private Producto producto;
    private NodoProducto next;
    private NodoProducto prev;

    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.next = null;
        this.prev = null;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoProducto getNext() {
        return next;
    }

    public void setNext(NodoProducto next) {
        this.next = next;
    }

    public NodoProducto getPrev() {
        return prev;
    }

    public void setPrev(NodoProducto prev) {
        this.prev = prev;
    }
    
    
    
    
}
