package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class InterfaceImpl implements Interface {

    private ListaClientes listaClientes;
    private ListaEnvios listaEnvios;
    private ListaProductos listaProductos;

    public InterfaceImpl() {
        listaClientes = new ListaClientes();
        listaEnvios = new ListaEnvios();
        listaProductos = new ListaProductos();
    }

    @Override
    public void ingresarCliente(Cliente C) {
        listaClientes.ingresarCliente(C);
    }

    @Override
    public void ingresarEnvio(Envio E) {
        listaEnvios.ingresarEnvio(E);
    }

    @Override
    public void ingresarProducto(Producto P) {
        listaProductos.ingresarProducto(P);
    }

    @Override
    public Cliente buscarCliente(String rut) {
        Cliente C = listaClientes.buscarCliente(rut);
        if (C != null) {
            return C;
        } else {
            return null;
        }
    }

    @Override
    public Envio buscarEnvio(String estado) {
        Envio E = listaEnvios.buscarEnvio(estado);
        if (E != null) {
            return E;
        } else {
            return null;
        }
    }

    @Override
    public Producto buscarProducto(String id) {
        Producto P = listaProductos.buscarProducto(id);
        if (P != null) {
            return P;
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarCliente(String rut) {
        boolean sepudo = listaClientes.eliminarCliente(rut);
        if (sepudo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarEnvio(String estado) {
        boolean sepudo = listaEnvios.eliminarEnvio(estado);
        if (sepudo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String id) {
        boolean sepudo = listaProductos.eliminarProducto(id);
        if (sepudo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Cliente obtenerCliente(NodoCliente actual) {
        Cliente C = actual.getCliente();
        return C;

    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

}
