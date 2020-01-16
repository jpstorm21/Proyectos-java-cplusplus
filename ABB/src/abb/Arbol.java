package abb;

public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz,dato);
    }

    private static NodoArbol insertarRecursivo(NodoArbol nodo, int dato) {
       if(nodo == null){
           nodo = new NodoArbol(dato);
       }
       if(nodo.getDato() > dato){
           nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(),dato));
       }
       if(nodo.getDato()< dato){
           nodo.setDerecho(insertarRecursivo(nodo.getDerecho(),dato));
       }
       return nodo;
    }

    public boolean buscar(int valorBuscado) {
        return buscarRecursivo(raiz, valorBuscado);
    }

    public static boolean buscarRecursivo(NodoArbol nodo, int valorBuscado) {
        if(nodo==null){
            return false;
        }
        if(nodo.getDato()== valorBuscado){
            return true;
        }
        if(nodo.getDato()>valorBuscado){
            return buscarRecursivo(nodo.getIzquierdo(),valorBuscado);
        }
        return buscarRecursivo(nodo.getDerecho(),valorBuscado);
    }

    

    public NodoArbol getRaiz() {
        return raiz;
    }
}
