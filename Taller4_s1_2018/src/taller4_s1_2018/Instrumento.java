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
public abstract class Instrumento implements Comparable<Instrumento> {

    private String idIntrumento;
    private boolean disponible;
    private String marca;

    public Instrumento(String idIntrumento, boolean disponible, String marca) {
        this.idIntrumento = idIntrumento;
        this.disponible = disponible;
        this.marca = marca;
    }

    public String getIdIntrumento() {
        return idIntrumento;
    }

    public void setIdIntrumento(String idIntrumento) {
        this.idIntrumento = idIntrumento;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Instrumento{" + "idIntrumento=" + idIntrumento + ", disponible=" + disponible + ", marca=" + marca + '}';
    }

    @Override
    public int compareTo(Instrumento i) {
        return getIdIntrumento().compareTo(i.idIntrumento);
    }
}
