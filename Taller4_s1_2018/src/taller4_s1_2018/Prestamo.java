/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

import java.util.Date;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Prestamo {

    private String idprestamo;
    private Date fechaSolicitud;
    private String estado;
    private Instrumento instrumento;
    private Socio socio;
    
    public Prestamo(String idprestamo, Date fechaSolicitud, String estado) {
        this.idprestamo = idprestamo;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idprestamo=" + idprestamo + ", fechaSolicitud=" + fechaSolicitud.toString() + ", estado=" + estado + ", instrumento=" + instrumento.getIdIntrumento() + ", socio=" + socio.getNombreCompleto() + '}';
    }

    public String getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(String idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

}
