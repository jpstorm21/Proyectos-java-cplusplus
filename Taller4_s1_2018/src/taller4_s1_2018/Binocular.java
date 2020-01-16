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
public class Binocular extends Instrumento{
    private String tipoPrisma;
    private int aumentos;
    private int diametroApertura;

    public Binocular(String tipoPrisma, int aumentos, int diametroApertura, String idIntrumento, boolean disponible, String marca) {
        super(idIntrumento, disponible, marca);
        this.tipoPrisma = tipoPrisma;
        this.aumentos = aumentos;
        this.diametroApertura = diametroApertura;
    }

    public String getTipoPrisma() {
        return tipoPrisma;
    }

    public void setTipoPrisma(String tipoPrisma) {
        this.tipoPrisma = tipoPrisma;
    }

    public int getAumentos() {
        return aumentos;
    }

    public void setAumentos(int aumentos) {
        this.aumentos = aumentos;
    }

    public int getDiametroApertura() {
        return diametroApertura;
    }

    public void setDiametroApertura(int diametroApertura) {
        this.diametroApertura = diametroApertura;
    }

    @Override
    public String toString() {
        return "Binocular{" + "tipoPrisma=" + tipoPrisma + ", aumentos=" + aumentos + ", diametroApertura=" + diametroApertura + '}';
    }
    
}
