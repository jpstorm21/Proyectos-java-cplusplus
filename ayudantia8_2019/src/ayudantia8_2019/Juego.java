/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia8_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public abstract  class Juego {
    private String nombre;
    private String consola;
    private String tipo;

    public Juego(String nombre, String consola, String tipo) {
        this.nombre = nombre;
        this.consola = consola;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
