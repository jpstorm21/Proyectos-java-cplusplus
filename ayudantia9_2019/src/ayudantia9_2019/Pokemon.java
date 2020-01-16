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
public class Pokemon {

    private String nomPokemon;
    private int puntosAtaque;
    private int puntosDefensa;
    private int velocidad;
    private int puntosVida;
    private String sexoPokemon;
    private String ataque;
    private String tipo;
    private Entrenador entrenador;

    public Pokemon(String tipo, String nomPokemon, int puntosAtaque, int puntosDefensa, int velocidad, int puntosVida, String sexoPokemon, String ataque) {
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
        this.sexoPokemon = sexoPokemon;
        this.ataque = ataque;
        this.nomPokemon = nomPokemon;
        this.tipo = tipo;
    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public String getTipo() {
        return tipo;
    }

    public Entrenador getRefEntrenador() {
        return entrenador;
    }

    public void setRefEntrenador(Entrenador E) {
        entrenador = E;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getSexoPokemon() {
        return sexoPokemon;
    }

    public void setSexoPokemon(String sexoPokemon) {
        this.sexoPokemon = sexoPokemon;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }
}
