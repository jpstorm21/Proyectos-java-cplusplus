/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayundantia;

/**
 *
 * @author Usuario
 */
public class Poeta {
    private String nombre;
    private String rut;
    private int año;
    private String nacionalidad;
    private int cantlibros;
    private ListaLibros lb;
    public Poeta(String nombre , String rut ,int año ,String nacionalidad,int cantlibros){
        this.nombre = nombre;
        this.rut= rut;
        this.año= año;
        this.nacionalidad = nacionalidad;
        this.cantlibros = cantlibros;
        lb = new ListaLibros(1000);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantlibros() {
        return cantlibros;
    }

    public void setCantlibros(int cantlibros) {
        this.cantlibros = cantlibros;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public ListaLibros getLb(){
        return lb;
    }
}
