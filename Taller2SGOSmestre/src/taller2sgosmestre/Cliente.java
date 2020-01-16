/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2sgosmestre;

public class Cliente {

    private String rut;
    private String nombre;
    private String apellido;
    private int numero;
    private String correo;
    private ListaPrestamos lp;

    public Cliente(String rut, String nombre, String apellido, int numero, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.correo = correo;
        lp = new ListaPrestamos(1000);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ListaPrestamos getLp() {
        return lp;
    }

    public void setLp(ListaPrestamos lp) {
        this.lp = lp;
    }

}
