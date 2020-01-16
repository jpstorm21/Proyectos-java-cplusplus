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
public class ListaClientes {
    private int max;
    private int cant;
    private Cliente [] lc;

    public ListaClientes(int max) {
        this.max = max;
        this.cant = 0;
        this.lc = new Cliente[max];
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

    public Cliente getCliente(int i) {
        return lc[i];
    }

    public void setLc(Cliente[] lc) {
        this.lc = lc;
    }
    public boolean ingresar(Cliente C){
        if(cant>=max){
            return false;
        }else{
            lc[cant]=C;
            cant++;
            return true;
        }
    }
    public Cliente buscarCliente(String rut){
        int i;
        for(i = 0;i<cant;i++){
            if(lc[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return lc[i];
        }
    }
    
    
}
