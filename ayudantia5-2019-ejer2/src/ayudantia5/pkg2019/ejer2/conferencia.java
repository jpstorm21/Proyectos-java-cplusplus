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
public class conferencia {
    private String nombre;
    private ListaEquipos le;

    public conferencia(String nombre) {
        this.nombre = nombre;
        this.le = new ListaEquipos(100);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEquipos getLe() {
        return le;
    }

    public void setLe(ListaEquipos le) {
        this.le = le;
    }
    
    
}
