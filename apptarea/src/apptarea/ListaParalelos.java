/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptarea;

/**
 *
 * @author Victor Huerta
 */
public class ListaParalelos {
    private NodoParalelo firstParalelo;
    
    public ListaParalelos(){
        firstParalelo = null;
    }
    public NodoParalelo getFirstParalelo(){
        return firstParalelo;
    }
    public int cantParalelos(){
        int contador = 0;
        NodoParalelo actual = firstParalelo;
        while(actual !=null){
            actual = actual.getNextParalelo();
            contador++;
        }
        return contador++;
    }
    public Paralelo buscarParalelo(int numero){
        NodoParalelo actual = firstParalelo;
        while(actual !=null && actual.getParalelo().getNumero() != numero){
            actual = actual.getNextParalelo();
        }
        if(actual!= null){
            return actual.getParalelo();
        }else{
            return null;
        }
    }
    public void ingresarParalelo(Paralelo PL){
        NodoParalelo nuevonodo = new NodoParalelo(PL);
        nuevonodo.setNextParalelo(firstParalelo);
        firstParalelo =nuevonodo;
    }
}