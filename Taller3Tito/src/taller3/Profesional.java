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
public class Profesional extends Persona {
    
    private int sueldoMes;
    private int añosTrabajo;

    public Profesional(int sueldoMes, int añosTrabajo, int codigo, String nomhre, String apellido, int edad,String estudio) {
        super(codigo, nomhre, apellido, edad, estudio);
        this.sueldoMes = sueldoMes;
        this.añosTrabajo = añosTrabajo;
    }

    public int getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(int sueldoMes) {
        this.sueldoMes = sueldoMes;
    }

    public int getAñosTrabajo() {
        return añosTrabajo;
    }

    public void setAñosTrabajo(int añosTrabajo) {
        this.añosTrabajo = añosTrabajo;
    }

    @Override
    public boolean calcular(Double monto) {
        if(sueldoMes < (monto*0.20) || añosTrabajo < 2) {
            return false;
    }else{
            return true;
        }
    }
    
    
    
}
