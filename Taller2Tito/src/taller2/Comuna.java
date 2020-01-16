/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

/**
 *
 * @author Victor Huerta
 */
public class Comuna {
    private int codigo;
    private String nombre;
    private int habitantes;
    private ListaCensistas lc;

    public Comuna(int codigo, String nombre, int habitantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habitantes = habitantes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public ListaCensistas getLc() {
        return lc;
    }

    public void setLc(ListaCensistas lc) {
        this.lc = lc;
    }
    
    
    
}
