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
public interface Ireparadores {
    public void ingresarPersona(Persona P);
    public void ingresarServicio(Servicio s);
    public void ingresarMaterialAServicio(Servicio s,Material M);
    public void ingresarMaterial(Material M);
    public void ingresarCertificacione(Certificacion c);
    public void ingresarSolicitudMaterial(SolicitudMaterial sm);
    public void ingresarMaterialASolicitudMaterial(SolicitudMaterial sm,Material M);
    public void ingresarHistoricoCertificacion(HistoricoCertificado hc);
    public Persona buscarPersona(String rut);
    public Certificacion buscarCertificacion(int codigo);
    public Servicio buscarServicio(int codigo);
    public Material buscarMaterial(int codigo);
    public SolicitudMaterial buscarSolicitudMaterial(int codigo);
    public ListaMateriales MaterialesTodosServicios();
    public ListaMateriales MaterialesNingunServicios();
    public ListaServicios ServicioUnTrabajadorServicio_organizacion();
    public ListaSolicitudMaterial solMateriales();
    public TrabajadorServicio trabajadorConMasServicio();
    public ListaServicios getLs();
    public ListaMateriales getLm();
    public ListaPersonas getLp();
    public ListaSolicitudMaterial getLsm();
}
