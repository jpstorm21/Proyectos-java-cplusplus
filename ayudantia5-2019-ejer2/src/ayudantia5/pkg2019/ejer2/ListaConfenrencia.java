/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia5.pkg2019.ejer2;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaConfenrencia {
    private int cant;
    private int max;
    private conferencia [] listaConferencias;

    public ListaConfenrencia(int max) {
        this.cant = 0;
        this.max = max;
        this.listaConferencias = new conferencia[max];
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

    public conferencia getConferencia(int i) {
        return listaConferencias[i];
    }

    public boolean insertConferencia(conferencia c){
        if(cant < max){
            listaConferencias[cant] = c;
            cant++;
            return true;
        }else{
            return false;
        }
    }
    
    public conferencia buscarConferencia(String nombre){
        int i;
        for(i = 0;i<cant;i++){
          if(listaConferencias[i].getNombre().equalsIgnoreCase(nombre)){
              break;
          }
        }
        if(cant == i){
            return null;
        }else{
            return listaConferencias[i];
        }
    }
    
}
