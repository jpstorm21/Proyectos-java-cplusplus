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
public class ListaPokemones {
    private NodoPokemon first;

    public ListaPokemones() {
        this.first = null;
    }

    public NodoPokemon getFirst() {
        return first;
    }

    public void setFirst(NodoPokemon first) {
        this.first = first;
    }
    
    public void ingresar(Pokemon p){
        NodoPokemon n = new NodoPokemon(p);
        if(first == null){
            first = n;
        }else{
            n.setNext(first);
            first = n;
        }
    }
    
    public Pokemon buscarPokemon(String nombre){
        NodoPokemon current = first;
        while(current != null && !current.getPokemon().getNomPokemon().equalsIgnoreCase(nombre)){
            current = current.getNext();
        }    
        if(current != null){
            return current.getPokemon();
        }else{
            return null;
        }
    }
    
    public boolean eliminarPokemon(String nombre){
        NodoPokemon current = first;
        NodoPokemon prev = null;
        while(current != null && !current.getPokemon().getNomPokemon().equalsIgnoreCase(nombre)){
            prev = current;
            current = current.getNext();
        }    
        if(current != null){
            if(current == first){
                first = first.getNext();
            }else{
                prev.setNext(current.getNext());
            }
            return true;
        }else{
            return false;
        }
    }
    
}
