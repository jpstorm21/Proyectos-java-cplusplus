/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

/**
 *
 * @author ASUS
 */
public class clientes extends Persona{
    private ListaPeliculas entradas;
    private ListaAsientos la;

    public clientes(String nombre, int rut, String apellido) {
        super(nombre, rut, apellido);
        this.entradas = new ListaPeliculas(1000);
        this.la = new ListaAsientos(1000);
    }

    public ListaPeliculas getEntradas() {
        return entradas;
    }

    public void setEntradas(ListaPeliculas entradas) {
        this.entradas = entradas;
    }

    public ListaAsientos getLa() {
        return la;
    }

    public void setLa(ListaAsientos la) {
        this.la = la;
    }
    
}
