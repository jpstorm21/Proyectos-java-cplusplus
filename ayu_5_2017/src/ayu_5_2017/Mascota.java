/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_5_2017;

/**
 *
 * @author Eduardo
 */
abstract public class Mascota {
    protected String apodo;
    protected int edad;
    protected Dueño refDueño;
    
    protected Mascota(String apodo, int edad) {
        this.apodo = apodo;
        this.edad = edad;
        refDueño = null;
    }
    public void setRefDueño(Dueño D) {
        refDueño = D;
    }
    public Dueño getRefDueño() {
        return this.refDueño;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
