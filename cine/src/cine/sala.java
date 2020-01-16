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
public class sala {
    private int numero;
    private Pelicula pelicula;
    private ListaAsientos la;
    private String tipo;

    public sala(int numero, Pelicula pelicula, ListaAsientos la, String tipo) {
        this.numero = numero;
        this.la = new ListaAsientos(1000);
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public ListaAsientos getLa() {
        return la;
    }

    public void setLa(ListaAsientos la) {
        this.la = la;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
