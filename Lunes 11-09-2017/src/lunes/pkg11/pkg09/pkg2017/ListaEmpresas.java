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
public class ListaEmpresas {
    private int max;
    private int cantidadEmpresas;
    private Empresa[]le;

    public ListaEmpresas(int max) {
        this.max = max;
        this.cantidadEmpresas = 0;
        le = new Empresa[max];
        
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantidadEmpresas() {
        return cantidadEmpresas;
    }

    public void setCantidadEmpresas(int cantidadEmpresas) {
        this.cantidadEmpresas = cantidadEmpresas;
    }

    public Empresa getEmpresa(int i) {
        return le[i];
    }

    public void setLe(Empresa[] le) {
        this.le = le;
    }
    
    public boolean ingresarEmpresa(Empresa E){
        if(cantidadEmpresas > max){
            return false;
        }else{
            le[cantidadEmpresas] = E;
            cantidadEmpresas++;
            return true;
        }
    }
            
    public Empresa buscarEmpresa(String codigo){
        int i = 0;
        for(i = 0; i < cantidadEmpresas; i++){
            if(le[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
        }
        
        if(i == cantidadEmpresas){
            return null;
        }else{
            return le[i];
        }
        
    }    
        
    

    
    
    
    
}
