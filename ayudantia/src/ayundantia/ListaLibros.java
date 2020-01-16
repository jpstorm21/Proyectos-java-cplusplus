/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayundantia;


public class ListaLibros {
    private int max;
    private int cantlibros;
    private Libro [] lb;
    public ListaLibros(int max){
     this.max = max;
    cantlibros = 0;
    lb = new Libro[max];
    
}

    public int getMax() {
        return max;
    }

    public int getCantlibros() {
        return cantlibros;
    }

    public Libro getLibro(int i) {
        return lb[i];
    }
    public boolean ingresarLibro( Libro l){
        if(cantlibros >= max){
            System.out.print("execede el maximo");
            return false;
        }else{
            lb[cantlibros]= l;
            cantlibros++;
            return true;
        }
    }
   
}
