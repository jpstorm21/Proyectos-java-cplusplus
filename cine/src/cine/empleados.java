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
public class empleados extends Persona {
    private ListaSalas ls;

    public empleados(String nombre, int rut, String apellido) {
        super(nombre, rut, apellido);
        this.ls = new ListaSalas(1000);
    }

    public ListaSalas getLs() {
        return ls;
    }

    public void setLs(ListaSalas ls) {
        this.ls = ls;
    }
    
    
    
}
