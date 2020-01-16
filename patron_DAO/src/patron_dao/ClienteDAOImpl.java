/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ClienteDAOImpl implements IClienteDAO {
    private List<Cliente> clientes;

    public ClienteDAOImpl() {
        clientes = new ArrayList();
        Cliente cliente1 = new Cliente(0,"jp","martinez");
        Cliente cliente2 = new Cliente(1,"sebon","godoy");
        clientes.add(cliente1);
        clientes.add(cliente2);
    }
    

    @Override
    public List<Cliente> obtenerClientes() {
       return clientes;
    }

    @Override
    public Cliente obtenerCliente(int id) {
        return clientes.get(id);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clientes.get(cliente.getId()).setNombre(cliente.getNombre());
        clientes.get(cliente.getId()).setApellido(cliente.getApellido());
        System.out.println("datos actualizados");
    }
    @Override
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente.getId());
    }
}
