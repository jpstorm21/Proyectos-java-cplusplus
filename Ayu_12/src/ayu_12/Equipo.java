/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Juan Pablo Martinez
 */
public class Equipo implements Comparable<Equipo>{
    private String nombre;
    private int años;
    private int copas;
    private ArrayList<Jugador> lj;
    private Jugador goleador;
    private Jugador capitan;
            
    public Equipo(String nombre, int años, int copas) {
        this.nombre = nombre;
        this.años = años;
        this.copas = copas;
        lj =  new ArrayList<>();
    }
    
    public void obtenerCapANDgoleador(){
        Collections.sort(lj, new Comparator<Jugador>() {
            public int compare(Jugador P1, Jugador P2) {
                return P2.getGoles()- P1.getGoles();
            }
        });
        goleador = lj.get(0);
        capitan = lj.get(1);       
    }

    public Jugador getGoleador() {
        return goleador;
    }

    public void setGoleador(Jugador goleador) {
        this.goleador = goleador;
    }

    public Jugador getCapitan() {
        return capitan;
    }

    public void setCapitan(Jugador capitan) {
        this.capitan = capitan;
    }
            

    public ArrayList<Jugador> getLj() {
        return lj;
    }

    public void setLj(ArrayList<Jugador> lj) {
        this.lj = lj;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public int getCopas() {
        return copas;
    }

    public void setCopas(int copas) {
        this.copas = copas;
    }

    @Override
    public int compareTo(Equipo o) {
        return getNombre().compareTo(o.getNombre());
    }

}
