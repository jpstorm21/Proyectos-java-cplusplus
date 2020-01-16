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
public class ListaPrestamos {
    private int cant;
    private int max;
    private Prestamo [] lp;

    public ListaPrestamos(int max) {
        cant = 0;
        this.max = max;
        this.lp = new Prestamo[max];
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

    public Prestamo getPrestamo(int i) {
        return lp[i];
    }

    public void setLp(Prestamo[] lp) {
        this.lp = lp;
    }
    public boolean ingresar(Prestamo P){
        if(cant>=max){
            return false;
        }else{
            lp[cant]=P;
            cant++;
            return true;
        }
    }
    public Prestamo buscarPrestamo(String codigo){
        int i;
        for(i = 0;i<cant;i++){
            if(lp[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return lp[i];
        }
    }
    
    
}
