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
public class Censista {
     private int codigo;
    private String nombre;
    private ListaPersonas lp;
    private Comuna refComuna;

    public Censista(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        lp = new ListaPersonas(1000);
       
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


    public ListaPersonas getLp() {
        return lp;
    }

    public void setLp(ListaPersonas lp) {
        this.lp = lp;
    }

    public Comuna getRefComuna() {
        return refComuna;
    }

    public void setRefComuna(Comuna refComuna) {
        this.refComuna = refComuna;
    }
    
    
    
}
