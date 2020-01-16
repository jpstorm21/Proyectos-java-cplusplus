/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia8_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Digital extends Juego{
    private int peso;

    public Digital(int peso, String nombre, String consola, String tipo) {
        super(nombre, consola, tipo);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
