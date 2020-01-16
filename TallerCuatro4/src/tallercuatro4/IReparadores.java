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
public interface IReparadores {

    public void IngresarPersona(Persona P);

    public void IngresarMaterial(Material M);

    public void IngresarOrdServicios(Servicio S);

    public void IngresarSolicitudMaterial(SolicitudMaterial Sol);

    public void IngresarCertificacion(Certificacion cer);

    public void IngresarHistoricoCertificado(HistoricoCertificado historicoCertificado);

    public Persona BuscarPerona(String rut);

    public Material BuscarMaterial(int cod);

    public Servicio BuscarOrdServicio(int codServ);

    public SolicitudMaterial BuscarSolicitudMaterial(int codSol);

    public Certificacion BuscarCertificacion(int codCer);

    public HistoricoCertificado BuscarHistorico(String fecha, String rut);

    public ListaMateriales MaterialesTodosServicios();

    public ListaMateriales MaterialesNingunServicio();

    public ListaOrdServicios servicioUnTrabajadorServicio_Organizacion();

    public ListaSolicitudMateriales Materiales3al10();

    public TrabajadorServicio TrabajadorConMasServicios();
}
