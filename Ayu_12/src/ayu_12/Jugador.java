/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_12;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Jugador implements Comparable <Jugador> {
    private String nombre;
    private Equipo equipo;
    private int goles;
    
    public Jugador(String nombre, int goles) {
        this.nombre = nombre;
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", equipo=" + equipo + ", goles=" + goles + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public int compareTo(Jugador o) {
        if(goles > o.getGoles()){
            return 1;
        }
        if(goles < o.getGoles()){
            return -1;
        }
        return 0;
    }
    
}
