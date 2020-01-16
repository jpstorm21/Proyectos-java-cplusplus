/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_5_2017;

/**
 *
 * @author Eduardo
 */
public class Dueño {
    private String nomDueño;
    private int rut;
    private int cantMascotas;
    private ListaMascota refListaMascotas;

    public Dueño(String nomDueño, int rut, int cantMascotas) {
        this.nomDueño = nomDueño;
        this.rut = rut;
        this.cantMascotas = cantMascotas;
        refListaMascotas = new ListaMascota(cantMascotas);
    }

    public String getNomDueño() {
        return nomDueño;
    }

    public void setNomDueño(String nomDueño) {
        this.nomDueño = nomDueño;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getCantMascotas() {
        return cantMascotas;
    }

    public void setCantMascotas(int cantMascotas) {
        this.cantMascotas = cantMascotas;
    }

    public ListaMascota getRefListaMascotas() {
        return refListaMascotas;
    }

    public void setRefListaMascotas(ListaMascota refListaMascotas) {
        this.refListaMascotas = refListaMascotas;
    }
    
    
    
}
