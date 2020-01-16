/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

import java.io.FileNotFoundException;

/**
 *
 * @author Usuario
 */
public interface Interface {
    public void leerPersonas()throws FileNotFoundException;
    public void leerCreditos()throws FileNotFoundException;
    public void ingresarPersona(Persona P);
    public void ingresarCredito(Credito C);
    public Persona buscarPersona(int codigo);
    public Credito buscarCredito(int codigo);
    public void eliminarPersona(Persona P);
    public void eliminarCredito(Credito C);
    public void RF1();
    public void RF2();
    public void RF3();
    public void RF4();
    public void RF5();
    public void RF6();
    public void RF7();
    public void menu();
    public void ordenarPersonas();
    public void ordenarCreditos();
    
}
