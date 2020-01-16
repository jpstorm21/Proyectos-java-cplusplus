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
public class ListaNodos {
    private int cant;
    private NodeTrie [] lista;

    public ListaNodos() {
        this.cant = 0;
        this.lista = new NodeTrie[26];
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public NodeTrie getPalabra(int i) {
        return lista[i];
    }
    
    public boolean insert(String palabra){
        if (cant < 26){
            lista[cant] = new NodeTrie(palabra);
            cant++;
            return true;
        }else{
            return false;
        }
    }
    
    public NodeTrie buscar(String palabra){
        int i;
        for(i =0;i<cant;i++){
            if(lista[i].getPalabra().equalsIgnoreCase(palabra)){
                break;
            }
        }
        if(i==cant){
            return null;
        }else{
            return lista[i];
        }
    }
}
