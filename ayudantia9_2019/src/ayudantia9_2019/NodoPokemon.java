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
public class NodoPokemon {
    private NodoPokemon next;
    private Pokemon pokemon;

    public NodoPokemon(Pokemon pokemon) {
        this.next = null;
        this.pokemon = pokemon;
    }

    public NodoPokemon getNext() {
        return next;
    }

    public void setNext(NodoPokemon next) {
        this.next = next;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

  
}
