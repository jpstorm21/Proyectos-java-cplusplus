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
public class Trie_tree {

    private NodeTrie root;

    public Trie_tree() {
        this.root = new NodeTrie();
    }

    public void insert(String palabra) {
        String x = "";
        char[] word = palabra.toCharArray();
        if (word.length == 1) {
            NodeTrie aux = root.getHijos().buscar(palabra);
            if (aux == null) {
                this.root.getHijos().insert(palabra);
            }
        } else {
            NodeTrie aux = this.root.getHijos().buscar(String.valueOf(word[0]));
            NodeTrie n = null;
            if (aux == null) {
                n = insertRec(String.valueOf(word[0]), root);
            } else {
                n = buscarRec(String.valueOf(word[0]), root);
            }
            x += n.getPalabra();
            for (int i = 1; i < word.length; i++) {
                x += String.valueOf(word[i]);
                NodeTrie aux2 = n;
                n = insertRec(x, aux2);
            }
        }
    }

    public NodeTrie insertRec(String p, NodeTrie nodo) {
        NodeTrie aux = nodo.getHijos().buscar(p);
        if (aux == null) {
            nodo.getHijos().insert(p);
        }
        aux = nodo.getHijos().buscar(p);
        return aux;
    }

    public NodeTrie buscarRec(String p, NodeTrie nodo) {
        NodeTrie aux = nodo.getHijos().buscar(p);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }
    }

    public NodeTrie buscar(String palabra) {
        String x = "";
        char[] word = palabra.toCharArray();
        NodeTrie resul = null;
        if (word.length == 1) {
            NodeTrie aux = buscarRec(String.valueOf(word[0]), root);
            if (aux != null) {
                resul = aux;
            }
            return resul;
        } else {
            NodeTrie aux = this.root.getHijos().buscar(String.valueOf(word[0]));
            NodeTrie n = null;
            if (aux != null) {
                resul = aux;
            }
            x += resul.getPalabra();
            for (int i = 1; i < word.length; i++) {
                x += String.valueOf(word[i]);
                NodeTrie aux2 = resul;
                n = buscarRec(x, aux2);
                if(n != null){
                    resul = n;
                }else{
                    resul = null;
                }
            }
            return resul;
        }
    }

}
