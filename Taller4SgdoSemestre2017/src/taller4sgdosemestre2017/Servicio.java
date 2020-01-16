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
public class Servicio {

    private int codigo;
    private String fecha;
    private String hora;
    private Cliente cliente;
    private TrabajadorServicio trabajador1;
    private TrabajadorServicio trabajador2;
    private Certificacion certificacion;
    private ListaMateriales lm;
    private int cantidadMaterialUsado;

    public Servicio(int codigo, String fecha, String hora) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.lm = new ListaMateriales();
    }

    public int getCantidadMaterialUsado() {
        return cantidadMaterialUsado;
    }

    public void setCantidadMaterialUsado(int cantidadMaterialUsado) {
        this.cantidadMaterialUsado = cantidadMaterialUsado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public ListaMateriales getLm() {
        return lm;
    }

    public void setLm(ListaMateriales lm) {
        this.lm = lm;
    }

}
