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
public class Fisico extends Juego{
    
    private boolean estado;

    public Fisico(boolean estado, String nombre, String consola, String tipo) {
        super(nombre, consola, tipo);
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    
}
