package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public interface Interface {
    
    public void ingresarCliente(Cliente C);
    public void ingresarEnvio(Envio E);
    public void ingresarProducto(Producto P);
    public Cliente buscarCliente(String rut);
    public Envio buscarEnvio(String estado);
    public Producto buscarProducto(String id);
    public boolean eliminarCliente(String rut);
    public boolean eliminarEnvio(String estado);
    public boolean eliminarProducto(String id);
    public Cliente obtenerCliente(NodoCliente actual);
    public ListaClientes getListaClientes();
    
    
    
    
    
    
    
}
