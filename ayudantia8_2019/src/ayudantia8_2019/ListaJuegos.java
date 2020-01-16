/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia8_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaJuegos {
    private int cant;
    private int max;
    private Juego [] lj;

    public ListaJuegos(int max) {
        this.cant = 0;
        this.max = max;
        this.lj = new Juego[max];
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

    public Juego getJuego(int i) {
        return lj[i];
    }

    public void setLj(Juego[] lj) {
        this.lj = lj;
    }
    
    public boolean ingresarJuego(Juego j){
        if(cant < max){
            lj[cant] =j;
            cant++;
            return true;
        }else{
            return false;
        }
    }
    
    public Juego buscarJuego(String nombre){
        int i;
        for(i = 0;i<cant;i++){
            if(lj[i].getNombre().equalsIgnoreCase(nombre)){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return lj[i];
        }
    }
    
}
