/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;
import java.util.List;
import java.util.LinkedList;

public abstract class Persona {
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String alias;
    private ListaAsignaturas la;
    private ListaMensajes lm;

    protected Persona(String rut, String nombre, String apellido, String correo, String alias) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.alias = alias;
        lm = new ListaMensajes();
        la = new ListaAsignaturas();
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ListaAsignaturas getLa() {
        return la;
    }

    public ListaMensajes getLm() {
        return lm;
    }

    public void setLm(ListaMensajes lm) {
        this.lm = lm;
    }
    
    abstract public int CalcularNota();

    
    
}
