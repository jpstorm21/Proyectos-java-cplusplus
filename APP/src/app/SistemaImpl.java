
package app;

import java.util.ArrayList;
import java.util.Iterator;

public class SistemaImpl implements Sistema {
    private ListaProductos listaProductos;
    private ArrayList<Cliente> listaClientes;

    public SistemaImpl() {
        listaProductos = new ListaProductos();
        listaClientes = new ArrayList <>();
    }

    @Override
    public void IngresarCliente(Cliente c) {
        listaClientes.add(c);
    }

    @Override
    public void IngresarProducto(Producto p) {
        listaProductos.IngresarProducto(p);
    }

    @Override
    public Iterator getListaClientes() {
        return listaClientes.iterator();
    }

    @Override
    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    @Override
    public Cliente BuscarCliente(String rut) {
        Iterator iterador = listaClientes.iterator();
        while(iterador.hasNext()){
            Cliente c = (Cliente)iterador.next();
            if(c.getRut().equalsIgnoreCase(rut))
                return c;
        }
        return null;
    }

    @Override
    public Producto BuscarProducto(int cod) {
        return listaProductos.BuscarProducto(cod);
    }
    
    
}
