/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia7_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Gato extends Mascota {
    private int years;

    public Gato(int years, String nombre, int peso) {
        super(nombre, peso);
        this.years = years;
    }

    @Override
    public int calcularAlimento() {
        int cant = years *100;
        return cant;
    }
    
}
