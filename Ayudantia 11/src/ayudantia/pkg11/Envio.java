package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class Envio {

    private String Estado;
    private Cliente cliente;//cliente destinatario
    private ListaProductos lp;

    public Envio(String Estado) {
        this.Estado = Estado;
        lp = new ListaProductos();

    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaProductos getLp() {
        return lp;
    }

    public void setLp(ListaProductos lp) {
        this.lp = lp;
    }

    
}
