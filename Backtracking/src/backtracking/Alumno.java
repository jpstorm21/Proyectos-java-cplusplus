/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author Usuario
 */
public class Alumno implements Elemento {
    private String rut;
    
    public Alumno(String rut){
        this.rut = rut;
    }
    
    public void setRut(String rut){
        this.rut=rut;
    }
    
    public String getRut(){
        return rut;
    }
    
    public boolean equals(Elemento e){
        return this.rut.equals((((Alumno)e).getRut()));
    }
    
    public int compareTo(Elemento e){
        return 0;
    }
}
