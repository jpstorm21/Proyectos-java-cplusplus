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
public class Gato extends Mascota{
    private int cantHijos;
    private String comidaFav;
    
    public Gato(int cantHijos,String comidaFav , String apodo, int edad) {
        super(apodo,edad);
        this.cantHijos = cantHijos;
        this.comidaFav = comidaFav;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public String getComidaFav() {
        return comidaFav;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }
    
}
