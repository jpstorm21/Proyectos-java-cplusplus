/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_dao;

import java.util.List;

/**
 *
 * @author Juan Pablo Martinez
 */
public interface IClienteDAO {
    public List<Cliente> obtenerClientes();
    public Cliente obtenerCliente(int id);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
}
