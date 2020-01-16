/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juan Pablo Martinez
 */
public class FiestaEstelar implements Comparable<FiestaEstelar> {
    private Date fechaEvento;
    private String descripcion;
    private ArrayList<Socio> listaAsistentes;

    public FiestaEstelar(Date fechaEvento, String descripcion) {
        this.fechaEvento = fechaEvento;
        this.descripcion = descripcion;
        this.listaAsistentes = new ArrayList<Socio>();
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Socio> getListaAsistentes() {
        return listaAsistentes;
    }

    public void setListaAsistentes(ArrayList<Socio> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }

    @Override
    public String toString() {
        return "FiestaEstelar{" + "fechaEvento=" + fechaEvento + ", descripcion=" + descripcion + ", listaAsistentes=" + listaAsistentes + '}';
    }

    @Override
    public int compareTo(FiestaEstelar o) {
       return getFechaEvento().compareTo(o.fechaEvento);
    }


            
}
