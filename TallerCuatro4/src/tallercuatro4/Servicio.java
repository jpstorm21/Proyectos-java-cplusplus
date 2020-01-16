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
public class Servicio {
    private int codServicio;
    private String fechaServicio;
    private String horaServicio;
    private Cliente cliente;
    private TrabajadorServicio trabajador1;
    private TrabajadorServicio trabajador2;
    private Certificacion certificacion;
    private ListaMateriales materiales;
    private int materialUsado;
    public Servicio(int codServicio, String fechaServicio, String horaServicio) {
        this.codServicio = codServicio;
        this.fechaServicio = fechaServicio;
        this.horaServicio = horaServicio;
        cliente=null;
        trabajador1=null;
        trabajador2=null;
        certificacion=null;
        materiales = new ListaMateriales();
        this.materialUsado = materialUsado;
    }

    public int getMaterialUsado() {
        return materialUsado;
    }

    public void setMaterialUsado(int materialUsado) {
        this.materialUsado = materialUsado;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getHoraServicio() {
        return horaServicio;
    }

    public void setHoraServicio(String horaServicio) {
        this.horaServicio = horaServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TrabajadorServicio getTrabajador1() {
        return trabajador1;
    }

    public void setTrabajador1(TrabajadorServicio trabajador1) {
        this.trabajador1 = trabajador1;
    }

    public TrabajadorServicio getTrabajador2() {
        return trabajador2;
    }

    public void setTrabajador2(TrabajadorServicio trabajador2) {
        this.trabajador2 = trabajador2;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    public ListaMateriales getMateriales() {
        return materiales;
    }

    public void setMateriales(ListaMateriales materiales) {
        this.materiales = materiales;
    }
    
}
