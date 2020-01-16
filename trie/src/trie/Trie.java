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
public class Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trie_tree t = new Trie_tree();
        t.insert("ho");
        t.insert("hol");
        t.insert("hop");
        NodeTrie resul = t.buscar("hol");
        if(resul != null){
            System.out.println("esta");
        }else{
            System.out.println("no esta");
        }
    }
    
}
