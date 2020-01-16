/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

/**
 *
 * @author Victor Huerta
 */
public class Usuario {
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correoE;
    private String contraseña;
    private String fechaNac;
    private char sexo;
    private ListaUsuarios lu;
    private ListaPaginasGrupos lpg;


    public Usuario(String nombre1, String nombre2, String apellido1, String apellido2, String correoE, String contraseña, String fechaNac, char sexo) {
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.correoE = correoE;
        this.contraseña = contraseña;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        lu = new ListaUsuarios(1000);
        lpg = new ListaPaginasGrupos(1000);
        
        
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public ListaUsuarios getLu() {
        return lu;
    }

    public void setLu(ListaUsuarios lu) {
        this.lu = lu;
    }

    public ListaPaginasGrupos getLpg() {
        return lpg;
    }

    public void setLpg(ListaPaginasGrupos lpg) {
        this.lpg = lpg;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public int calcularPuntaje(){
        return 0;
    }

    
}
