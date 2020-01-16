/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilas_backtraking;
import java.util.LinkedList; 
import java.util.List; 
/**
 *
 * @author Usuario
 */
public class Mochilas_backtraking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int peso = 10; 
        List<Objeto> listaObjetos= new LinkedList<Objeto>(); 
        listaObjetos.add(new Objeto(5,3)); 
        listaObjetos.add(new Objeto(3,5)); 
        listaObjetos.add(new Objeto(5,2)); 
        listaObjetos.add(new Objeto(1,8)); 
        listaObjetos.add(new Objeto(2,3)); 
        Mochila mochila = new Mochila(listaObjetos, peso); 
        System.out.println(mochila.toString()); 
        List<Objeto> solucion = mochila.resolver(); 
        System.out.println("Solución: " + solucion.toString()); 
    }
    
}
