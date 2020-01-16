package taller2;

public class OrdenCompra {

    private int numOrden;
    private ListaProductos lp;
    private Cliente refcliente;
    private Fecha fechaorden;
    private int i;
    private int valorTotal;
    private int [] vector;
    public OrdenCompra(int numOrden) {
        this.numOrden = numOrden;
        lp = new ListaProductos(1000);
        valorTotal= 0;
        i=0;
        vector = new int [999];
    }
    public void SumarTotal(int cantidad) {
        
     valorTotal = valorTotal + this.lp.getProducto(i).getPrecio()* cantidad;
     vector [i] = cantidad; 
     i++;
        
    }
    public int getCantidad(int i){
        return vector[i];
    }
    public int getValorTotal(){
        return valorTotal;
    }
    
    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public ListaProductos getLp() {
        return lp;
    }

    public void setLp(ListaProductos lp) {
        this.lp = lp;
    }

    public Cliente getRefcliente() {
        return refcliente;
    }

    public void setRefcliente(Cliente C) {
        refcliente = C;
    }

    public Fecha getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Fecha F) {
        fechaorden = F;
    }

}
