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
public class Conejo extends Mascota{
    private double peso;
    
            
    public Conejo(double peso ,String apodo, int edad) {
        super(apodo,edad);
        this.peso = peso;
    }
    
    public double getPeso() {
        return peso;
    }
    
}
