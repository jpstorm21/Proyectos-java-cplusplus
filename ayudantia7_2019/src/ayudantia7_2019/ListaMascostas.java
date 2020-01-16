/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia7_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaMascostas {
    private int cant;
    private int max;
    private Mascota [] lm;

    public ListaMascostas(int max) {
        this.cant = 0;
        this.max = max;
        this.lm = new Mascota[max];
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Mascota getLm(int i) {
        return lm[i];
    }

    public void setLm(Mascota[] lm) {
        this.lm = lm;
    }
    
    public boolean ingresarMascota(Mascota m){
        if(cant <= max){
            lm[cant] = m;
            cant++;
            return true;
        }else{
            return false;
        }
    }
}

