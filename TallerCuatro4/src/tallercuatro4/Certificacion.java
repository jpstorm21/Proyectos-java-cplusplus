/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class Certificacion {
    private int codCertificacion;
    private String tipoServicio;
    static int pjeTotal;
    static int  pjAprobacionMin;
    static int duracion;

    public Certificacion(int codCertificacion, String tipoServicio) {
        this.codCertificacion = codCertificacion;
        this.tipoServicio = tipoServicio;
    }

    public int getCodCertificacion() {
        return codCertificacion;
    }

    public void setCodCertificacion(int codCertificacion) {
        this.codCertificacion = codCertificacion;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public static int getPjeTotal() {
        return pjeTotal;
    }

    public static void setPjeTotal(int pjeTotal) {
        Certificacion.pjeTotal = pjeTotal;
    }

    public static int getPjAprobacionMin() {
        return pjAprobacionMin;
    }

    public static void setPjAprobacionMin(int pjAprobacionMin) {
        Certificacion.pjAprobacionMin = pjAprobacionMin;
    }

    public static int getDuracion() {
        return duracion;
    }

    public static void setDuracion(int duracion) {
        Certificacion.duracion = duracion;
    }

    
    
    
}
