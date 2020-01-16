/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author Victor Huerta
 */
public class Credito {
    private int codigo;
    private Double monto;
    private Double tasa;
    private Double cuotaMensual;
    private Double cantCuotas;
    private String estado;
    private Persona refPersona;

    public Credito(int codigo, Double monto, Double tasa, Double cuotaMensual, Double cantCuotas) {
        this.codigo = codigo;
        this.monto = monto;
        this.tasa = tasa;
        this.cuotaMensual =cuotaMensual;
        this.cantCuotas = cantCuotas;
        estado = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(Double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public Double getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(Double cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getRefPersona() {
        return refPersona;
    }

    public void setRefPersona(Persona refPersona) {
        this.refPersona = refPersona;
    }
    
    
    
    
    
}
