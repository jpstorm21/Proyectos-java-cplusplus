
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class MergeSort {
    private ArrayList<Integer> ordenado;
    
    public MergeSort(int max) {
       ordenado = new ArrayList<>(max);
       
    }
   
    
    public boolean add(int dato) {
        if(this.ordenado.add(dato)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public  void mergeSort() {
       
        ArrayList<Integer> vectorOrdenado = new ArrayList<>(ordenado.size());
        mergeSort(vectorOrdenado , 0, this.ordenado.size()-1);
    }
    private void mergeSort(ArrayList<Integer> vectorOrdenado, int posMin, int posMax) {
        if( posMin == posMax) {
            // naDDDa
        } else {
            int posMedio = (posMin+posMax) / 2;
            
            mergeSort(vectorOrdenado, posMin, posMedio); // del principio al medio
            
            mergeSort(vectorOrdenado, posMedio+1, posMax); // medio a final
            
            mergeSortFinal(vectorOrdenado,posMin,posMedio+1,posMax);
            
        }
    }
    private  void mergeSortFinal(ArrayList<Integer> vectorOrdenado,int posMin, int mid , int posMax ){
        
        int auxPosMin = posMin;
        int posMedio = mid -1;
        int cantElementos = posMax - auxPosMin +1;
        int i=0;        
        while (posMin <= posMedio && mid <= posMax) {
            if(this.ordenado.get(posMin) < this.ordenado.get(mid)) {
                vectorOrdenado.add(i, this.ordenado.get(posMin));
                posMin++;
                i++;
            } else {
                vectorOrdenado.add(i, this.ordenado.get(mid));
                i++;
                mid++;
            }
        }        
        while (posMin <= posMedio) {
            vectorOrdenado.add(i, this.ordenado.get(posMin));
            i++;
            posMin++;
        }     
        while(mid <= posMax ) {
            vectorOrdenado.add(i, this.ordenado.get(mid));
            i++;
            mid++;
        }
        for(i=0; i<cantElementos; i++) {
            this.ordenado.set(auxPosMin+i, vectorOrdenado.get(i));
        }
    }
    public void display() {
        for(int n: this.ordenado) {
            System.out.print(n +" ");
        }
    }
}
