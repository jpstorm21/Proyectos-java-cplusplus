/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes.pkg11.pkg09.pkg2017;

/**
 *
 * @author Usuario
 */
public class Trabajador {
    private String rut;
    private String nombre;
    private int cantFamily;
    private int horas;
    private Empresa empresa;

    public Trabajador(String rut, String nombre, int cantFamily, int horas) {
        this.rut = rut;
        this.nombre = nombre;
        this.cantFamily = cantFamily;
        this.horas = horas;
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantFamily() {
        return cantFamily;
    }

    public void setCantFamily(int cantFamily) {
        this.cantFamily = cantFamily;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    public int calcularBono(){
        int bono = this.horas * this.cantFamily;
        return bono;
    }
 
    

}
