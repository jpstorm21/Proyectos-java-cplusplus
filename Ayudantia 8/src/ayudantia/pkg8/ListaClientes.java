
package ayudantia.pkg8;


public class ListaClientes {
    private int max;
    private int cantClientes;
    private Cliente [] lc;

    public ListaClientes(int max) {
        this.max = max;
        cantClientes = 0;
        lc = new Cliente[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantClientes() {
        return cantClientes;
    }

    public void setCantClientes(int cantClientes) {
        this.cantClientes = cantClientes;
    }

    public Cliente getCliente(int i) {
        return lc[i];
    }

    public void setLc(Cliente[] lc) {
        this.lc = lc;
    }
    public boolean ingresarCliente(Cliente C){
        if(cantClientes < max){
            lc[cantClientes] = C;
            cantClientes++;
            return true;
        }else{
            System.out.println("lista llena");
            return false;
        }
    }
    public Cliente buscarClienteXnombre(String nombre){
        int i;
        for(i=0;i<cantClientes;i++){
            if(lc[i].getNombre().equalsIgnoreCase(nombre)){
                break;
            }
        }
        if(i== cantClientes){
            return null;
        }else{
            return lc[i];
        }
    }
    public Cliente buscarClienteXrut(String rut){
        int i;
        for(i=0;i<cantClientes;i++){
            if(lc[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if(i== cantClientes){
            return null;
        }else{
            return lc[i];
        }
    }
    
}
