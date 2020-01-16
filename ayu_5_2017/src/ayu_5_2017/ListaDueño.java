/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_5_2017;

/**
 *
 * @author Eduardo
 */
public class ListaDueño {
    private int max;
    private int cantDueños;
    private Dueño [] ld;
    
    public ListaDueño(int max) {
        this.max = max;
        this.cantDueños = 0;
        this.ld = new Dueño[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantDueños() {
        return cantDueños;
    }

    public void setCantDueños(int cantDueños) {
        this.cantDueños = cantDueños;
    }
    public Dueño getDueño(int i) {
        return ld[i];
    }
    public boolean ingresarDueño(Dueño D) {
        if( cantDueños < max) {
            ld[cantDueños] = D;
            cantDueños++;
            return true;
        } else {
            return false;
        }
    }
    public Dueño buscarDueño(String nom) {
        int i=0;
        for(i=0; i<this.cantDueños ; i++) {
            if( ld[i].getNomDueño().equalsIgnoreCase(nom)) {
                break;
            }
        }
        if( i== cantDueños) {
            return null;
        } else {
            return ld[i];
        }
    }
}
