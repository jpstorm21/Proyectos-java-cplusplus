/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaversion2nexos;

/**
 *
 * @author Usuario
 */
public class Hora extends Profesor{
    private int canthoras;
    private int valorhora;

    public Hora(int canthoras, int valorhora, String rut, String nombre) {
        super(rut, nombre);
        this.canthoras = canthoras;
        this.valorhora = valorhora;
    }

    public int getCanthoras() {
        return canthoras;
    }

    public void setCanthoras(int canthoras) {
        this.canthoras = canthoras;
    }

    public int getValorhora() {
        return valorhora;
    }

    public void setValorhora(int valorhora) {
        this.valorhora = valorhora;
    }
    public int calcularSueldo(){
        int sueldo =0;
        sueldo = valorhora*canthoras;
        return sueldo;
    }
}
