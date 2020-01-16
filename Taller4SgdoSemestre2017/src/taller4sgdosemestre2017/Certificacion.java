/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4sgdosemestre2017;

/**
 *
 * @author Usuario
 */
public class Certificacion {
    private int codigo;
    private String tipo;
    public static int pjeTotal;
    public static int pjeAprobacion;
    public static int duracion;

    public Certificacion(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        Certificacion.pjeTotal = 100;
        Certificacion.pjeAprobacion= 80;
        Certificacion.duracion = 2;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static int getPjeTotal() {
        return pjeTotal;
    }

    public static void setPjeTotal(int pjeTotal) {
        Certificacion.pjeTotal = pjeTotal;
    }

    public static int getPjeAprobacion() {
        return pjeAprobacion;
    }

    public static void setPjeAprobacion(int pjeAprobacion) {
        Certificacion.pjeAprobacion = pjeAprobacion;
    }

    public static int getDuracion() {
        return duracion;
    }

    public static void setDuracion(int duracion) {
        Certificacion.duracion = duracion;
    }

    
}
