
package taller2;


public class ListaProductos {
    private int max;
    private int cantp;
    private Producto [] lp;

    public ListaProductos(int max) {
        this.max = max;
        cantp = 0;
        lp = new Producto[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantp() {
        return cantp;
    }

    public Producto getProducto(int i) {
        return lp[i];
    }
    public boolean ingresarProducto(Producto P){
        if(cantp> max){
            System.out.print("excede el maximo");
            return false;
        }else{
            lp[cantp] = P;
            cantp++;
           return true;
        }
    }
     public Producto buscarOrden(String codproducto){
        int i= 0;
        for(i = 0;i<cantp;i++){
            if(lp[i].getCodproducto().equalsIgnoreCase(codproducto)){
                break;
            }
        }
        if( i == cantp){
            return null;
        }else{
            return lp[i];
        }
    }
}
