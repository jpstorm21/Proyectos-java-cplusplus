/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia4.pkg2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaPersonas {
    private int cant;
    private int max;
    private Persona [] listaPersonas;

    public ListaPersonas(int max) {
        this.cant = 0;
        this.max = max;
        this.listaPersonas = new Persona[max];
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

    public Persona getPersona(int i) {
        return listaPersonas[i];
    }

    public void setListaPersonas(Persona[] listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public boolean ingresarPersona(Persona P){
        if(cant < max){
            listaPersonas[cant] = P;
            cant++;
            return true;
        }else{
            return false;
        }
    }
    
    public Persona buscarPersona(String rut){
        int i; 
        for(i=0;i<cant;i++){
            if(listaPersonas[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if(i == cant){
            return null;
        }else{
            return listaPersonas[i];
        }
    }
}
