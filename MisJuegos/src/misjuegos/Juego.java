/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misjuegos;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Juego {

    private String estado;
    private String nombre;
    private String plataforma;
    private String instalado;

    public Juego(String estado, String nombre, String instalado, String plataforma) {
        this.estado = estado;
        this.nombre = nombre;
        this.instalado = instalado;
        this.plataforma = plataforma;
    }

    public String getInstalado() {
        return instalado;
    }

    public void setInstalado(String instalado) {
        this.instalado = instalado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

}
