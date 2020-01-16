
package taller2;

import ucn.StdOut;


public class ListaTiendas {
    private int max;
    private int cantiendas;
    private Tienda [] lt;

    public ListaTiendas(int max) {
        this.max = max;
        cantiendas = 0;
        lt = new Tienda[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantiendas() {
        return cantiendas;
    }

    public Tienda getTienda(int i) {
        return lt[i];
    }
     public boolean ingresarTienda(Tienda T){
        if(cantiendas < max){
            lt[cantiendas] = T;
            cantiendas++;
            return true;
        }else{
            StdOut.println("excede mazimo");
           return false;
        }
    }
     public Tienda buscarTienda(int codtienda){
        int i= 0;
        for(i = 0;i<cantiendas;i++){
            if(lt[i].getCodtienda() == codtienda){
                break;
            }
        }
        if( i == cantiendas){
            return null;
        }else{
            return lt[i];
        }
    }
}
