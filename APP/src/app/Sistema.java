/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Iterator;

/**
 *
 * @author sebastian
 */
public interface Sistema {
    void IngresarCliente(Cliente c);
    void IngresarProducto(Producto p);
    Iterator getListaClientes();
    ListaProductos getListaProductos();
    Cliente BuscarCliente(String rut);
    Producto BuscarProducto(int cod);
}
