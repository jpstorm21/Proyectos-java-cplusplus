/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Usuario
 */
public class APP {

    public static void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    public static void inOrden(NodoArbol nodo) {
        if (nodo != null) {
            preOrden(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            preOrden(nodo.getDerecho());
        }
    }

    public static void posOrden(NodoArbol nodo) {
        if (nodo != null) {
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }

    public static void main(String[] args) {

        ABB abb = new ABB();
        abb.ingresarNodo(15);
        abb.ingresarNodo(10);
        abb.ingresarNodo(13);
        abb.ingresarNodo(8);
        abb.ingresarNodo(9);
        abb.ingresarNodo(11);
        abb.ingresarNodo(12);
        abb.ingresarNodo(14);
       
        /*abb.ingresarNodo(14);
        abb.ingresarNodo(11);
        abb.ingresarNodo(12);
        abb.ingresarIter(5);
        abb.ingresarIter(3);
        abb.ingresarIter(7);¨*/
        posOrden(abb.getRaiz());
        boolean des = abb.desbalanceo(abb.getRaiz());
        if (des) {
            System.out.println("arbol desbalanceado");
        } else {
            System.out.println("arbol no desbalanceado");
        }
        boolean esta = abb.buscarNodo(15, abb.getRaiz());
        if (esta) {
            System.out.println("encontrado");
        } else {
            System.out.println("no encontrado");
        }
        int mayor = abb.buscarMayor(abb.getRaiz());
        if (mayor != -1) {
            System.out.println("Mayor: " + mayor);
        } else {
            System.out.println("No hay mayor");
        }
        int menor = abb.buscarMenor(abb.getRaiz());
        if (menor != -1) {
            System.out.println("Menor: " + menor);
        } else {
            System.out.println("No hay menor");
        }

        boolean completo = abb.arbolCompleto(abb.getRaiz());
        if (completo) {
            System.out.println("Està completo");
        } else {
            System.out.println("no Està completo");
        }
        abb.imprimir(abb.getRaiz(), 1);
        System.out.println("");
        //preOrden(abb.getRaiz());
        //inOrden(abb.getRaiz());
        //posOrden(abb.getRaiz());
        int mayor2 = abb.MayorHijoIzq(10);
        if (mayor2 >= 0) {
            System.out.println("mayor hijo izquierdo 10 : " + mayor2);
        } else {
            System.out.println("no tiene");
        }
        int mayor3 = abb.MenorHijoDer(10);
        if (mayor3 >= 0) {
            System.out.println("menor hijo derecho del 10: " +mayor3);
        } else {
            System.out.println("no tiene");
        }
        int cant = abb.contarNodos(abb.getRaiz());
        System.out.println(cant);
        NodoArbol ancestro = abb.ancestroComum(7, 14);
        System.out.println("ancestro comun : " + ancestro.getDato());
        int altura = abb.calcularAltura(abb.getRaiz());
        System.out.println("la altura es: " + altura);
        /*boolean esABB = abb.esABBdcp(abb.getRaiz());
        if (esABB) {
            System.out.println("es abb");
        } else {
            System.out.println("no es abb");
        }*/
        
        int hojas = abb.contarHojas(abb.getRaiz());
        System.out.println("la cantidad de hojas: " + hojas);
    }
}
