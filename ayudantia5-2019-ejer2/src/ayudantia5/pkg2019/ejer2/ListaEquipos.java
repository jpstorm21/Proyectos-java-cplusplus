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
public class ListaEquipos {
    private Equipo [] listaEquipos;
    private int cant;
    private int max;

    public ListaEquipos(int max) {
        this.listaEquipos = new Equipo[max];
        this.cant = 0;
        this.max = max;
    }

    public Equipo getEquipo(int i) {
        return listaEquipos[i];
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
    
    public boolean insertEquipo(Equipo E){
        if(cant < max){
            listaEquipos[cant] = E;
            cant++;
            return true;
        }else{
            return false;
        }
    }
    
    public Equipo buscarEquipo(String nombre){
        int i;
        for(i = 0;i<cant;i++){
          if(listaEquipos[i].getNombre().equalsIgnoreCase(nombre)){
              break;
          }
        }
        if(cant == i){
            return null;
        }else{
            return listaEquipos[i];
        }
    }
}

