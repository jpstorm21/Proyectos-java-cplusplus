/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona {
    private Organizacion organizacion;
    private ListaOrdServicios servicios;

    public Cliente(String rut, String nombres, String apellidos, int edad, int telefono, String mail) {
        super(rut, nombres, apellidos, edad, telefono, mail);
        organizacion=null;
        servicios = new ListaOrdServicios();
    }

  

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public ListaOrdServicios getServicios() {
        return servicios;
    }

    public void setServicios(ListaOrdServicios servicios) {
        this.servicios = servicios;
    }
    
    
}
