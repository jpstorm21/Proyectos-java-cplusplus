/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;


public class Dueño {
    
    private String rut;
    private String nombre;
    private ListaPropiedades lp;

    public Dueño(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        lp = new ListaPropiedades(1000);
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

    public ListaPropiedades getLp() {
        return lp;
    }

    public void setLp(ListaPropiedades lp) {
        this.lp = lp;
    }
    
    
    
    
    
    
}
