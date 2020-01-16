/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptarea;

/**
 *
 * @author Victor Huerta
 */
public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private ListaCarreras lc;
    private ListaParalelos lp;

    public Asignatura(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        lc = new ListaCarreras();
        lp = new ListaParalelos();
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ListaCarreras getLc() {
        return lc;
    }

    public void setLc(ListaCarreras lc) {
        this.lc = lc;
    }

    public ListaParalelos getLp() {
        return lp;
    }

    public void setLp(ListaParalelos lp) {
        this.lp = lp;
    }
    
    
    
    
    
}
