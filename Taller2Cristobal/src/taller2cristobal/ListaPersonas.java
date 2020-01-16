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
public class ListaPersonas {
     private int max;
    private int cantPersonas;
    private Persona [] lp;

    public ListaPersonas(int max) {
        this.max = max;
        cantPersonas =0;
        lp = new Persona[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public Persona getPersona(int i) {
        return lp[i];
    }
    
    public boolean ingresarPersona(Persona P){
        if(cantPersonas>= max) {
            return false;
        }else{
            lp[cantPersonas]=P;
            cantPersonas++;
            return true;
        }
    }
}
