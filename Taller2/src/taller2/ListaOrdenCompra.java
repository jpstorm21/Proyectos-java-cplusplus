
package taller2;


public class ListaOrdenCompra {
    private int max;
    private int cant;
    private OrdenCompra [] lo;

    public ListaOrdenCompra(int max) {
        this.max = max;
        cant = 0;
        lo = new OrdenCompra[max];
    }

    public int getMax() {
        return max;
    }

    public int getCant() {
        return cant;
    }

    public OrdenCompra getOrden(int i) {
        return lo[i];
    }
    public boolean ingresarOrden(OrdenCompra O){
        if(cant> max){
            System.out.print("excede el maximo");
            return false;
        }else{
            lo[cant] = O;
            cant++;
           return true;
        }
    }
     public OrdenCompra buscarOrden(int numOrden){
        int i= 0;
        for(i = 0;i<cant;i++){
            if(lo[i].getNumOrden() == numOrden){
                break;
            }
        }
        if( i == cant){
            return null;
        }else{
            return lo[i];
        }
    }
}
