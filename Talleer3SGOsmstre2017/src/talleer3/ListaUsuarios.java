/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

/**
 *
 * @author Victor Huerta
 */
public class ListaUsuarios {
    private int max;
    private int cantUsuarios;
    private Usuario [] lu;

    public ListaUsuarios(int max) {
        this.max = max;
        cantUsuarios = 0;
        lu = new Usuario[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
    }

    public Usuario[] getLu() {
        return lu;
    }

    public void setLu(Usuario[] lu) {
        this.lu = lu;
    }
    
    public Usuario getUsuario(int i) {
        return lu[i];
    }
    
    public boolean ingresarUsuario(Usuario U){
        if(cantUsuarios>= max) {
            return false;
        }else{
            lu[cantUsuarios]=U;
            cantUsuarios++;
            return true;
        }
    }
    
    public Usuario buscarUsuario(String correoE){
        int i=0;
        for(i = 0; i<cantUsuarios; i++) {
            if(lu[i].getCorreoE().equalsIgnoreCase(correoE)) {
                break;

            }
        }
        if(i==cantUsuarios) {
            return null;
        }else{
            return lu[i];
        }
    }
    
    public boolean eliminarUsuario(Usuario U) {
        int i;
        for(i = 0; i < cantUsuarios; i++) {
            if(lu[i] == U){
                break;
            }
        }
        if(i==cantUsuarios) {
            return false;
        }else{
            for(int j=0; j<cantUsuarios; j++){
                lu[j]=lu[j+1];
            }
            cantUsuarios--;
            return true;
        }
    }
    
    
}
