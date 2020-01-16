package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class NodoCliente {
    
    private Cliente cliente;
    private NodoCliente next;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        next = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCliente getNext() {
        return next;
    }

    public void setNext(NodoCliente next) {
        this.next = next;
    }
    
    
    
}
