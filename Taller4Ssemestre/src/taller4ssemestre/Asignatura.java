/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

/**
 *
 * @author Usuario
 */
public class Asignatura {
    private String codigo;
    private String nombre;
    private int cantPersonas;
    private ListaPersonas lp;

    public Asignatura(String codigo, String nombre, int cantPersonas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantPersonas = cantPersonas;
        lp = new ListaPersonas();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public ListaPersonas getLp() {
        return lp;
    }

    public void setLp(ListaPersonas lp) {
        this.lp = lp;
    }
    
    
}
