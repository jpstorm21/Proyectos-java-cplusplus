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
public class ListaCensistas {
     private int max;
    private int cantCensistas;
    private Censista [] lc;

    public ListaCensistas(int max) {
        this.max = max;
        cantCensistas =0;
        lc = new Censista[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantCensistas() {
        return cantCensistas;
    }

    public Censista getCensista(int i) {
        return lc[i];
    }
    
    public boolean ingresarCensista(Censista C){
        if(cantCensistas>= max) {
            return false;
        }else{
            lc[cantCensistas]=C;
            cantCensistas++;
            return true;
        }
    }
    
    public Censista buscarCensistaXcodigo(int codigo){
        int i=0;
        for(i = 0; i<cantCensistas; i++) {
            if(lc[i].getCodigo() == codigo) {
                break;

            }
        }
        if(i==cantCensistas) {
            return null;
        }else{
            return lc[i];
        }
    }  
    public Censista buscarCensistaXnombre(String nombre){
        int i=0;
        for(i = 0; i<cantCensistas; i++) {
            if(lc[i].getNombre().equalsIgnoreCase(nombre)) {
                break;

            }
        }
        if(i==cantCensistas) {
            return null;
        }else{
            return lc[i];
        }
    }
}
