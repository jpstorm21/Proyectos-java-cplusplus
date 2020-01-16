/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

import ucn.StdOut;

/**
 *
 * @author Victor Huerta
 */
public class Estudiante extends Persona {
    
    private int añoActual;
    private int añosCarrera;

    public Estudiante(int añoActual, int añosCarrera, int codigo, String nomhre, String apellido, int edad, String estudio) {
        super(codigo, nomhre, apellido, edad, estudio);
        this.añoActual = añoActual;
        this.añosCarrera = añosCarrera;
    }

    public int getAñoActual() {
        return añoActual;
    }

    public void setAñoActual(int añoActual) {
        this.añoActual = añoActual;
    }

    public int getAñosCarrera() {
        return añosCarrera;
    }

    public void setAñosCarrera(int añosCarrera) {
        this.añosCarrera = añosCarrera;
    }

    @Override
    public boolean calcular(Double monto) {
        if((añoActual/añosCarrera)< 0.5 && monto < (20*26600)) {
            return true;
        }else if((añoActual/añosCarrera) >= 0.5 && monto < (40*26600)) {
            return true;
        }else {
            return false;
        }
        
    }
    
    
    
}
