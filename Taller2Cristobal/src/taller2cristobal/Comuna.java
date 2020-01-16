/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2cristobal;

/**
 *
 * @author Usuario
 */
public class Comuna {
    private int codigo;
    private String nombre;
    private int habitantes;
    private int cantCensistas;
    private ListaCensistas lce;

    public Comuna(int codigo, String nombre, int habitantes,int cantCensistas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.cantCensistas=cantCensistas;
        lce = new ListaCensistas(10);
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

    public int getCantCensistas() {
        return cantCensistas;
    }

    public void setCantCensistas(int cantCensistas) {
        this.cantCensistas = cantCensistas;
    }

    public ListaCensistas getLce() {
        return lce;
    }

    public void setLce(ListaCensistas lce) {
        this.lce = lce;
    }
    
    
    
}
