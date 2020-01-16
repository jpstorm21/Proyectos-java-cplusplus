/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptarea;

/**
 *
 * @author Victor Huerta
 */
public class ListaProfesores {
    private Profesor [] lpr;
    private int cantProfesores;
    private int max;

    public ListaProfesores(int max) {
        this.max = max;
        cantProfesores=0;
        lpr = new Profesor[max];
    }

    public Profesor getProfesor(int i) {
        return lpr[i];
    }

    public int getCantProfesores() {
        return cantProfesores;
    }

    public int getMax() {
        return max;
    }
    
    public boolean ingresarProfesor(Profesor PF) {
        if(cantProfesores >= max) {
            return false;
        }else{
            lpr[cantProfesores] = PF;
            cantProfesores++;
            return true;
        }
    }
    
    public Profesor buscarProfesor(String rut) {
        int i=0;
        for(i = 0; i<cantProfesores; i++) {
            if(lpr[i].getRut().equalsIgnoreCase(rut)) {
                break;
            }
        }
        if(i==cantProfesores) {
            return null;
        }else{
            return lpr[i];
        }
    }
    public boolean eliminarProfesor(Profesor P){
        int i;
        for(i = 0;i<cantProfesores;i++){
            if(lpr[i] == P){
                break;
            }
        }
        if(i == cantProfesores){
            return false;
        }else{
            for(int j=0;j<cantProfesores;j++){
                lpr[j]= lpr[j+1];
            }
            cantProfesores--;
            return true;
        }
    }
    
    
    
}

