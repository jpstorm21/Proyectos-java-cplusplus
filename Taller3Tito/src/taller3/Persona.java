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
public abstract class Persona {
    private int codigo;
    private String nomhre;
    private String apellido;
    private int edad;
    private String estudio;
    private ListaCreditos lc;

    protected Persona(int codigo, String nomhre, String apellido, int edad, String estudio) {
        this.codigo = codigo;
        this.nomhre = nomhre;
        this.apellido = apellido;
        this.edad = edad;
        this.estudio = estudio;
        lc = new ListaCreditos(10);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomhre() {
        return nomhre;
    }

    public void setNomhre(String nomhre) {
        this.nomhre = nomhre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public ListaCreditos getLc() {
        return lc;
    }

    public void setLc(ListaCreditos lc) {
        this.lc = lc;
    }
    
    public abstract boolean calcular(Double monto);
    
}