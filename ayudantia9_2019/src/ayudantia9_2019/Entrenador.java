/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia9_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Entrenador {

    private String nickname;
    private String nombreReal;
    private int IDentrenador;
    private String sexoEntrenador;
    private String correo;
    private ListaPokemones lp;

    public Entrenador(String nickname, String nombreReal, int IDentrenador, String sexoEntrenador, String correo) {
        this.nickname = nickname;
        this.nombreReal = nombreReal;
        this.IDentrenador = IDentrenador;
        this.sexoEntrenador = sexoEntrenador;
        this.correo = correo;
        lp = new ListaPokemones();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public int getIDentrenador() {
        return IDentrenador;
    }

    public void setIDentrenador(int IDentrenador) {
        this.IDentrenador = IDentrenador;
    }

    public String getSexoEntrenador() {
        return sexoEntrenador;
    }

    public void setSexoEntrenador(String sexoEntrenador) {
        this.sexoEntrenador = sexoEntrenador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ListaPokemones getLp() {
        return lp;
    }

    public void setLp(ListaPokemones lp) {
        this.lp = lp;
    }

}
