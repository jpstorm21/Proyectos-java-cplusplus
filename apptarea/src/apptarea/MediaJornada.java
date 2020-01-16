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
public class MediaJornada extends Profesor {
    private int grado;

    public MediaJornada(int grado, String rut, String nombre) {
        super(rut, nombre);
        this.grado = grado;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }
    
    public int calcularSueldo(){
        int sueldo = 0;
        if(grado == 1){
            sueldo = grado * 300000;
        }else if(grado == 2){
            sueldo = grado * 300000;
        }else{
            sueldo = grado * 300000;
        }
        return(sueldo);
    }
    
}
