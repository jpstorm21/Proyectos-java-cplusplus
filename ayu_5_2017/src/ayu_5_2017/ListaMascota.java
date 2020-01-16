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
public class ListaMascota {
    private int max;
    private int cantMascotas;
    private Mascota [] lm;
    
    public ListaMascota(int max) {
        this.max=max;
        this.cantMascotas =0;
        this.lm = new Mascota[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantMascotas() {
        return cantMascotas;
    }

    public void setCantMascotas(int cantMascotas) {
        this.cantMascotas = cantMascotas;
    }
    public Mascota getMascota(int i) {
        return lm[i];
    }
    public boolean ingresarMascota(Mascota M) {
        if(cantMascotas < max) {
            lm[cantMascotas] = M;
            cantMascotas++;
            return true;
        } else {
            return false;
        }
    }
}
