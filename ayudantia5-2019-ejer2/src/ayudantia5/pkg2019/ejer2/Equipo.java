/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia5.pkg2019.ejer2;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Equipo {
    private String nombre;
    private int victorias;
    private conferencia conferencia;

    public Equipo(String nombre, int victorias) {
        this.nombre = nombre;
        this.victorias = victorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(conferencia conferencia) {
        this.conferencia = conferencia;
    }
    
    
}