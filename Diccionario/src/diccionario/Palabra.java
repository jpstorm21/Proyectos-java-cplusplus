/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

/**
 *
 * @author Usuario
 */
public class Palabra {
    private String nombre;
    private String significado;

    public Palabra(String nombre, String significado) {
        this.nombre = nombre;
        this.significado = significado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }
    
}
