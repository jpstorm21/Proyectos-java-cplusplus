
package app;


public class NodoProducto {
    private Producto producto;
    private NodoProducto siguiente;
    private NodoProducto previo;

    public NodoProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }

    public NodoProducto getPrevio() {
        return previo;
    }

    public void setPrevio(NodoProducto previo) {
        this.previo = previo;
    }
    
    
    
}
