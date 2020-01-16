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
public class JornadaCompleta extends Profesor {
    private String titulo;
    private String jerarquia;

    public JornadaCompleta(String titulo, String jerarquia, String rut, String nombre) {
        super(rut, nombre);
        this.titulo = titulo;
        this.jerarquia = jerarquia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }
    
    public int calcularSueldo(){
        int sueldo= 0;
        if(jerarquia.equals("instructor")){
              sueldo = 1000000; 
        }else if(jerarquia.equals("asistente")){
            sueldo = 1300000;
        }else if(jerarquia.equals("asociado")){
            sueldo = 1600000;
        }else{
            sueldo = 2000000;
        }
        return(sueldo);
    }
}
