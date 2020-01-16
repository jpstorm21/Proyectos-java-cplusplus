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
public class ListaComunas {
    private int max;
    private int cantComunas;
    private Comuna [] lcm;

    public ListaComunas(int max) {
        this.max = max;
        cantComunas =0;
        lcm = new Comuna[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantComunas() {
        return cantComunas;
    }

    public Comuna getComuna(int i) {
        return lcm[i];
    }
    
    public boolean ingresarComuna(Comuna CM){
        if(cantComunas>= max) {
            return false;
        }else{
            lcm[cantComunas]=CM;
            cantComunas++;
            return true;
        }
    }
    
    public Comuna buscarComunaXnombre(String nombre){
        int i=0;
        for(i = 0; i<cantComunas; i++) {
            if(lcm[i].getNombre().equalsIgnoreCase(nombre)) {
                break;
            }
        }
        if(i==cantComunas) {
            return null;
        }else{
            return lcm[i];
        }
    }
    public Comuna buscarComunaXcodigo(int codigo){
        int i=0;
        for(i = 0; i<cantComunas; i++) {
            if(lcm[i].getCodigo() == codigo) {
                break;
            }
        }
        if(i==cantComunas) {
            return null;
        }else{
            return lcm[i];
        }
    }       
}
