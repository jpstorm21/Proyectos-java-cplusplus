/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;

/**
 *
 * @author Usuario
 */
public class ListaPropiedades {
    private Propiedad [] lp;
    private int max;
    private int cantidadPropiedades;
    
    public ListaPropiedades(int max){
        this.max = max;
        cantidadPropiedades = 0;
        lp = new Propiedad[max];
    }
    
    public Propiedad getPropiedad(int i){
        return lp[i];
    }
    
    public int getMax(){
        return max;
    }
    
    public int getCantidadPropiedades(){
        return cantidadPropiedades;
    }
    
    public boolean ingresarPropiedad(Propiedad P){
        if(cantidadPropiedades >= max){
            return false;
            
        }else{
            lp[cantidadPropiedades] = P;
            cantidadPropiedades++;
            return true;
        }
    }
    
    public Propiedad buscarPropiedad(String nombre){
        int i = 0;
        for(i = 0; i < cantidadPropiedades; i++){
            if(lp[i].getNombre().equalsIgnoreCase(nombre)){
                break;                
            }
        }
        if(i == cantidadPropiedades){
            return null;
        }else{
            return lp[i];
        }
        
    }
    
    
}
