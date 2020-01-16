/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TrabajadorServicio extends Trabajador  {
    private ArrayList<Certificacion> certificaciones;
    private ListaOrdServicios servicios;
    private ArrayList<HistoricoCertificado> histcertificaciones;
    private ListaSolicitudMateriales solMateriales;

    public TrabajadorServicio(String rut, String nombres, String apellidos, int edad, int telefono, String mail, String cargo) {
        super(rut, nombres, apellidos, edad, telefono, mail, cargo);
    certificaciones  = new ArrayList();
    servicios= new ListaOrdServicios();
    histcertificaciones= new ArrayList();
    solMateriales= new ListaSolicitudMateriales();
    
    }

    public ArrayList<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(ArrayList<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public ListaOrdServicios getServicios() {
        return servicios;
    }

    public void setServicios(ListaOrdServicios servicios) {
        this.servicios = servicios;
    }

    public ArrayList<HistoricoCertificado> getHistcertificaciones() {
        return histcertificaciones;
    }

    public void setHistcertificaciones(ArrayList<HistoricoCertificado> histcertificaciones) {
        this.histcertificaciones = histcertificaciones;
    }

    public ListaSolicitudMateriales getSolMateriales() {
        return solMateriales;
    }

    public void setSolMateriales(ListaSolicitudMateriales solMateriales) {
        this.solMateriales = solMateriales;
    }
    
}
