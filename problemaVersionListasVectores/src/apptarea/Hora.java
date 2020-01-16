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
public class Hora extends Profesor {
    private int cantidadHoras;
    private int valorHora;

    public Hora(int cantidadHoras, int valorHora, String rut, String nombre) {
        super(rut, nombre);
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }
    
    public int calcularSueldo(){
        int sueldo =0;
        sueldo = cantidadHoras *valorHora;
        return(sueldo);
    }
    
}
