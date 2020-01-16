/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2cristobal;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private int edad;
    private String comuna;
    private String ocupacion;
    private int familia;
    private String censista;

    public Persona(String nombre, int edad, String comuna, String ocupacion, int familia, String censista) {
        this.nombre = nombre;
        this.edad = edad;
        this.comuna = comuna;
        this.ocupacion = ocupacion;
        this.familia = familia;
        this.censista = censista;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public String getCensista() {
        return censista;
    }

    public void setCensista(String censista) {
        this.censista = censista;
    }

    
}
