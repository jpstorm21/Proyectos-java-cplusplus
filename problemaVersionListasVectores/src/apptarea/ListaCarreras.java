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
public class ListaCarreras{
    private int max;
    private int cantCarreras;
    private Carrera [] lc;
    public ListaCarreras(int max){
        this.max =max;
        cantCarreras =0;
        lc = new Carrera[max];
    }
    public int getMax(){
        return max;
    }
    public void setMax(int max){
        this.max =max;
    }

    public int getCantCarreras() {
        return cantCarreras;
    }

    public void setCantCarreras(int cantCarreras) {
        this.cantCarreras = cantCarreras;
    }

    public Carrera getCarrera(int i) {
        return lc[i];
    }

    public void setLc(Carrera[] lc) {
        this.lc = lc;
    }
    public boolean ingresarCarrera(Carrera C){
        if(cantCarreras<max){
            lc[cantCarreras]=C;
            cantCarreras++;
            return true;
        }else{
            return false;
        }
    }
    public Carrera buscarCarrea(int codigo){
        int i;
        for(i=0;i<cantCarreras;i++){
            if(lc[i].getCodigo() == codigo){
                break;
            }
        }
        if(i==cantCarreras){
            return null;
        }else{
            return lc[i];
        }
    }
    
    
}
