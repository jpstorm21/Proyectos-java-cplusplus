/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

/**
 *
 * @author Victor Huerta
 */
public class PaginaNegocio extends Pagina {
    private String direccion;
    private String nombreCiudad;
    private String codigoPostal;
    private int telefono;

    public PaginaNegocio(String direccion, String nombreCiudad, String codigoPostal, int telefono, String categoria, String clasificacion, int codigo, String nombre, String fechaCreacion) {
        super(categoria, clasificacion, codigo, nombre, fechaCreacion);
        this.direccion = direccion;
        this.nombreCiudad = nombreCiudad;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
