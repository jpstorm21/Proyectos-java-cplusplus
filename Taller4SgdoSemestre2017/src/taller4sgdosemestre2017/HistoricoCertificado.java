/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4sgdosemestre2017;

/**
 *
 * @author Usuario
 */
public class HistoricoCertificado {
    private String fecha;
    private int puntaje;
    private Certificacion certificacion;
    private TrabajadorServicio trabajador;

    public HistoricoCertificado(String fecha, int puntaje) {
        this.fecha = fecha;
        this.puntaje = puntaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    public TrabajadorServicio getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorServicio trabajador) {
        this.trabajador = trabajador;
    }
    
}
