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
public class Perro extends Mascota {
    private int edad;

    public Perro(int edad, String nombre, int peso) {
        super(nombre, peso);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int calcularAlimento() {
        int cant = edad * 200;
        return cant;
    }
    
}
