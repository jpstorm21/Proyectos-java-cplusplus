/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia5.pkg2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Jugador {
    private String nombre;
    private String posicion;
    private int puntacion;

    public Jugador(String nombre, String posicion, int puntacion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.puntacion = puntacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getPuntacion() {
        return puntacion;
    }

    public void setPuntacion(int puntacion) {
        this.puntacion = puntacion;
    }
    
}
