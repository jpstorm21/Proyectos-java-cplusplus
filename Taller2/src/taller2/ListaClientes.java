
package taller2;


public class ListaClientes {
    private int max;
    private int cantclientes;
    private Cliente [] lc;

    public ListaClientes(int max) {
        this.max = max;
        cantclientes = 0;
        lc = new Cliente[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantclientes() {
        return cantclientes;
    }

    public Cliente getCliente(int i) {
        return lc[i];
    }
     public boolean ingresarCliente(Cliente C){
        if(cantclientes >= max){
            System.out.print("excede el maximo");
            return false;
        }else{
            lc[cantclientes] = C;
            cantclientes++;
           return true;
        }
    }
     public Cliente buscarCliente(String rut){
        int i= 0;
        for(i = 0;i<cantclientes;i++){
            if(lc[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if( i == cantclientes){
            return null;
        }else{
            return lc[i];
        }
    }
    
}
