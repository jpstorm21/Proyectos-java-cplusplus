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
public class Organizacion {
    private String rutOrg;
    private String nombreOrg;
    private String direccion;

    public Organizacion(String rutOrg, String nombreOrg, String direccion) {
        this.rutOrg = rutOrg;
        this.nombreOrg = nombreOrg;
        this.direccion = direccion;
    }

    public String getRutOrg() {
        return rutOrg;
    }

    public void setRutOrg(String rutOrg) {
        this.rutOrg = rutOrg;
    }

    public String getNombreOrg() {
        return nombreOrg;
    }

    public void setNombreOrg(String nombreOrg) {
        this.nombreOrg = nombreOrg;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
   
    
    
}
