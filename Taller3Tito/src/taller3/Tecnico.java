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
public class Tecnico extends Persona {
    
    private int sueldoMes;
    private int gastoMes;

    public Tecnico(int sueldoMes, int gastoMes, int codigo, String nomhre, String apellido, int edad,String estudio) {
        super(codigo, nomhre, apellido, edad, estudio);
        this.sueldoMes = sueldoMes;
        this.gastoMes = gastoMes;
    }

    public int getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(int sueldoMes) {
        this.sueldoMes = sueldoMes;
    }

    public int getGastoMes() {
        return gastoMes;
    }

    public void setGastoMes(int gastoMes) {
        this.gastoMes = gastoMes;
    }

    @Override
    public boolean calcular(Double monto) {
        if((sueldoMes - gastoMes) < (monto*0.15)) {
            return false;
    }else {
            return true;
        }

    }
}
