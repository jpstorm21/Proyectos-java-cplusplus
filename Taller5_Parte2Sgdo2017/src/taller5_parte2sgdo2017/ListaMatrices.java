/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_parte2sgdo2017;

/**
 *
 * @author Usuario
 */
public class ListaMatrices {
     private NodoMatriz first;
    private NodoMatriz last;
    
    public ListaMatrices(){
        this.first = null;
        this.last = null;
    }
    
    //Inserta al final
    public void insertarUltimo(int[][] matriz){
        NodoMatriz nuevo = new NodoMatriz(matriz);
        if (this.first == null){
            this.first = nuevo;
        }else{
            this.last.setNext(nuevo);
            nuevo.setPrev(this.last);
        }
        this.last = nuevo;
    }
    
    public NodoMatriz getFirst(){
        return first;
    }
}
