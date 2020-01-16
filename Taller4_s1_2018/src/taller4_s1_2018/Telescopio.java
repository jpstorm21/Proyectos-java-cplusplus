/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Telescopio extends Instrumento{
    private String tipo;
    private String montura;

    public Telescopio(String tipo, String montura, String idIntrumento, boolean disponible, String marca) {
        super(idIntrumento, disponible, marca);
        this.tipo = tipo;
        this.montura = montura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontura() {
        return montura;
    }

    public void setMontura(String montura) {
        this.montura = montura;
    }

    @Override
    public String toString() {
        return "Telescopio{" + "tipo=" + tipo + ", montura=" + montura + '}';
    }
    
}
