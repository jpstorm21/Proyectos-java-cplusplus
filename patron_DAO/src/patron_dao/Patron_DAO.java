
package patron_dao;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Patron_DAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IClienteDAO clienteDAO = new ClienteDAOImpl();
        clienteDAO.obtenerClientes().forEach(System.out::
                                             println);
        Cliente cliente = clienteDAO.obtenerCliente(0);
        cliente.setApellido("el macho");
        clienteDAO.actualizarCliente(cliente);
        clienteDAO.obtenerClientes().forEach(System.out::
                                             println);        
    }
    
}
