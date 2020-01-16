/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptarea;

/**
 *

 */
public class ListaAsignaturas {
    
    private Asignatura [] la;
    private int cantAsignaturas;
    private int max;

    public ListaAsignaturas(int max) {
        this.max = max;
        cantAsignaturas=0;
        la = new Asignatura[max];
    }

    public Asignatura getAsignatura(int i) {
        return la[i];
    }

    public int getCantAsignaturas() {
        return cantAsignaturas;
    }

    public int getMax() {
        return max;
    }
    
    public boolean ingresarAsigantura(Asignatura A) {
        if(cantAsignaturas >= max) {
            return false;
        }else{
            la[cantAsignaturas] = A;
            cantAsignaturas++;
            return true;
        }
    }
    
    public Asignatura buscarAsignatura(String codigo) {
        int i=0;
        for(i = 0; i<cantAsignaturas; i++) {
            if(la[i].getCodigo().equalsIgnoreCase(codigo)) {
                break;

            }
        }
        if(i==cantAsignaturas) {
            return null;
        }else{
            return la[i];
        }
    }
    
    
    
}