/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ListaEntrenadores {
    private int max;
    private Entrenador [] le;
    private int cantEntrenadores;

    public ListaEntrenadores(int max) {
        this.max = max;
        cantEntrenadores =0;
        le = new Entrenador[max];
    }
    public Entrenador getEntrenador(int i) {
        return le[i];
    }

    public int getMax() {
        return max;
    }


    public int getCantEntrenadores() {
        return cantEntrenadores;
    }
    
    public boolean ingresarEntrenador(Entrenador E) {
        if(cantEntrenadores > max) {
            System.out.println("Capacidad excedida");
            return false;
        } else {
            le[cantEntrenadores]=E;
            cantEntrenadores++;
            return true;
        }
    }
    
    public Entrenador buscarEntrenador(String nombre) {
        int i=0;
        for(i=0; i< cantEntrenadores; i++) {
            if(le[i].getNombreReal().equalsIgnoreCase(nombre)) {
                break;
            }
        }
        if(i == cantEntrenadores) {
           return null;
        } else {
            return le[i];
        }
    }
    
    
    
}
