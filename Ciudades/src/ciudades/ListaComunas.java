/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;


public class ListaComunas {
    private Comuna [] lc;
    private int cantidadComunas;
    private int max;

    public ListaComunas(int max) {
        this.max = max;
        this.cantidadComunas = 0;
        lc = new Comuna[max];
    }

    public Comuna getComuna(int i) {
        return lc[i];
    }

    public void setLc(Comuna[] lc) {
        this.lc = lc;
    }

    public int getCantidadComunas() {
        return cantidadComunas;
    }

    public void setCantidadComunas(int cantidadComunas) {
        this.cantidadComunas = cantidadComunas;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public boolean ingresarComuna(Comuna C){
        if(cantidadComunas >= max){
            return false;
        }else{
            lc[cantidadComunas] = C;
            cantidadComunas++;
            return true;
        }
    }
    
    public Comuna buscarComuna(String codigo){
        int i = 0;
        for(i = 0; i < cantidadComunas; i++){
            if(lc[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
        }
        if(i == cantidadComunas){
            return null;
        }else{
            return lc[i];
        }
    }
    
}
