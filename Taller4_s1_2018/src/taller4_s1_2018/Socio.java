/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Socio {
    private String rut;
    private String password;
    private String nombreCompleto;
    private int cuotaMensual;
    private boolean administradir;
    private ListaPrestamos  lp;
    
    public Socio(String rut, String password, String nombreCompleto, int cuotaMensual, boolean administradir) {
        this.rut = rut;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.cuotaMensual = cuotaMensual;
        this.administradir = administradir;
        this.lp =  new ListaPrestamos();
    }

    public ListaPrestamos getLp() {
        return lp;
    }

    public void setLp(ListaPrestamos lp) {
        this.lp = lp;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(int cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public boolean isAdministradir() {
        return administradir;
    }

    public void setAdministradir(boolean administradir) {
        this.administradir = administradir;
    }

    @Override
    public String toString() {
        return "Socio{" + "rut=" + rut + ", password=" + password + ", nombreCompleto=" + nombreCompleto + ", cuotaMensual=" + cuotaMensual + ", administradir=" + administradir + '}';
    }
    
}
