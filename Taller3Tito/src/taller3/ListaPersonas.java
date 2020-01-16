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
    
    public boolean ingresarPersona(Persona P) {
        if(cantPersonas<=max) {
            lp[cantPersonas]=P;
            cantPersonas++;
            return true;
        }else{
            return false;
        }
    }
    
    public Persona buscarPersona(int codigo) {
        int i;
        for(i =0; i<cantPersonas;i++) {
            if(lp[i].getCodigo()== codigo) {
                break;
            }
        }
        if(i==cantPersonas) {
            return null;
        }else{
            return lp[i];
        }
    }
    
    public boolean eliminarPersona(Persona P) {
        int i;
        for(i = 0; i < cantPersonas; i++) {
            if(lp[i] == P){
                break;
            }
        }
        if(i==cantPersonas) {
            return false;
        }else{
            for(int j=0; j<cantPersonas; j++){
                lp[j]=lp[j+1];
            }
            cantPersonas--;
            return true;
        }
    }
    public void ordenar(){
        for (int i = 0; i <= lp.length; i++) {
            for (int j = 0; j <= lp.length-i; j++) {
                if (lp[j].getApellido().compareTo(lp[j+1].getApellido())>0){
                    String aux = lp[j].getApellido();
                    String P = lp[j+1].getApellido();
                    String P2 = lp[j].getApellido();
                    P2 = P;
                    P = aux;
                }
            }
        }
    }
    
    
    
}
