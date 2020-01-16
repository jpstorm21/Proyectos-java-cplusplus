/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2sgosmestre;

/**
 *
 * @author ACER
 */
public class ListaLibros {
    private int max;
    private int cant;
    private Libro [] lb;

    public ListaLibros(int max) {
        this.max = max;
        this.cant = 0;
        this.lb = new Libro[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Libro getLibro(int i ) {
        return lb[i];
    }

    public void setLb(Libro[] lb) {
        this.lb = lb;
    }
    public boolean ingresar(Libro L){
        if(cant>=max){
            return false;
        }else{
            lb[cant]=L;
            cant++;
            return true;
        }
    }
    public Libro buscarLibro(String identificacion){
        int i;
        for(i = 0;i<cant;i++){
            if(lb[i].getIdentificador().equalsIgnoreCase(identificacion)){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return lb[i];
        }
    }
    
}
