/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

import java.io.FileNotFoundException;

/**
 *
 * @author Usuario
 */

public interface Interface {
    public void leerPersonas()throws FileNotFoundException;
    public void leerAsignatuas()throws FileNotFoundException;
    public void leerInscripciones()throws FileNotFoundException;
    public void ingresarPersona(Persona P);
    public void ingresarMensaje(Mensaje M);
    public void ingresarAsignatura(Asignatura A);
    public Persona buscarPersonaXrut(String rut);
    public Persona buscarPersonaXalias(String alias);
    public Asignatura buscarAsignatura(String codigo);
    public boolean validarRut(String RUT);
    public boolean validarCorreo(String correo);
    public boolean validarCodigo(String codigo);
    public String sacarAlias(String correo);
    public boolean validarMensaje(String texto);
    public boolean EsNumerico(String cadena);
    public void menu() throws FileNotFoundException;
    public void RF1();
    public void RF2();
    public void RF3();
    public void RF4() throws FileNotFoundException;
    public void RF5();
    public void RF6();
}
