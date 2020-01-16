/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaversion2nexos;

/**
 *
 * @author Usuario
 */
public abstract class Profesor {
    protected String rut;
    protected String nombre;
    protected ListaParalelos lp;

    protected Profesor(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        lp = new ListaParalelos();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaParalelos getLp() {
        return lp;
    }

    public void setLp(ListaParalelos lp) {
        this.lp = lp;
    }
    abstract public int calcularSueldo();
}
