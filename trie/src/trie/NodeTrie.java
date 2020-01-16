/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author Juan Pablo Martinez
 */
public class NodeTrie {

    private String palabra;
    private ListaNodos hijos;
    
    public NodeTrie(String palabra) {
        this.palabra = palabra;
        this.hijos = new ListaNodos();
    }

    public NodeTrie() {
         this.hijos = new ListaNodos();
    }
   
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public ListaNodos getHijos() {
        return hijos;
    }

    public void setHijos(ListaNodos hijos) {
        this.hijos = hijos;
    }

}
