/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apparbolbinario;

import ucn.StdOut;

/**
 *
 * @author featz
 */
public class AppArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Arbol a = new Arbol();
        
        a.agregar(6);
        a.agregar(2);
        a.agregar(9);
        a.agregar(1);
        a.agregar(7);
        a.agregar(4);
        a.agregar(10);
        a.agregar(3);
        
        /*for(int i=1100;i>100;i--)
            a.agregar(i);
        
        /*StdOut.println("¿Está el 7 almacenado? ->"+a.buscar(7));
        StdOut.println("¿Está el 100 almacenado? ->"+a.buscar(101));*/
        
        StdOut.println("¿Está el 7 almacenado? ->"+a.buscarRecursivo(7));
        StdOut.println("¿Está el 101 almacenado? ->"+a.buscarRecursivo(101));
        a.imprimir();
        StdOut.println("Valor Mínimo: "+a.minimo());
        StdOut.println("Valor Máximo: "+a.maximo());
    }
}
