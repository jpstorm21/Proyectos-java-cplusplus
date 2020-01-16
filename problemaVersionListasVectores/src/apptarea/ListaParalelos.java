/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptarea;

/**
 *
 * @author Victor Huerta
 */
public class ListaParalelos {
    private Paralelo [] lp;
    private int cantParalelos;
    private int max;

    public ListaParalelos(int max) {
        this.max = max;
        cantParalelos=0;
        lp = new Paralelo[max];
    }

    public Paralelo getParalelo(int i) {
        return lp[i];
    }

    public int getCantParalelos() {
        return cantParalelos;
    }

    public int getMax() {
        return max;
    }
    
    public boolean ingresarParalelo(Paralelo P) {
        if(cantParalelos >= max) {
            return false;
        }else{
            lp[cantParalelos] = P;
            cantParalelos++;
            return true;
        }
    }
    
    public Paralelo buscarParalelo(int numero) {
        int i=0;
        for(i = 0; i<cantParalelos; i++) {
            if(lp[i].getNumero()==numero) {
                break;

            }
        }
        if(i==cantParalelos) {
            return null;
        }else{
            return lp[i];
        }
    }
    
    
    
}