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
public class SolicitudMaterial {
    private int codSolicitud;
    private String fechaSolicitud;
    private String horaSolicitud;
    private Trabajador jefeAdmin;
    private Trabajador jefeFinanza;
    private ListaMateriales materiales;
    private TrabajadorServicio trabajador;
    private int cantpedida;
    public SolicitudMaterial(int codSolicitud, String fechaSolicitud, String horaSolicitud) {
        this.codSolicitud = codSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.horaSolicitud = horaSolicitud;
        this.jefeAdmin=null;
        this.jefeFinanza=null;
        this.materiales= new ListaMateriales();
        this.trabajador=null;
        this.cantpedida = cantpedida;
    }

    public int getCantpedida() {
        return cantpedida;
    }

    public void setCantpedida(int cantpedida) {
        this.cantpedida = cantpedida;
    }

    public int getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(int codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public Trabajador getJefeAdmin() {
        return jefeAdmin;
    }

    public void setJefeAdmin(Trabajador jefeAdmin) {
        this.jefeAdmin = jefeAdmin;
    }

    public Trabajador getJefeFinanza() {
        return jefeFinanza;
    }

    public void setJefeFinanza(Trabajador jefeFinanza) {
        this.jefeFinanza = jefeFinanza;
    }

    public ListaMateriales getMateriales() {
        return materiales;
    }

    public void setMateriales(ListaMateriales materiales) {
        this.materiales = materiales;
    }

    public TrabajadorServicio getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorServicio trabajador) {
        this.trabajador = trabajador;
    }
    
}
