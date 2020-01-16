/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes.pkg11.pkg09.pkg2017;

/**
 *
 * @author Usuario
 */
public class ListaTrabajadores {
    private Trabajador [] lt;
    private int max;
    private int cantidadTrabajadores;

    public ListaTrabajadores(int max) {
        lt = new Trabajador[max];
        this.max = max;
        this.cantidadTrabajadores = 0;
    }

    public Trabajador getTrabajador(int i) {
        return lt[i];
    }

    public void setLt(Trabajador[] lt) {
        this.lt = lt;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantidadTrabajadores() {
        return cantidadTrabajadores;
    }

    public void setCantidadTrabajadores(int cantidadTrabajadores) {
        this.cantidadTrabajadores = cantidadTrabajadores;
    }
    
   public boolean ingresarTrabajador(Trabajador T){
        if(cantidadTrabajadores > max){
            return false;
        }else{
            lt[cantidadTrabajadores] = T;
            cantidadTrabajadores++;
            return true;
        }
    }
            
    public Trabajador buscarTrabajador(String rut){
        int i = 0;
        for(i = 0; i < cantidadTrabajadores; i++){
            if(lt[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        
        if(i == cantidadTrabajadores){
            return null;
        }else{
            return lt[i];
        }
        
    }    
    
}

