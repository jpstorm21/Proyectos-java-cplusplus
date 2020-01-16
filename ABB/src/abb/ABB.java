package abb;

import ucn.*;

public class ABB {

    public static void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            StdOut.println(nodo.getDato());
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    public static void inOrden(NodoArbol nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierdo());
            StdOut.println(nodo.getDato());
            inOrden(nodo.getDerecho());
        }
    }

    public static void posOrden(NodoArbol nodo) {
        if (nodo != null) {
            posOrden(nodo.getIzquierdo());
            posOrden(nodo.getDerecho());
            StdOut.println(nodo.getDato());

        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(6);
        arbol.insertar(7);
        arbol.insertar(3);
        arbol.insertar(9);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.insertar(4);
        System.out.println("arbol en preOrden");
        preOrden(arbol.getRaiz());
        System.out.print(" ");
        System.out.println("arbol en inOrden");
        inOrden(arbol.getRaiz());
        System.out.print(" ");
        System.out.println("arbol en posOrden");
        posOrden(arbol.getRaiz());
        boolean encontrar = arbol.buscar(6);
        if (encontrar == true) {
            System.out.println("valor encontrado");
        } else {
            System.out.println("valor no encontrado");
        }

    }
}
