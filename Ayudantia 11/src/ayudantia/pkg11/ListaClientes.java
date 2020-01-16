package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class ListaClientes { //UN NEXO

    private NodoCliente first;

    public ListaClientes() {
        this.first = null;
    }

    public NodoCliente getFirst() {
        return first;
    }

    public void setFirst(NodoCliente first) {
        this.first = first;
    }

    public void ingresarCliente(Cliente C) {//MÉTODO INGRESAR AL PRINICIPIO.
        NodoCliente nuevo = new NodoCliente(C);
        if (first == null) {
            first = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    /*public void ingresarCliente(Cliente C) {//MÉTODO INGRESAR AL FINAL.
        NodoCliente nuevo = new NodoCliente(C);
        if (first == null) {
            first = nuevo;
        } else {
            first.setNext(nuevo);
        }
    }*/
    
    public Cliente buscarCliente(String rut){
        NodoCliente actual = first;
        while(actual != null && !actual.getCliente().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNext();
        }
        
        if(actual != null){
            return actual.getCliente();
        }else{
            return null;
        }
    }
    
    public boolean eliminarCliente(String rut){
        NodoCliente actual = first;
        NodoCliente prev = null;
        while(actual != null && !actual.getCliente().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNext();
        }
        
        if(actual != null){
            if(first == null){
                first = first.getNext();
                return true;
            }else{
                prev.setNext(actual.getNext());
                return true;                
            }
        }else{
            return false;          
        }  
    }
    
}
