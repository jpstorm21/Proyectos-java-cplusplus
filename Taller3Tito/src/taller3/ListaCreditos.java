/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author Victor Huerta
 */
public class ListaCreditos {
    private int max;
    private int cantCreditos;
    private Credito[] lc;

    public ListaCreditos(int max) {
        this.max = max;
        cantCreditos=0;
        lc = new Credito[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public Credito getCredito(int i) {
        return lc[i];
    }
    
    public boolean ingresarCredito(Credito C) {
        if(cantCreditos <= max) {
            lc[cantCreditos] = C;
            cantCreditos++;
            return true;
        }else{
            return false;
        }
    }
    
    public Credito buscarCredito(int codigo) {
        int i;
        for(i =0; i<cantCreditos;i++) {
            if(lc[i].getCodigo()== codigo) {
                break;
            }
        }
        if(i==cantCreditos) {
            return null;
        }else{
            return lc[i];
        }
    }
    public boolean eliminarPersona(Credito C) {
        int i;
        for(i = 0; i < cantCreditos; i++) {
            if(lc[i] == C){
                break;
            }
        }
        if(i==cantCreditos) {
            return false;
        }else{
            for(int j=0; j<cantCreditos; j++){
                lc[j]=lc[j+1];
            }
           cantCreditos--;
            return true;
        }
    }
    
    
}
